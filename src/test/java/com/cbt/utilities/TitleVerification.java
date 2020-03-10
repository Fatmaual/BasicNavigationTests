package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com",
                "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
        
     String currentWebsite = "http://practice.cybertekschool.com";

    String expectedTitle="Practice";

        for (String url : urls) {
            driver.get(url);
            SetUpTime.waitFor(2);
            if (url.startsWith(currentWebsite) && driver.getTitle().equalsIgnoreCase(expectedTitle)) {
                System.out.println("Test Passed");
              System.out.println("All pages are starting with: " + currentWebsite);
               System.out.println("they all have the same title: " + expectedTitle);
           } else {
               System.out.println("Test Failed");
                System.out.println("All pages are not starting with: " + currentWebsite);
            }
        }

        SetUpTime.waitFor(2);
        driver.quit();
    }

}