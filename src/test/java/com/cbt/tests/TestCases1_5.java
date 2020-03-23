package com.cbt.tests;

import com.cbt.utilities.SetUpTime;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestCases1_5 {


 private WebDriver driver;
 private String URL = "https://practice-cybertekschool.herokuapp.com";
 private By registrationFormButton=By.xpath("//a[text()='Registration Form']");
 private By birthdayButton=By.xpath("//input[@name='birthday']");
 private By warningBirthdayMessage=By.xpath("//small[text()='The date of birth is not valid']");
 private By programmingLanguages=By.xpath("//label[text()='Select programming languages']");
 private By programmingLanguageVisible=By.xpath("//label[text()='Select programming languages']/following-sibling::div");
 private By firstNameBox=By.xpath("//input[@name='firstname']");
 private By warningNameElement=By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']");
 private By lastNameBox=By.name("lastname");
 private By warningLastNameMEssage=By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']");
 private By userNameBox=By.name("username");
 private By passwordBox=By.name("password");
 private By phoneNumberBox=By.name("phone");
 private By genderBox=By.xpath("//input[@value='female']");
 private By dateOfBirthBox=By.name("birthday");
 private By departmentBox=By.name("department");
 private By jobTitleBox=By.name("job_title");
 private By javaScriptBox=By.xpath("//input[@id='inlineCheckbox3'] ");
 private By signUpBox=By.id("wooden_spoon");
 private By emailBox=By.name("email");
 private By successMessage=By.xpath("//h4[text()='Well done!']/following-sibling::p");
 /***
  *Test case #1 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
  * Step 2. Click on “Registration Form”
  * Step 3. Enter “wrong_dob” into date of birth input box.
  * Step 4. Verify that warning message is displayed: “The date of birth is not valid”
  */

 @Test(description = "Verify that warning message is displayed")
 public void testCase1(){

  driver.findElement(registrationFormButton).click();
  SetUpTime.waitFor(2);
  driver.findElement(birthdayButton).sendKeys("wrong_dob");
  SetUpTime.waitFor(2);

  WebElement warningBirthdayElement=driver.findElement(warningBirthdayMessage);
  assertTrue(warningBirthdayElement.isDisplayed());
  SetUpTime.waitFor(2);

  String expected= "The date of birth is not valid";
  String actual= warningBirthdayElement.getText();
  assertEquals(actual,expected);

 }

 /**TestCase #2:
  * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
  * Step 2. Click on “Registration Form”
  * Step 3. Verify that following options
  * for programming languages are displayed: c++, java, JavaScript
  * */


 @Test(description="Verify following options for programming languages are displayed")
 public void testCase2(){

  driver.findElement(registrationFormButton).click();
  WebElement displayOfProgrammingLanguages = driver.findElement(programmingLanguages);
  assertTrue(displayOfProgrammingLanguages.isDisplayed());
  SetUpTime.waitFor(2);
 //Verify that following options for programming languages are displayed: c++, java, JavaScript with for loop:
 // List<WebElement> programmingLanguageList=driver.findElements(By.xpath("//input[@class='form-check-input']"));
 // for(WebElement each: programmingLanguageList){
   //Assert.assertTrue(each.isDisplayed());
  //SetUpTime.waitFor(2);
  //}

  //2.way:
  WebElement programmingLanguagesDisplayed=driver.findElement(programmingLanguageVisible);
  assertTrue(programmingLanguagesDisplayed.isDisplayed());
  SetUpTime.waitFor(2);


 }
 /**TestCase #3:
  *Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
  * Step 2. Click on “Registration Form”
  * Step 3. Enter only one alphabetic character into first name input box.
  * Step 4. Verify that warning message is displayed:
  * “first name must be more than 2 and less than 64 characters long”
  * */

 @Test(description = "Verify that warning message is displayed")
 public void testCase3(){

  driver.findElement(registrationFormButton).click();
  driver.findElement(firstNameBox).sendKeys("a");
  SetUpTime.waitFor(2);
  WebElement warningNameMessageDisplay= driver.findElement(warningNameElement);
  assertTrue(warningNameMessageDisplay.isDisplayed());

  String expected= "first name must be more than 2 and less than 64 characters long";
  String actual=warningNameMessageDisplay.getText();
  assertEquals(actual,expected);

 }

 /**TestCase #4:
  * Step 1. Go to https://practice-cybertekschool.herokuapp.com
  * Step 2. Click on “Registration Form”
  * Step 3. Enter only one alphabetic character into last name input box.
  * Step 4. Verify that warning message is displayed:
  * “The last name must be more than 2 and less than 64 characters long”
  * */
 @Test
 public void testCase4(){

  driver.findElement(registrationFormButton).click();
  driver.findElement(lastNameBox).sendKeys("g");
  WebElement warningLastNameElement=driver.findElement(warningLastNameMEssage);

  String expected="The last name must be more than 2 and less than 64 characters long";
  String actual=warningLastNameElement.getText();
  SetUpTime.waitFor(2);
  Assert.assertEquals(actual,expected);

 }

 /**TestCase #5:
  *Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
  * Step 2. Click on “Registration Form”
  * Step 3. Enter any valid first name.
  * Step 4. Enter any valid last name.
  * Step 5. Enter any valid user name.
  * Step 6. Enter any valid password.
  * Step 7. Enter any valid phone number.
  * Step 8. Select gender.
  * Step 9. Enter any valid date of birth.
  * Step 10. Select any department.
  * Step 11. Enter any job title.
  * Step 12. Select java as a programming language.
  * Step 13. Click Sign up.
  * Step 14. Verify that following success message is displayed:
  * “You've successfully completed registration!”
  * */
 @Test
 public void testCase5(){

  driver.findElement(registrationFormButton).click();
  driver.findElement(firstNameBox).sendKeys("Olivia");
  driver.findElement(lastNameBox).sendKeys("Glens");
  driver.findElement(userNameBox).sendKeys("yellow");
  //found a bug and fixed it!
  driver.findElement(emailBox).sendKeys("fatma@gmail.com");
  SetUpTime.waitFor(2);
  driver.findElement(passwordBox).sendKeys("hopetolife");
  driver.findElement(phoneNumberBox).sendKeys("571-345-2345");
  driver.findElement(genderBox).click();
  SetUpTime.waitFor(2);
  driver.findElement(dateOfBirthBox).sendKeys("12/12/2012");

  Select selectionDepartment=new Select(driver.findElement(departmentBox));
  selectionDepartment.selectByVisibleText("Department of Engineering");
  SetUpTime.waitFor(2);

  Select selectionJobTitle=new Select(driver.findElement(jobTitleBox));
  selectionJobTitle.selectByVisibleText("SDET");
  SetUpTime.waitFor(2);
  driver.findElement(javaScriptBox).click();
  SetUpTime.waitFor(2);
  driver.findElement(signUpBox).click();

  String expected="You've successfully completed registration!";
  String actual=driver.findElement(successMessage).getText().trim();
  SetUpTime.waitFor(2);
  Assert.assertEquals(actual,expected);




 }

 @BeforeMethod
 public void setup() {
  WebDriverManager.chromedriver().version("79").setup();
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get(URL);
  SetUpTime.waitFor(2);

 }

 @AfterMethod
 public void teardown() {
  if (driver != null) {
   driver.quit();
   driver=null;
  }
 }
}