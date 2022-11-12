package Day_10;

import Reuseable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class BingReuseable_Actions {
    public static void main(String[] args) throws InterruptedException {
        //calling reusable method for set driver
        WebDriver driver = Reusable_Actions.setUpDriver();

        //navigate
        driver.navigate().to("https://www.bing.com");

        //enter a keyword in search field using reusable method
        Reusable_Actions.sendKeysAction(driver,"//*[@name='q']","soccer","Search Field");

        //click on search icon using reusable method
        Reusable_Actions.clickAction(driver,"//*[@id='search_icon']","Search Icon");

        //capture the result and extract out the number
        String result = Reusable_Actions.getTextAction(driver,"//*[@class='sb_count']","Search Results");
        System.out.println("Result is " + result);

        //wait 2 seconds
        Thread.sleep(2000);

        //quit driver
        driver.quit();

    }//end of main

}//end of java

