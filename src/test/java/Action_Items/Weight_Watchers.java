package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Weight_Watchers {
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

        //create sets of array list for zipCodes
        ArrayList<String> zipCodes;
        zipCodes = new ArrayList<>();
        zipCodes.add("11218");
        zipCodes.add("11219");
        zipCodes.add("14215");

        //create array list for the links
        ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'linkUnderline-1_h4g')]")));


        for (int i=0; i < zipCodes.size(); i++) {
            //go to google page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //wait 2 seconds
            Thread.sleep(2000);

            //click on Find Workshop link
            driver.findElement(By.xpath("//*[contains(@class,'button-3Flv2 menuItemLink-3a5rS menuItem-2uNa6 noStyle-1O4pY')]")).click();

            //wait 2 seconds
            Thread.sleep(2000);

            //click on In person link
            driver.findElement(By.xpath("//*[contains(@class,'buttonText-3DCCO')]")).click();

            //wait 2 seconds
            Thread.sleep(2000);

            //clear and enter zipcode in the search for location zipcode or city
            WebElement zCodes = driver.findElement(By.xpath("//*[@Class='input input-3TfT5']"));

            //clear the zip codes
            zCodes.clear();

            //type new value on the purchase price
            zCodes.sendKeys(zipCodes.get(i));

            //click on search button
            driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();

            //wait 2 seconds
            Thread.sleep(2000);

            //using find elements i want to click on second link within the group
          //driver.findElements(By.xpath("//*[contains(@href,'WW Studio @ Knights of CS Hall Brooklyn NY')]")).get(0).click();

            //creating if statements
            if (i==0){
                links.get(1).click();
            } else if (i==1){
                links.get(2).click();
            } else if (i==2){
                links.get(0).click();
            }//end of if statements

            //wait 2 seconds
            Thread.sleep(2000);




        }//end of loop

        //quit driver
        driver.quit();

    }//end of main
}//end of java
