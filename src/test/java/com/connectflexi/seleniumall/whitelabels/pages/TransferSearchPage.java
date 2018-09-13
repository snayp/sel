package com.connectflexi.seleniumall.whitelabels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TransferSearchPage extends SearchBasePage{

    public TransferSearchPage(WebDriver webDriver) throws Exception {
        super(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
    }

    public void findTransfer(String fromCity, String fromAccomodation, String toCity, String toAccomodation,
                             String[] dateField, String adults, String time_hours, String time_minutes)
    {
        waitElement(main_menu_transfer_link, (long) 2);
        main_menu_transfer_link.click();
        waitElement(search_button, (long) 2);
        from_city_input.click();
        from_city_input.sendKeys(fromCity);
        waitSec(1);
        from_city_input.sendKeys(Keys.ARROW_DOWN);
        from_city_input.sendKeys(Keys.ENTER);
        from_accomodation_input.click();
        from_accomodation_input.sendKeys(fromAccomodation);
        waitSec(1);
        waitElement(autocomplete_accomodation, (long) 5);
        from_accomodation_input.sendKeys(Keys.ARROW_DOWN);
        from_accomodation_input.sendKeys(Keys.ENTER);
        to_city_input.click();
        to_city_input.sendKeys(toCity);
        waitSec(1);
        to_city_input.sendKeys(Keys.ARROW_DOWN);
        to_city_input.sendKeys(Keys.ENTER);
        to_accomodation_input.click();
        to_accomodation_input.sendKeys(toAccomodation);
        waitSec(1);
        waitElement(autocomplete_accomodation, (long) 5);
        to_accomodation_input.sendKeys(Keys.ARROW_DOWN);
        to_accomodation_input.sendKeys(Keys.ENTER);
        date_field_input_first.click();
        calendar_date_dropdown.click();
        waitSec(1);
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + dateField[2] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + dateField[2] + "\"]")).click();
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + dateField[1] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + dateField[1] + "\"]")).click();
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + dateField[0] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + dateField[0] + "\"]")).click();
        time_input_hours_field.sendKeys(time_hours);
        time_input_minutes_field.sendKeys(time_minutes);

        waitElement(search_button, (long) 2);
        search_button.click();
        waitForLoad(webDriver);
        waitSec(1);
    }
}
