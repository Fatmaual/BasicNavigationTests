package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                                          "http://practice.cybertekschool.com/dropdown",
                                          "http://practice.cybertekschool.com/login");


        List<String> urls2 = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/",
                "https://walmart.com, ","https://westelm.com/");

    }
}
