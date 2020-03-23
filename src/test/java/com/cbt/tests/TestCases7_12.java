package com.cbt.tests;

import com.cbt.utilities.SetUpTime;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases7_12 {
    /**
     * Test case #7
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. And click on “File Upload".
     * Step 3. Upload any file with .txt extension from your computer.
     * Step 4. Click “Upload” button.
     * Step 5. Verify that subject is: “File Uploaded!”
     * Step 6. Verify that uploaded file name is displayed.
     * Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
     * Run this method against “Choose File” button.
     * */
  private WebDriver driver;
  private String URL="https://practice-cybertekschool.herokuapp.com";
  private By fileUpload=By.linkText("File Upload");
  private By chooseFile=By.id("file-upload");
  private By uploadButton=By.id("file-submit");
  private By showFileUpload=By.xpath("//h3[text()='File Uploaded!']");
  private By displayMyFile=By.id("uploaded-files");
  private By autocomplete= By.xpath("//a[text()='Autocomplete']");
  private By myCountry=By.id("myCountry");
  private By submitButton=By.xpath("//input[@onclick='log()']");
  private By result=By.id("result");
  private By statusCode=By.xpath("//a[text()='Status Codes']");
  private By code200=By.xpath("//a[text()='200']");
  private By code301=By.xpath("//a[text()='301']");
  private By code404=By.xpath("//a[text()='404']");
  private By displayedMessage=By.xpath("//p");


 @Test
 public void testCase7(){
     ///Users/olivia/Library/Application Support/Firefox/Profiles/kayxegqc.default-release-2
     driver.findElement(fileUpload).click();
     SetUpTime.waitFor(2);

     String myFile="/Users/olivia/Library/Mobile Documents/com~apple~TextEdit/Documents/Assignment.rtf";
     WebElement uploadingMyFile=driver.findElement(chooseFile);
     uploadingMyFile.sendKeys(myFile);

     SetUpTime.waitFor(2);
     driver.findElement(uploadButton).click();
     SetUpTime.waitFor(3);

     String actual=driver.findElement(showFileUpload).getText().trim();
     String expected="File Uploaded!";
     Assert.assertEquals(actual,expected);

     WebElement showmyFile=driver.findElement(displayMyFile);
     Assert.assertTrue(showmyFile.isDisplayed());


 }
/**
    Test case #8
 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
 Step 2. And click on “Autocomplete”.
 Step 3. Enter “United States of America” into country input box.
 Step 4. Verify that following message is displayed:
 “You selected: United States of America”
*/
 @Test
 public void testCase8(){
     driver.findElement(autocomplete).click();
     driver.findElement(myCountry).sendKeys("United States of America");
     driver.findElement(submitButton).click();
     SetUpTime.waitFor(3);
     WebElement verifyResult=driver.findElement(result);
     Assert.assertTrue(verifyResult.isDisplayed());

 }
 /**Test case #9
  * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
  * Step 2. And click on “Status Codes”.
  * Step 3. Then click on “200”.
  * Step 4. Verify that following message is displayed:
  * “This page returned a 200 status code
  * */
  @Test
  public void testCase9(){
  driver.findElement(statusCode).click();
  driver.findElement(code200).click();
  SetUpTime.waitFor(2);

  String expectedMessage="This page returned a 200 status code";
  WebElement message=driver.findElement(displayedMessage);
  String actualMessage=message.getText();
  SetUpTime.waitFor(2);
  if(actualMessage.contains(expectedMessage)){
      System.out.println("Test9 Passed");
  }else{
      System.out.println("Test9 Failed");
  }

  }
/**Test case #10
 *  Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
 *  Step 2. And click on “Status Codes”.
 *  Step 3. Then click on “301”.
 *  Step 4. Verify that following message is displayed:
 *  “This page returned a 301 status code”
 * */
  @Test
  public void testCase10(){
      driver.findElement(statusCode).click();
      SetUpTime.waitFor(2);
      driver.findElement(code301).click();
      SetUpTime.waitFor(2);
      String expectedMessage="This page returned a 301 status code";
      WebElement message=driver.findElement(displayedMessage);
      String actualMessage=message.getText();
      SetUpTime.waitFor(2);
      if(actualMessage.equals(expectedMessage)){
          System.out.println("Test10 passed");
      }else{
          System.out.println("Test10 failed");

      }

  }
  /**Test case #11
   * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
   * Step 2. And click on “Status Codes”.
   * Step 3. Then click on “404”.
   * Step 4. Verify that following message is displayed:
   * “This page returned a 404 status code
   * */

  @Test
  public void testCase11(){
  driver.findElement(statusCode).click();
  SetUpTime.waitFor(2);
  driver.findElement(code404).click();
  SetUpTime.waitFor(2);
  String expected="This page returned a 404 status code";
  WebElement message=driver.findElement(By.xpath("//p"));
  String actual=message.getText();
  Assert.assertTrue(message.isDisplayed());

}
 /**Test case #12
  * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
  * Step 2. And click on “Status Codes”.
  * Step 3. Then click on “500”.
  * Step 4. Verify that following message is displayed:
  * “This page returned a 500 status code
 * */
  @Test
  public void testCase12(){
    //  driver.findElement()
  }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
