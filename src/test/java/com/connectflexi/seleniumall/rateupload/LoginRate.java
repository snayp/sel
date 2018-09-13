package com.connectflexi.seleniumall.rateupload;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dsh on 12.12.2017.
 */
public class LoginRate extends AbstractUITest {


    @FindBy(id = "username")
    private WebElement user_name;

    @FindBy(id = "password")
    private WebElement user_password;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/footer/button")
    private WebElement sign_in;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/sa-login-info/div/a/span")
    private WebElement user_login_name;

    public LoginRate(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.rate.dev.location", "https://ratesupload.dev.connectflexi.com") + "/");
    }

    public void login(String user, String pass) {

        getUrl("/auth/login");
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(sign_in)
        ));

        webDriver.manage().window().maximize();

        String username = user;
        String password = pass;

        log.info("Authenticating with username=" + username + " and password=" + password);
        user_name.sendKeys(username);
        user_password.sendKeys(password);
        sign_in.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(user_login_name)
        ));
        log.info("Authentication successful.");
    }
}
