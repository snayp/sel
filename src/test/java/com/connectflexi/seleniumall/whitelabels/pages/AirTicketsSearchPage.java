package com.connectflexi.seleniumall.whitelabels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AirTicketsSearchPage extends SearchBasePage {

    public AirTicketsSearchPage(WebDriver webDriver) throws Exception {
        super(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
    }

    public void findAirTickets(
            String fromCity, String toCity, String[] flightDate
            ) {
        waitForLoad(webDriver);
        waitElement(main_menu_air_tickets_link, (long) 2);
        main_menu_air_tickets_link.click();
        waitElement(search_button, (long) 2);
        from_city_input.click();
        from_city_input.sendKeys(fromCity);
        //waitSec(1);
        //search_city_input.sendKeys(Keys.ARROW_DOWN); /* не всегда работает корректно надо дебажить */
        waitSec(1);
        from_city_input.sendKeys(Keys.ENTER);
        to_city_input.click();
        to_city_input.sendKeys(toCity);
        waitSec(1);
        to_city_input.sendKeys(Keys.ENTER);
        date_field_input_first.click();
        calendar_date_dropdown.click();
        waitSec(1);
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + flightDate[2] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + flightDate[2] + "\"]")).click();
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + flightDate[1] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + flightDate[1] + "\"]")).click();
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + flightDate[0] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + flightDate[0] + "\"]")).click();
        waitElement(search_button, (long) 2);
        search_button.click();
        waitForLoad(webDriver);
        waitSec(1);
    }
}
