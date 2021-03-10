package com.facebook.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeBrowser implements BrowserDriver {

    @Override
    public WebDriver getDriver() {
        setPathForDriver();
        return new ChromeDriver(chromeOptions());
    }

    private ChromeOptions chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);
        return chromeOptions;
    }

    @Override
    public void setPathForDriver() {
        WebDriverManager.chromedriver().setup();
    }
}
