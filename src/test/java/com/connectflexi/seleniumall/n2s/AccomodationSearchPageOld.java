package com.connectflexi.seleniumall.n2s;

import com.connectflexi.seleniumall.AbstractUITest;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dsh on 12.12.2017.
 */
public class AccomodationSearchPageOld extends AbstractUITest {

    @FindBy(id = "mat-input-6")
    private WebElement search_city_input;

    @FindBy(id = "cdk-overlay-1")
    private WebElement suggest_search_city_input;

    @FindBy(id = "mat-input-2")
    private WebElement checkin_input;

    @FindBy(id = "mat-input-3")
    private WebElement checkout_input;

    @FindBy(xpath = "//*[contains(text(),'Accommodation')]")
    private WebElement accomodation_search_menu;

    @FindBy(xpath = "/html/body/app-root/app-sidenav/mat-sidenav-container/mat-sidenav-content/app-content/app-commodity/app-scrollbar/div[1]/mat-card[1]/mat-list/form/mat-list-item[2]/div/button")
    private WebElement search_button;

    @FindBy(xpath = "" +
            "")
    private WebElement add_to_order;

//    @FindBys({
//            @FindBy(css = ("ng-star-inserted")),
//            @FindBy(xpath = ("/html/body/app-root/app-sidenav/mat-sidenav-container/mat-sidenav-content/app-content/app-commodity/app-scrollbar/div[1]/div[1]/app-commodity-card[1]/mat-card/mat-list/mat-list-item[3]/div/div[3]/button"))
//    })
//    private WebElement add_to_order_b;


    WebDriverWait wait = new WebDriverWait(webDriver, 25);

    public AccomodationSearchPageOld(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void accomodationSearchByCity(String city) {
        Date dt = new Date();
        DateTime now = new DateTime(dt);
        DateTime nowPlus35 = now.plusDays(35);
        DateTime nowPlus37 = now.plusDays(37);
        String checkIn = new SimpleDateFormat("ddMMyyyy").format(nowPlus35.toDate());
        String checkOut = new SimpleDateFormat("ddMMyyyy").format(nowPlus37.toDate());

        accomodation_search_menu.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(search_city_input)
        ));
        search_city_input.sendKeys(city);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(suggest_search_city_input)
        ));
        suggest_search_city_input.click();
        log.info(checkIn);
        checkin_input.click();
        checkin_input.sendKeys(checkIn);
        log.info(checkOut);
        checkout_input.click();
        checkout_input.sendKeys(checkOut);
        search_button.click();
        waitSec(5);

        Dimension window_size = webDriver.manage().window().getSize();
        int height = window_size.getHeight();
        int width = window_size.getWidth();

        Point search_location = search_button.getLocation();
        int sheight = search_location.getX();
        int swidth = search_location.getY();


        System.out.println(height + ", " + width);
        System.out.println(sheight + ", " + swidth);

        Actions actions = new Actions(webDriver);
        actions.moveToElement(search_button).moveByOffset((width/2)-2, 0).click().build().perform();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(add_to_order)
        ));
        add_to_order.click();
    }
}
