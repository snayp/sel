package com.connectflexi.seleniumall.authority;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dsh on 27.11.2017.
 */
public class LoginAuth extends AbstractUITest {

    @FindBy(xpath = "/html/body/div[2]/div/header/div[4]")
    private WebElement authorityLogo;

    @FindBy(name = "username")
    private WebElement user_name_textbox;

    @FindBy(name = "password")
    private WebElement password_textbox;

    @FindBy(tagName = "button")
    private WebElement login_btn;

    public LoginAuth(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.auth.dev.location", "https://authority.dev.connectflexi.com") + "/");
    }

    public void login(String user, String pass) throws Exception {

        getUrl("resources/public/login.html");

        String username = user;
        String password = pass;

        user_name_textbox.sendKeys(username);
        password_textbox.sendKeys(password);
        log.info("Authenticating with username=" + username + " and password=" + password);
        login_btn.click();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(authorityLogo)
        ));

        log.info("Authentication successful.");
    }

}
