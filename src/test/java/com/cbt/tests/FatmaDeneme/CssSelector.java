package com.cbt.tests.FatmaDeneme;
import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.SetUpTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CssSelector {

public static void main(String[] args) {

    WebDriver driver=BrowserFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/");
    SetUpTime.waitFor(3);

    WebElement multipleBtn= driver.findElement(By.xpath("//a[text()+'Multiple Buttons']"));
            //driver.findElement(By.linkText("Multiple Buttons"));
    multipleBtn.click();
    SetUpTime.waitFor(2);

    driver.quit();

    }
}
