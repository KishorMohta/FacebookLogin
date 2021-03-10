package com.facebook.actions.Signup;

import com.facebook.utils.Loggers;
import com.facebook.utils.PageHandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp extends PageHandler {


    @FindBy(xpath = "//div//input[@type='text']")
    private WebElement enterEmailId;

    @FindBy(xpath = "//div//input[@type='password']")
    private WebElement enterPassword;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement login;

    public SignUp(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignUp enterEmailId() {
        Loggers.info("Enter email address as ", email);
        clickAndSendKeys(enterEmailId, email);
        waitForPageToLoad();
        return new SignUp(driver);
    }

    public SignUp enterPassword() {
        clickAndSendKeys(enterPassword, alphaNumPass);
        return new SignUp(driver);
    }

    public SignUp login() {
        click(login);
        Loggers.info("Succesfully logged in");
        return new SignUp(driver);
    }
}
