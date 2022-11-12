package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Hotels_AI {
    public static void main(String[] args) throws InterruptedException{

        //define the webdriver manager setup for chromedriver
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

//define the chrome driver to use for your test
//creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);


//        //Destination to book hotels at
//        ArrayList<String> destination = new ArrayList<>();
//        destination.add("New York");
//        destination.add("Boston");
//        destination.add("Miami");
//
//        for (int i = 0; i<destination.size(); i++) {


                //Navigating to weight watcher site
                driver.navigate().to("https://www.hotels.com");

                //Adding a wait for all elements to load
                Thread.sleep(1000);

                //Locating search field and clicking on it
                try {
                    driver.findElement(By.xpath("//*[contains(@class,'uitk-typeahead-menu')]")).click();
                } catch (Exception e) {
                    //Print out exception if not found
                    System.out.println("Unable to find click search field" + e);
                }

                //Send keys to search field
                try{
                    driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys("New York");
                }
                //Print out exception if unable to send keys
                catch(Exception e) {
                    System.out.println("Unable to send key" + e);
                }

                //Select city from drop down
                try{
                    driver.findElements(By.xpath("//*[contains(@class,'uitk-button-fullWidth uitk-button-typeahead')]")).get(0).click();
                } catch(Exception e) {
                    //Printout exception if unable to select city from drop down
                    System.out.println("Unable to select search result option" + e);
                }

                //Locate travelers field and click on it
                try{
                    driver.findElement(By.xpath("//*[contains(@class,'uitk-menu-trigger uitk-fake-input')]")).click();
                } catch(Exception e) {
                    //Printout exception if unable to find and click travelers field
                    System.out.println("Unable to click travelers field" + e);
                }

                //wait for page to load
                Thread.sleep(1000);

                //Creating ArrayList to be able to click plus/minus on screen
                ArrayList <WebElement> plusMinusButton = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'uitk-icon uitk-step-input-icon')]")));
                //Click on plus/minus button
                try{
                    plusMinusButton.get(1).click();
                } catch(Exception e) {
                    //Printout exception if unable to click on plus/minus button
                    System.out.println("Unable to click plus minus button");
                }

                //Wait for page to load
                Thread.sleep(1000);

                // Clicking the plus to increase children to 1
                try{
                    plusMinusButton.get(3).click();
                } catch(Exception e) {
                    //Printout exception if unable increase children
                    System.out.println("Unable to increase children count" + e);
                }

                //Wait for page to load
                Thread.sleep(1000);

                //Clicking on child age drop down
                try{
                    driver.findElement(By.xpath("//*[contains(@id,'children_age_selector')]")).click();
                } catch(Exception e) {
                    //Printout exception if unable to click on dropdown
                    System.out.println("Unable to click children age selector dropdown" + e);
                }

                //wait for page to load
                Thread.sleep(1000);

                WebElement cAgeDropDown = driver.findElement(By.xpath("//*[contains(@id,'age-traveler_selector_children_age')]"));
                try{
                    Select childAgeDropDown = new Select(cAgeDropDown);
                    //Select the 1 from drop down
                    childAgeDropDown.selectByVisibleText("1");
                } catch (Exception e){
                    //Printout exception if unable to select 1 child
                    System.out.println("Unable to select age from drop down" + e);
                }

                //Click on done button
                try{
                    driver.findElement(By.xpath("//*[contains(@id,'done_button')]")).click();
                }
                catch (Exception e){
                    //Printout exception if unable to click done button
                    System.out.println("Unable to click on done button" + e);
                }

                //Click on magnify(search) icon
                try{
                    driver.findElement(By.xpath("//*[contains(@class,'layout-flex-item-flex-grow-0')]")).click();
                }
                catch (Exception e){
                    //Printout exception if unable to click on magnify(search) icon
                    System.out.println("Unable to click on search icon");
                }

                //Wait for page to load
                Thread.sleep(5000);

                //Creating arraylist of all hotels that loaded for the searched city
                ArrayList<WebElement> hotelSites = new ArrayList(driver.findElements(By.xpath("//*[contains(@class,'all uitk-card-has-primary')]")));
                //Clicking on hotel
                try{
                    hotelSites.get(0).click();
                } catch (Exception e){
                    //Printout exception if unable to click on hotel
                    System.out.println("Unable to click on hotel link" + e);
                }

                //Wait for page to load
                Thread.sleep(2000);

                //Storing tabs in ArrayList
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

                //Switch to new tabs
                driver.switchTo().window(tabs.get(1));

                //Capturing name of hotel printing it out
                String hotelName = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0).getText();
                System.out.println("The name of the hotel is " + hotelName);

                //Wait for page to load
                Thread.sleep(2000);

                //Clicking on reserve a room button
                try{
                    driver.findElement(By.xpath("//*[contains(@class,'m uitk-button-has-text uitk-button-p')]")).click();
                }
                catch (Exception e){
                    //Printout exception if unable to click on reserve a room button
                    System.out.println("Unable to click reserve a room" + e);
                }

                //Wait on page to load
                Thread.sleep(1000);

                //Capturing check in and check out dates
                String checkIn = driver.findElements(By.xpath("//*[@id='hotels-check-in-btn']")).get(0).getText();
                String checkOut = driver.findElements(By.xpath("//*[@id='hotels-check-out-btn']")).get(0).getText();

                //Printing check in/out date
                System.out.println("The check in date is " + checkIn + " and the check out date is " + checkOut);

                //Closing the page
                driver.close();

                //Switch to first tab
                driver.switchTo().window(tabs.get(0));

                //Quitting the driver
                driver.quit();

//        }//End of loop


            }//End of main
        }//End of class
