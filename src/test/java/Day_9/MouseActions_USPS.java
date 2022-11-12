package Day_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions_USPS {
    public static void main(String[] args) throws InterruptedException{

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window
        options.addArguments("start-maximized","incognito");
        //options.addArguements("headless")
        //for mac use "start-fullscreen"
        //if above does not work for mac, then try --kiosk
        //options.addArguements("start-fullscreen")
        //options.addArguements("--kiosk")


        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);


        //navigate to usps home page
        driver.navigate().to("https://www.usps.com");

        //Wait 2 seconds
        Thread.sleep(2000);

        //hover over to Send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));

        //declare mouse actions
        Actions actions = new Actions(driver);

        //always end with .perform()
        actions.moveToElement(sendTab).perform();

        //wait 1 second
        Thread.sleep(1000);

        //click on calculate a price using mouse click
        WebElement calculatePrice = driver.findElement(By.xpath("//li[@class='tool-calc']"));
        actions.moveToElement(calculatePrice).click().perform();
        //wait 2 seconds
        Thread.sleep(2000);

        //double click on usps home logo
        WebElement uspsHome = driver.findElement(By.xpath("//*[@alt='USPS.com home']"));

        //right-clicking on usps home logo
        actions.moveToElement(uspsHome).contextClick().perform();

        //double-clicking on usps home logo
        actions.moveToElement(uspsHome).doubleClick().perform();




    }//end of main
}//end of java
