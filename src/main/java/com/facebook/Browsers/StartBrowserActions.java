package com.facebook.Browsers;

import com.facebook.actions.Homepage.HomePage;
import com.facebook.actions.Logout.LogOut;
import com.facebook.actions.PostStatus.PostStatus;
import com.facebook.actions.Signup.SignUp;
import com.facebook.utils.PageHandler;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class StartBrowserActions {
    WebDriver driver;

    public WebDriver openBrowser(String browserName, String Url) {
        switch (browserName) {
            case "chrome":
                driver = new ChromeBrowser().getDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserName);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Url);
        HomePage homePage = new HomePage(driver);
        homePage.getFacebookLogoText();
        SignUp signUp = new SignUp(driver);
        signUp.enterEmailId().enterPassword().login();
        PostStatus postStatus = new PostStatus(driver);
        postStatus.dontRemeberPassword().postStatusAsHelloWorld();
        LogOut logOut = new LogOut(driver);
        logOut.logout();
        return driver;
    }
}
