package com.facebook.actions.Homepage;

import com.facebook.Assertion.HomePageAssertions;
import com.facebook.utils.Loggers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.facebook.utils.PageHandler;

import java.util.logging.Logger;

public class HomePage extends PageHandler {

    String expectedQuote;

    @FindBy(xpath = "//div//h2[@class='_8eso']")
    private WebElement facebookLogo;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage getFacebookLogoText() {
        expectedQuote = facebookLogo.getText();
        Loggers.info("Facebook quote == ", expectedQuote);
        HomePageAssertions.quoteAssertions(expectedQuote);
        return new HomePage(driver);
    }
}
