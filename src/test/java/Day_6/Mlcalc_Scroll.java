package Day_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Mlcalc_Scroll {
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

        //go to google page
        driver.navigate().to("http://www.mlcalc.com");

        //wait 3 seconds
        Thread.sleep(3000);

        //define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll down to 800 pixels
        jse.executeScript("scroll(0,800)");

        //wait 3 seconds
        Thread.sleep(3000);

        //scroll down to 400 pixels
        jse.executeScript("scroll(0,-400)");

        //wait 3 seconds
        Thread.sleep(3000);

        //store calculate button into webelement variable
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value='Calculate']"));

        //scroll into view of calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);

        //wait 2 secs
        Thread.sleep(2000);

        //quit chrome driver
        driver.quit();



    }//end of main
}//end of java
