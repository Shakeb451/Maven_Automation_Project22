package Day_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Find_Elements {
    public static void main(String[] args) throws InterruptedException {
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
        driver.navigate().to("http://www.yahoo.com");

        //wait 3 seconds
        Thread.sleep(3000);

        //using find elements i want to click on second link within the group which is news
        driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(1).click();



    }//end of main
}//end of java
