package com.facebook.actions.Logout;

import com.facebook.actions.PostStatus.PostStatus;
import com.facebook.utils.Loggers;
import com.facebook.utils.PageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut extends PageHandler {

    @FindBy(xpath = "//div[@aria-label='Account']")
    private WebElement goToAccounts;

    @FindBy(xpath = "//span[text()='Log Out']")
    private WebElement logout;

    public LogOut(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LogOut logout() {
        sleep(2500L);
        click(goToAccounts);
        click(logout);
        Loggers.info("Sign out");
        return new LogOut(driver);
    }
}
