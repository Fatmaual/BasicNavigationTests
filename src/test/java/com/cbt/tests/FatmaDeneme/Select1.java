package com.cbt.tests.FatmaDeneme;
import com.cbt.utilities.SetUpTime;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Select1 {
    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private By registrationFormButton=By.xpath("//a[text()='Registration Form']");
    private By birthdayButton=By.xpath("//input[@name='birthday']");
    private By warningBirthdayMessage=By.xpath("//small[text()='The date of birth is not valid']");
    private By programmingLanguages=By.xpath("//label[text()='Select programming languages']");
    private By firstNameBox=By.xpath("//input[@name='firstname']");
    private By warningNameElement=By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']");
    private By lastNameBox=By.name("lastname");
    private By warningLastNameMEssage=By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']");
    private By userNameBox=By.name("username");
    private By passwordBox=By.name("password");
    private By phoneNumberBox=By.name("phone");
    private By genderBox=By.xpath("//input[@value='female']");
    private By departmentBox=By.name("department");
   private By selectProgrammingVisible=By.xpath("//label[text()='Select programming languages']/following-sibling::div");
    private By jobTitleBox=By.name("job_title");
    private By jobSelection=By.xpath("//option[text()='SDET']");
    private By javaScriptBox=By.xpath("//input[@id='inlineCheckbox3'] ");
    private By signUpBox=By.id("//input[@id='inlineCheckbox3'] ");
    private By emailBox=By.name("email");


    @Test
    public void testCase5(){

        driver.findElement(registrationFormButton).click();
        driver.findElement(firstNameBox).sendKeys("Olivia",Keys.ENTER);
        driver.findElement(lastNameBox).sendKeys("Glens",Keys.ENTER);
        driver.findElement(userNameBox).sendKeys("yellow");
        driver.findElement(passwordBox).sendKeys("hopetolife");
        driver.findElement(phoneNumberBox).sendKeys("571-345-2345");
        WebElement gosterim=driver.findElement(selectProgrammingVisible);
         Assert.assertTrue(gosterim.isDisplayed());
         SetUpTime.waitFor(2);



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