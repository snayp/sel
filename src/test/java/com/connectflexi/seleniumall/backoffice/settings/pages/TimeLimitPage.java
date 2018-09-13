package com.connectflexi.seleniumall.backoffice.settings.pages;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by dsh on 12.01.2018.
 */
public class TimeLimitPage extends AbstractUITest {

    @FindBy(xpath = "/html/body/div[2]/div/form[1]/div/button/i")
    private WebElement create_time_limit_button;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div/div/button")
    private WebElement browse_seller_button;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/table/thead/tr/th[4]/tags-input/div/div/input")
    private WebElement search_seller;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/table/thead/tr/th[4]/tags-input/div/auto-complete/div/ul/li/ti-autocomplete-match/ng-include")
    private WebElement search_seller_suggest;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/button[2]")
    private WebElement search_seller_button;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/table/tbody/tr")
    private WebElement seller_tr;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/button[3]")
    private WebElement add_seller_button;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div/div/table[1]/tbody/tr[2]/td[2]/input")
    private WebElement general_time_limit_input;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div/div/div[5]/button[2]")
    private WebElement save_time_limit_button;

    @FindBy(xpath = "/html/body/div[2]/div/form[1]/fieldset/div/div[1]/div/tags-input/div/div/input")
    private WebElement seller_search_input;

    @FindBy(xpath = "/html/body/div[2]/div/form[1]/fieldset/div/div[1]/div/tags-input/div/auto-complete/div/ul/li/ti-autocomplete-match/ng-include/span/em")
    private WebElement search_time_limit_input_suggest;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/table/tbody/tr/td[4]/i")
    private WebElement edit_time_limit_td;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/table/tbody/tr/td[5]/i")
    private WebElement delete_time_limit_td;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/table/tbody/tr/td[2]")
    private WebElement seller_name;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div/div/div[4]/input[2]")
    private WebElement close_time_limit;

    @FindBy(xpath = "/html/body/div[2]/div/form[1]/fieldset/div/div[2]/div/div[2]/label[2]/input")
    private WebElement close_time_limit_filter;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/table/tbody/tr/td[1]")
    private WebElement time_limit_flexiid;

    @FindBy(xpath = "/html/body/div[2]/div/form[1]/fieldset/div/div[2]/input")
    private WebElement search_time_limit_flexiid;


    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public TimeLimitPage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.back.dev.location", "https://backoffice.dev.connectflexi.com") + "/");
    }

    public void createTimeLimitForSeller(String sellerName){

        log.info("Create Time Limit for seller " + sellerName);
        waitElement(create_time_limit_button, (long) 2);
        create_time_limit_button.click();
        waitElement(browse_seller_button, (long) 2);
        browse_seller_button.click();
        waitElement(search_seller, (long) 2);
        search_seller.sendKeys(sellerName);
        waitElement(search_seller_suggest, (long) 2);
        search_seller_suggest.click();
        search_seller_button.click();
        waitElement(seller_tr, (long) 2);
        seller_tr.click();
        add_seller_button.click();
        waitElement(general_time_limit_input, (long) 2);
        general_time_limit_input.clear();
        general_time_limit_input.sendKeys("-5");
        save_time_limit_button.click();

    }

    public void findTimeLimit(String companyName) {
        seller_search_input.sendKeys(companyName);
        waitElement(search_time_limit_input_suggest, (long) 2);
        search_time_limit_input_suggest.click();
        waitSec(1);
    }

    public void editTimeLimitForSeller(String sellerName) {

        log.info("Edit Time Limit for Seller " + sellerName);
        waitElement(create_time_limit_button, (long) 2);
        checkValueForTimeLimit(sellerName, "-5");
        String newTimeLimit = "-1";
        setTimeLimit(newTimeLimit);
        save_time_limit_button.click();
        clearSellerSearchInput();
        checkValueForTimeLimit(sellerName, newTimeLimit);
        close_time_limit.click();
        save_time_limit_button.click();
        clearSellerSearchInput();
        close_time_limit_filter.click();
        checkSellerName(sellerName);
        close_time_limit_filter.click();
        String timeLimitFlexiID = time_limit_flexiid.getText();
        search_time_limit_flexiid.sendKeys(timeLimitFlexiID);
        checkSellerName(sellerName);
    }

    public void checkValueForTimeLimit(String sellerName, String value) {
        findTimeLimit(sellerName);
        edit_time_limit_td.click();
        waitElement(general_time_limit_input, (long) 2);
        assertEquals("Не совпадает значение Time Limit", general_time_limit_input.getAttribute("value"), value);
    }

    public void checkSellerName(String sellerName) {
        waitSec(1);
        log.info(seller_name.getText());
        assertEquals("Не работает фильтр Time Limit", seller_name.getText(), sellerName);
    }

    public void setTimeLimit(String value) {
        general_time_limit_input.clear();
        general_time_limit_input.sendKeys(value);
    }

    public void clearSellerSearchInput() {
        waitElement(seller_search_input, (long) 2);
        seller_search_input.sendKeys(Keys.BACK_SPACE);
        waitSec(1);
        seller_search_input.sendKeys(Keys.BACK_SPACE);
        waitSec(1);
    }

    public void deleteTimeLimitForSeller(String sellerName) {
        delete_time_limit_td.click();
    }
}
