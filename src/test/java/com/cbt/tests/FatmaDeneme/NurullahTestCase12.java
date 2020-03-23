package com.cbt.tests.FatmaDeneme;

import com.cbt.utilities.SetUpTime;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NurullahTestCase12 {
    /**
     * Test case #12
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 3. And click on “Status Codes”.
     * Step 4. Then click on “500”.
     * Step 5. Verify that following message is displayed:
     * “This page returned a 500 status code”
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
  //   <a href="/status_codes">Status Codes</a>
  //a[text()='Status Codes'] -->for status code
  // //a[contains(text(),'Status Codes')]-->linktext
        SetUpTime.waitFor(2);
        driver.quit();
    }
}
