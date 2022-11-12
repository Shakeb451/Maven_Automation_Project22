package Day_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Mlcalc_forloop {
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

        //create sets of array list for purchase price, down payment, interest rate
        ArrayList<String> purchasePrice, downPayment, interestRate;
        purchasePrice = new ArrayList<>();
        purchasePrice.add("350000");
        purchasePrice.add("370000");
        purchasePrice.add("380000");

        //down payment arraylist
        downPayment = new ArrayList<>();
        downPayment.add("25");
        downPayment.add("30");
        downPayment.add("35");

        //interestRate
        interestRate = new ArrayList<>();
        interestRate.add("3.4");
        interestRate.add("4.1");
        interestRate.add("2.8");


        for (int i=0; i < interestRate.size(); i++) {
        //go to google page
        driver.navigate().to("http://www.mlcalc.com");

        //wait 3 seconds
        Thread.sleep(3000);

        //clear and enter a new value on purchase price field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));

            //clear the purchase price
            pPrice.clear();
            //type new value on the purchase price
            pPrice.sendKeys(purchasePrice.get(i));

            //clear and enter a new value on down payment field
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            //clear the down payment
            dPayment.clear();
            //type new value on the down payment
            dPayment.sendKeys(downPayment.get(i));

            //clear and enter a new value on interest rate field
            WebElement intRate = driver.findElement(By.xpath("//*[@name='ir']"));
            //clear the down payment
            intRate.clear();
            //type new value on the down payment
            intRate.sendKeys(interestRate.get(i));

            //click on calculate button
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();

            Thread.sleep(3000);

            //capture and print monthly payment value
            String mntPayment = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
            System.out.println("Monthly payment: " + mntPayment);

        }//end of for loop

    }//end of main
}//end of java
