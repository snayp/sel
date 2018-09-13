package com.connectflexi.seleniumall.n2s;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by dsh on 12.12.2017.
 */
public class LoginN2S extends AbstractUITest{

    @FindBy(id = "mat-input-0")
    private WebElement sign_in_user;

    @FindBy(id = "mat-input-1")
    private WebElement sign_in_pass;

    @FindBy(className = "app-account")
    private WebElement main_element;

    @FindBy(xpath = "/html/body/app-root/app-sidenav/mat-sidenav-container/mat-sidenav[1]/app-scrollbar/div[1]/app-account/app-nav-list[2]/mat-nav-list/div/mat-list-item/div/div[2]/p")
    private WebElement sign_in_link;

    @FindBy(xpath = "//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-login/form/div/button[1]")
    private WebElement sign_in_button;

    @FindBy(xpath = "/html/body/app-root/app-sidenav/mat-sidenav-container/mat-sidenav[1]/app-scrollbar/div[1]/app-account/div[2]/div/p[2]/span")
    private WebElement user_login;

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public LoginN2S(WebDriver webDriver) throws Exception{
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.n2s.uat.location", "https://uat.night2stay.com"));
    }

    public void login(String testUser, String testPass) {
        webDriver.get(baseUrl);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(main_element)
        ));
        webDriver.manage().window().maximize();

        sign_in_link.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(sign_in_user)
        ));
        sign_in_user.sendKeys(testUser);
        waitSec(1);
        sign_in_pass.sendKeys(testPass);
        sign_in_button.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(user_login)
        ));
        assertEquals("Имя залогиненного пользователя не совпадает с введенным", user_login.getText(), testUser);
    }
}
