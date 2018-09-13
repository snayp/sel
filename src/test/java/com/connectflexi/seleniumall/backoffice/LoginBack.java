package com.connectflexi.seleniumall.backoffice;

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
public class LoginBack extends AbstractUITest {

    @FindBy(xpath = "//span[text()='Create Sub Seller']")
    private WebElement createSubseller;


    @FindBy(xpath = "/html/body/main/h1")
    private WebElement reservations;

    @FindBy(name = "username")
    private WebElement user_name_textbox;

    @FindBy(name = "password")
    private WebElement password_textbox;

    @FindBy(tagName = "button")
    private WebElement login_btn;

    public LoginBack(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.back.uat.location", "https://backoffice.uat.connectflexi.com") + "/");
    }

    public void login(String username, String password) {

        getUrl("resources/public/login.html");

        user_name_textbox.sendKeys(username);
        password_textbox.sendKeys(password);
        log.info("Authenticating with username=" + username + " and password=" + password);
        login_btn.click();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(reservations)
        ));

        log.info("Authentication successful.");
    }

}
