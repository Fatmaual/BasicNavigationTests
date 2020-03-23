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

public class TestCase6 {
    /**
     * Test case #6
     * Step 1. Go to "https://www.tempmailaddress.com/"
     * Step 2. Copy and save email as a string.
     * Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
     * Step 4. And click on “Sign Up For Mailing List".
     * Step 5. Enter any valid name.
     * Step 6. Enter email from the Step 2.
     * Step 7. Click Sign Up
     * Step 8. Verify that following message is displayed:
     * “Thank you for signing up. Click the button below to return to the home page.”
     * Step 9. Navigate back to the “https://www.tempmailaddress.com/”
     * Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
     * Step 11. Click on that email to open it.
     * Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
     * Step 13. Verify that subject is:
     * “Thanks for subscribing to practice.cybertekschool.com!”
     */
    private WebDriver driver;
    //private By email=By.xpath("/span[text()='williamson.robby@aallaa.org']");
    private By email = By.id("email");
    private By signUpEmalList = By.xpath("//a[text()='Sign Up For Mailing List']");
    private By fullName = By.name("full_name");
    private By secondEmail = By.name("email");
    private By signUp = By.name("wooden_spoon");
    private By verifyMessage = By.name("signup_message");
    private By emailDoNot = By.xpath("//td[text()='do-not-reply@practice.cybertekschool.com']");
    private By doNotReply = By.xpath("//span[@ id='odesilatel']");
    private By subscribingMessage = By.xpath("//span[text()='Thanks for subscribing to practice.cybertekschool.com!']");

    @Test
    public void testCase6() {
        String emailstr = driver.findElement(email).getText();
        System.out.println("The email is: " + emailstr);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(signUpEmalList).click();
        SetUpTime.waitFor(2);
        driver.findElement(fullName).sendKeys("Olivia");
        driver.findElement(secondEmail).sendKeys(emailstr);
        SetUpTime.waitFor(2);
        driver.findElement(signUp).click();

        SetUpTime.waitFor(2);
        WebElement displayMessage = driver.findElement(verifyMessage);
        Assert.assertTrue(displayMessage.isDisplayed());
        SetUpTime.waitFor(2);
        driver.navigate().to("https://www.tempmailaddress.com");
        SetUpTime.waitFor(3);
        WebElement verifyingEmail = driver.findElement(emailDoNot);
        String expected="do-not-reply@practice.cybertekschool.com";
        String actual=verifyingEmail.getText().trim();
        Assert.assertEquals(actual,expected);
        driver.findElement(emailDoNot).click();
        SetUpTime.waitFor(2);
        WebElement verifyingDoNotMessage = driver.findElement(doNotReply);
        String actual2=verifyingDoNotMessage.getText().trim();
        Assert.assertEquals(actual2,expected);
        WebElement verifySubscribing = driver.findElement(subscribingMessage);
        String expected2="Thanks for subscribing to practice.cybertekschool.com!";
        String actual3=verifySubscribing.getText().trim();
        Assert.assertEquals(actual3,expected2);
        SetUpTime.waitFor(2);

    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
