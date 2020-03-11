package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    static WebDriver driver;
    public static void main(String[] args) {
        //  WebDriver driver = BrowserFactory.getDriver("chrome");
      //  WebDriverManager.chromedriver().version("79").setup();
      //  WebDriver driver=new ChromeDriver();

        List<String> urls = Arrays.asList("https://luluandgeorgia.com","https://wayfair.com/",
                "https://walmart.com","https://www.westelm.com/");
        //the first link was incorrect->https://luluandgeorgia.com,
        //"https://walmart.com" and "https://westelm.com/" were incorrect either.(it got fixed it manually)
        for (String url : urls) {
            WebDriverManager.chromedriver().version("79").setup();
            WebDriver driver=new ChromeDriver();
            driver.get(url);
            SetUpTime.waitFor(2);
            System.out.println(driver.getTitle());

            if(url.contains(driver.getTitle().replace(" ","").toLowerCase() ) ){
                System.out.println("Test passed");
            }else{
                System.out.println("Test Failed");
            }
        }

        SetUpTime.waitFor(2);
        driver.quit();
    }
}