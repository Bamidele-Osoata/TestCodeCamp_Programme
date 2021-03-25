package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;


import java.util.concurrent.TimeUnit;

public class LoginTests {

    private WebDriver driver;

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();

        //fetch URL to automate
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);

        // maximize the page of your browser while page loads
        driver.manage().window().maximize();

        // get page title
        System.out.println(driver.getTitle());

        // make page wait while url fully loads
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);

        //click on login/signup button
        driver.findElement(By.linkText("Login / Signup")).click();

        //Enter username
        driver.findElement(By.id("username")).sendKeys("konga@mailinator.com");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("Konga@1815");

        //Click on Login
        driver.findElement(By.xpath("//button[text() = 'Login']")).click();

        //Wait, so the next operation won't happen so fast
        Thread.sleep(5000);

        //Mouseover Computers and Accessories Category
        WebElement computersAndAccessories = driver.findElement(By.linkText("Computers and Accessories"));
        actions.moveToElement(computersAndAccessories).perform();

        //click laptops
        WebElement Laptops = driver.findElement(By.linkText("Laptops"));
        actions.click(Laptops).perform();
        Thread.sleep(5000);

        //Click on the Laptops subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/section/div/section/div[2]/div[2]/ul/li[5]/a/label/span")).click();
        Thread.sleep(5000);

        //Click on the Apple MacBooks button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000);

        //Click on the Add to cart button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/section/section/section/ul/li[9]/div/div/div[2]/form/div[4]/button")).click();
        Thread.sleep(5000);

        //Click on the My Cart menu button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[2]/div/div/a[2]")).click();
        Thread.sleep(5000);

        //Click on Checkout
        driver.findElement(By.xpath("//button[@class='_0a08a_3czMG' and text() = 'Checkout']")).click();
        Thread.sleep(5000);



        //Click to Use this Address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);

        //Select the Paynow
        driver.findElement(By.xpath("//button[@class = '_0a08a_3czMG _4a291_2cOtr' and @name = 'selectPaymentMethod']")).click();
        Thread.sleep(5000);

        //Click on the Continue to Payment button
        driver.findElement(By.xpath("//button[@class = '_0a08a_3czMG' and @name='placeOrder']")).click();
        Thread.sleep(5000);

        //Select iframe that comes up for payment
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(5000);

        //Click on the card option
        driver.findElement(By.xpath("//button[@class = 'dashboard-card__button Card']")).click();
        Thread.sleep(5000);

        //Enter the card number
        driver.findElement(By.xpath("//input[@class = 'card-number input_class' and @id = 'card-number']")).sendKeys("0012553212211");

        //Enter Expiry Date
        driver.findElement(By.xpath("//input[@class = 'date input_class' and @id = 'expiry']")).sendKeys("1025");

        //Enter CVV
        driver.findElement(By.xpath("//input[@class = 'cvv input_class' and @id = 'cvv']")).sendKeys("530");

        //Click on the Pin input box
        driver.findElement(By.xpath("//input[@class = 'card-pin' and @id = 'card-pin-new']")).click();

        //Enter Pin
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '1']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '0']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '0']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '7']")).click();

        //Select the PAY NOW Option
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(5000);

        //Print error message of card number field
        WebElement error = driver.findElement(By.xpath("//label[@id='card-number_unhappy' and text() = 'Invalid card number']"));
        String errorPrint = error.getText();
        System.out.println(errorPrint);

        //Close iframe for input card modal
        driver.findElement(By.className("data-card__close")).click();

        //Mouseover MyAccount
        WebElement MyAccount = driver.findElement(By.linkText("MyAccount"));
        actions.moveToElement(MyAccount).perform();

        //click logout
        WebElement Logout = driver.findElement(By.linkText("Logout"));
        actions.click(Logout).perform();
        Thread.sleep(5000);

    }

    public static void main(String args[]) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setUp();

    }
}








