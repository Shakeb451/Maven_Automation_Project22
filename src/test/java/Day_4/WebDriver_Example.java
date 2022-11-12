package Day_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class WebDriver_Example {
    public static void main(String[] args) throws InterruptedException {

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //define the chrome driver to use for test
        //clearing an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();

        //naviagte to the google site
        driver.navigate().to("https://www.google.com");

        //wait few second
        Thread.sleep(3000);

        //quit the chrome driver
        driver.quit();





    }//end of main
}//end of java