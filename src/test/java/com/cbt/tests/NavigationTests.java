package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;


public class NavigationTests {
    public static void main(String[] args) throws InterruptedException {
        chromeTest();
       fireFoxTest();
        safariTest();

       
    }
    public static void chromeTest() throws InterruptedException {
        //1. open browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
      //2. go to website http://google.com
        driver.get("http://google.com");
        //3. save the title in a string variable
        String title1= driver.getTitle();
        System.out.println("title 1: "+title1);
        Thread.sleep(2000);

        //4. go to http://etsy.com
        driver.get("http://etsy.com");
        //5. save the title in a string variable
        String title2= driver.getTitle();
        System.out.println("title 2: "+title2);
        Thread.sleep(2000);

        //6. Navigate back to previous page
        driver.navigate().back();
        //7. verify that title is same is in step 3
        StringUtility.verifyEquals(title1,driver.getTitle());
        Thread.sleep(2000);

        //8. Navigate forward to previous page
        driver.navigate().forward();
        //9. verify that title is same is in step 5
       StringUtility.verifyEquals(title2,driver.getTitle());
        Thread.sleep(2000);

        driver.close();
    }
    public static void fireFoxTest() throws InterruptedException {

        //1. open browser
        WebDriver driver=BrowserFactory.getDriver("firefox");
        // Go to website http://google.com
        driver.get("http://google.com");
        //3. Save the title in a string variable
        String titleGoogle= driver.getTitle();
        System.out.println(titleGoogle);
        Thread.sleep(3000);

        //4. go to http:etsy.com
        driver.get("http://etsy.com");
        //5. save the title in a string variable
        String titleEtsy= driver.getTitle();
        System.out.println(titleEtsy);
        Thread.sleep(3000);

        //6. Navigate back to previous page
        driver.navigate().back();
        //7. verify that title is same is in step 3
        StringUtility.verifyEquals(titleGoogle,driver.getTitle());
        Thread.sleep(3000);
        //8. Navigate forward to previous page
        driver.navigate().forward();
        //9. verify that title is same is in step 5
        StringUtility.verifyEquals(titleEtsy,driver.getTitle());

        driver.close();

    }
    public static void safariTest() throws InterruptedException {

        //1. open the browser
        WebDriver driver=BrowserFactory.getDriver("safari");
        //2. go to website http://google.com
        driver.get("http://google.com");
        //3. save the title in a string variable
        String titleOfGoogle= driver.getTitle();
        System.out.println(titleOfGoogle);
        Thread.sleep(2000);

        //4. go to http://etsy.com
        driver.get("http://etsy.com");
        //5. save the title in a string variable
        String titleOfEtsy=driver.getTitle();
        System.out.println(titleOfEtsy);
        Thread.sleep(2000);

        //6. Navigate to back the previous page
        driver.navigate().back();
        //7. verify the title as same as in step 5
       StringUtility.verifyEquals(titleOfGoogle,driver.getTitle());
       //8. Navigate to forward to the previous page
        driver.navigate().forward();
        //9. verify the title as same as in step 5
        StringUtility.verifyEquals(titleOfEtsy,driver.getTitle());

        driver.close();
        System.out.println("driver closed");
    }
}



