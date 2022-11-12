package Day_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_Statements {
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

        //wait 2 seconds
        Thread.sleep(2000);

        //click advance option dropdown
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();

        //wait 2 seconds
        Thread.sleep(2000);

        //use select command for month dropdown
        WebElement strtMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select startMonthDropDown = new Select(strtMonth);

        //select by visible text
        startMonthDropDown.selectByVisibleText("Nov");

        //use select command for year dropdown
        WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
        Select startYearDropDown = new Select(startYear);

        //select by visible text
        startYearDropDown.selectByVisibleText("2023");

        driver.findElement(By.xpath("//*[@name='sy']")).click();

        driver.findElement(By.xpath("//*[text()='2023']")).click();

        //quit driver
        driver.quit();




    }//end of main
}//end of java
