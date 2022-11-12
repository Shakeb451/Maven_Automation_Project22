package Day_11;

import Reuseable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WebElements_List {
    public static void main(String[] args) {
        WebDriver driver;
        ArrayList<WebElement> totalMenuHeaders, mainMenuHeaders;
        @BeforeSuite
        public void SetChromeDriver() {
            Reusable_Actions ReusableActions;
            driver = Reusable_Actions.setUpDriver();
            //navigate to usps.com home page
            driver.navigate().to("https://www.usps.com/");
            //store all the elements of the menu header into an arraylist of webelements
            totalMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'nav-list']/li")));
        }//end of set driver method

        @AfterSuite
        public void quitTheSession() {
            driver.quit();
        }//end of after suite

// Test Case 1 should verify the total count of the displayed menu headers
            @Test(priority = 1)
            public void tc001_verifyTotalCount0fMenuHeaders () {
                System.out.printin("The total number of menu headers is: " + totalMenuHeaders.size());
            }//end of test 1
//click on the first dropdown
            (Test(priority = 2)
            public void tc002_clickOnTheFirstDropDown () {
                totalMenuHeaders.get(0).click0;
            }//end of test 2
                    //verify the sub menu headers
            @Test(priority = 3)
            public void tc003_verifyCount0fMainMenuHeaders() {
                mainMenuHeaders = new ArrayList<>(driver.findElements (By.xpath ( xpathExpression: "//*[@class = 'menuheader' ]"))) ;
                System.out.println("The total number of main menu headers is:
                        " + mainMenuHeaders.size());
        }//end of test 3

            }//end of class

    }
}//end of java
