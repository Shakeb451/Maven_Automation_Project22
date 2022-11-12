package Day_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTextContains {


    public static void main(String[] args) throws InterruptedException{
        //setup your chrome driver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com");

        //maximize the driver
        driver.manage().window().maximize();

        //click on sign in button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();

        //wait 3 seconds
        Thread.sleep(3000);

        //go to yahoo home page
        driver.navigate().to("http://www.yahoo.com");

        //Wait 2 seconds
        Thread.sleep(2000);

        //click on the bell icon
        driver.findElement(By.xpath("//*[contains(@class,'rapid-nonanchor')]")).click();

        //Wait 3 seconds
        Thread.sleep(3000);

        //quit chrome
        driver.quit();



    }//end of main
}//end of java
