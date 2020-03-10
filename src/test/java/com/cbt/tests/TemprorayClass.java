package com.cbt.tests;

import com.cbt.utilities.SetUpTime;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TemprorayClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver= new ChromeDriver();
        //open the chrome and go to cybertekschool webSite:
        driver.get("https://practice.cybertekschool.com/sign_up");

        //go to search button and write your name:


        SetUpTime.waitFor(2);
        driver.quit();
    }
}
