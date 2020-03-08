package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


public class NavigationTests {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver1= BrowserFactory.getDriver("chrome");

        driver1.get("http://google.com");
        String title1=driver1.getTitle();
        System.out.println("Title is: "+title1);
        Thread.sleep(2000);

       driver1.get("http://etsy.com");
       String title2= driver1.getTitle();
       System.out.println("Second title is: "+title2);
       Thread.sleep(2000);

       driver1.navigate().back();
       Thread.sleep(2000);
       String expectedTitle="Google";
       if(expectedTitle.equalsIgnoreCase(title1)){
           System.out.println("Test passed");
       }else{
           System.out.println("Test failed");
       }

       Thread.sleep(2000);
       driver1.navigate().forward();
       if(expectedTitle.equalsIgnoreCase(title2)){
           System.out.println("Test Passed");
       }else{
           System.out.println("Test Failed");
       }
        driver1.close();

       WebDriverManager.firefoxdriver().version("79").setup();
       WebDriver driver2=BrowserFactory.getDriver("firefox");
       driver2.get("http://google.com");
       String title3=driver2.getTitle();
       Thread.sleep(2000);

       driver2.get("http://etsy.com");
       String title4=driver2.getTitle();


    }
}
