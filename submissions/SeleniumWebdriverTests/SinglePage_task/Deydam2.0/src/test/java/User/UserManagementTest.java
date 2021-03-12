package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTest {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        //fetch the chromeDriver.exe file
        System.setProperty ("webdriver.chrome.driver","resources/chromedriver");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website URL
        driver.get ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");
        //Wait for the page to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window ().fullscreen ();
        //Get page title
        System.out.println(driver.getTitle ());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginTest() throws InterruptedException {
        //Click on the username field and input a valid username "performancetest"
        driver.findElement(By.id("username")).sendKeys("performancetest");
        //Click on the password field and input a valid password "admin123."
        driver.findElement(By.id("password")).sendKeys("admin123.");
        //click on the login button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")) {
            System.out.println("PASSED - User has successfully logged in");
        }else {
            System.out.println("Failed - The user was unable to login");
        }
        Thread.sleep(5000);
    }
    @Test
    public void logoutTest() throws InterruptedException {
        //Click on the user profile
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Log Out")).click();
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login")) {
            System.out.println("PASSED - User has successfully logged out");
        }else {
            System.out.println("Failed - The user is still logged in");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
