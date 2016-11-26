package com.practicegrid;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AutomationConstant;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yogesh on 25-11-2016.
 */
public class StepDefn {

    static WebDriver driver;

    @Before
    public void openBrowser() {
        BrowserFactory.StartBrowser(AutomationConstant.Browser_Type, AutomationConstant.Sauce_URL);
        driver = BrowserFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        BrowserFactory.closeBrowser();
    }


    @Given("^I am on login page$")
    public void i_am_on_login_page() throws Throwable {
        String text = driver.getCurrentUrl();
    //    Assert.assertTrue(text.equalsIgnoreCase("http://sbtechnos11.trial52.orangehrmlive.com/auth/login"));


    }

    @When("^I enter username as \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_enter_username_as_and_password(String username, String password) throws Throwable {

        WebElement userName = driver.findElement(By.id("txtUsername"));
      //  userName.clear();
        userName.sendKeys(username);
        WebElement passWord = driver.findElement(By.id("txtPassword"));
      //  passWord.clear();
        passWord.sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();


    }

    @Then("^I can access welcome page$")
    public void i_can_access_welcome_page() throws Throwable {

        String welcomeText = driver.findElement(By.cssSelector("#welcome")).getText();
        Assert.assertTrue(welcomeText.contains("Welcome Admin"));

    }


}
