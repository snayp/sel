package com.connectflexi.seleniumall.backoffice;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dsh on 12.12.2017.
 */
public class AllReservation extends AbstractUITest {

    @FindBy(xpath = "/html/body/main/section[1]/div/div[1]/div[1]/input")
    private WebElement order_id;

    @FindBy(xpath = "/html/body/main/section[1]/div/div[1]/div[2]/input")
    private WebElement service_id;

    @FindBy(xpath = "/html/body/main/section[1]/div/div[1]/div[3]/input")
    private WebElement reservation_code;

    @FindBy(xpath = "/html/body/main/section[1]/div/div[1]/div[4]/input")
    private WebElement user_name;

    @FindBy(xpath = "/html/body/main/section[1]/button[1]")
    private WebElement search_reservation;

    @FindBy(xpath = "/html/body/main/section[3]/section/ul/li/div[1]/div[1]/h2")
    private WebElement order_id_reservation;


    public AllReservation(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.back.dev.location", "https://backoffice.dev.connectflexi.com") + "/");
    }

    public void checkOrder(String orderID) throws Exception {

        getUrl("/resources/admin/reservation/index.html");

    }

}
