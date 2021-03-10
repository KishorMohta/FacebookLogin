package com.facebook.actions.PostStatus;

import com.facebook.utils.Constant;
import com.facebook.utils.Loggers;
import com.facebook.utils.PageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostStatus extends PageHandler {
    @FindBy(xpath = "//div[@class='m9osqain a5q79mjw jm1wdb64 k4urcfbm']//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7']")
    private WebElement goForStatusUpdate;

    @FindBy(xpath = "//div[@class='notranslate _5rpu']")
    private WebElement publishStatus;

    @FindBy(css = "div.bv25afu3")
    private WebElement pd;

    @FindBy(xpath = "//div[@aria-label='Post']")
    private WebElement post;

    @FindBy(xpath = "//div[@aria-label='Not Now' and @tabindex = '0']")
    private WebElement dontRememberPassword;

    public PostStatus(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PostStatus dontRemeberPassword() {
        try {
            click(dontRememberPassword);
        } catch (Exception e) {
            Loggers.info("  pop-up to remember password didnt occured");
        }
        return new PostStatus(driver);
    }

    public void postStatusAsHelloWorld() {
        sleep(2000L);
        click(goForStatusUpdate);
        click(pd);
        Loggers.info("Post an status as ", Constant.POSTSTATUS);
        try {
            clickAndSendKeys(publishStatus, Constant.POSTSTATUS);
        }
        catch (Exception e){
            mouseOver(publishStatus);
        }
        click(post);
    }
}
