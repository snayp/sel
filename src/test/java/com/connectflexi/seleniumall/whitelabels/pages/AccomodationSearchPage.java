package com.connectflexi.seleniumall.whitelabels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccomodationSearchPage extends SearchBasePage {

    public AccomodationSearchPage(WebDriver webDriver) throws Exception {
        super(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
    }


    public void findAccomodation(
            String country, String island, String city, String hotelName, String[] checkIn, String[] checkOut,
            String rooms, String adults, String children, boolean showPictures) {

        waitForLoad(webDriver);
        waitElement(main_menu_accomodation_link, (long) 2);
        main_menu_accomodation_link.click();
        waitElement(search_button, (long) 2);

        if (country != null) {
            search_country_input.sendKeys(country);
            waitElement(search_country_input_suggest, (long) 1);
            search_country_input_suggest.click();
        }
        if (island != null) {
            search_island_input.sendKeys(island);
        }
        search_city_input.sendKeys(city);
        waitElement(search_city_input_suggest, (long) 1);
        search_city_input_suggest.click();

        if (hotelName != null) {
            search_accomodation_input.sendKeys(hotelName);
        }
        checkin_field.click();
        waitElement(calendar_date_dropdown, (long) 2);
        calendar_date_dropdown.click();
        webDriver.findElement(By.xpath("//div[text()=\"" + checkIn[2] + "\"]")).click();
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + checkIn[1] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + checkIn[1] + "\"]")).click();
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + checkIn[0] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + checkIn[0] + "\"]")).click();
        checkout_field.click();
        waitElement(calendar_date_dropdown, (long) 2);
        calendar_date_dropdown.click();
        webDriver.findElement(By.xpath("//div[text()=\"" + checkOut[2] + "\"]")).click();
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + checkOut[1] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + checkOut[1] + "\"]")).click();
        waitElement(webDriver.findElement(By.xpath("//div[text()=\"" + checkOut[0] + "\"]")), (long) 2);
        webDriver.findElement(By.xpath("//div[text()=\"" + checkOut[0] + "\"]")).click();

        if (adults != null) {
            adults_button.click();
            WebElement adults_button_suggest = adults_button_suggest(String.valueOf(adults));
            waitElement(adults_button_suggest, (long) 2);
            adults_button_suggest.click();
        }
        waitElement(search_button, (long) 2);
        search_button.click();
        waitForLoad(webDriver);
        waitSec(1);
    }
}
