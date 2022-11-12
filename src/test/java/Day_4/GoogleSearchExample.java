package Day_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchExample {
    public static void main(String[] args) throws InterruptedException {

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //define the chrome driver to use for test
        //clearing an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver();

        //naviagte to the google site
        driver.navigate().to("https://www.google.com");

        //maximize my window
        //for windows os
        driver.manage().window().maximize();

        //for mac os
        //driver.manage().window().fullscreen();

        //wait few second
        Thread.sleep(3000);


        //search a keyword on the search field
        //relative xpath to locate the element
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //wait few second
        Thread.sleep(3000);

        //quit the chrome driver
        driver.quit();








    }//end of main
}//end of java
