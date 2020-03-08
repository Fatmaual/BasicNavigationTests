package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserFactory {
  public static WebDriver getDriver(String driverName){

    if(driverName.equalsIgnoreCase("chrome")){
      WebDriverManager.chromedriver().version("79.0").setup();
      return new ChromeDriver();

    }else if(driverName.equalsIgnoreCase("firefox")){
      WebDriverManager.firefoxdriver().version("79.0").setup();
      return new FirefoxDriver();

    }else if(driverName.equalsIgnoreCase("IE")){
      WebDriverManager.iedriver().version("79.0").setup();
      return new InternetExplorerDriver();


    }else if(driverName.equalsIgnoreCase("opera")){
      WebDriverManager.operadriver().version("79.0").setup();
      return new OperaDriver();

    }else{


    }

    return null;

  }

}
