package Day_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElements_mlcalc {
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

        //clear and enter a new value on purchase price field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));

        //clear the purchase price
        pPrice.clear();

        //type new value on the purchase price
        pPrice.sendKeys("450000");

        //clear and enter a new value on down payment field
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));

        //clear the down payment
        dPayment.clear();

        //type new value on the down payment
        dPayment.sendKeys("25");



    }//end of main
}//end of java
