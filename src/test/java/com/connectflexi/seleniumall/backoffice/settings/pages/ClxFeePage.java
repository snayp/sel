package com.connectflexi.seleniumall.backoffice.settings.pages;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class ClxFeePage extends AbstractUITest {

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[1]/button")
    private WebElement create_fee_button;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[2]/div[1]/input")
    private WebElement flexi_id_filter_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[2]/div[2]/tags-input/div/div/input")
    private WebElement provider_filter_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[2]/div[2]/div[1]/tags-input/div/div/input")
    private WebElement seller_filter_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[3]/table/tbody/tr/td[2]/div")
    private WebElement filter_firstresult_subseller_name;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[3]/table/tbody/tr/td[3]")
    private WebElement filter_firstresult_subseller_percentage;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[2]/div[2]/div[1]/tags-input/div/auto-complete/div/ul/li/ti-autocomplete-match/ng-include/span")
    private WebElement filter_firstresult_subseller_suggestion;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[3]/table/tbody/tr/td[5]/i")
    private WebElement edit_first_seller_button;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[3]/table/tbody/tr/td[6]/i")
    private WebElement delete_first_seller_button;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[2]/div[3]/div[2]/div/label[1]/input")
    private WebElement status_active_filter;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[2]/div[3]/div[2]/div/label[2]/input")
    private WebElement status_closed_filter;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[1]/tags-input/div/div/input")
    private WebElement create_form_provider_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[1]/tags-input/div/div/ul/li/ti-tag-item/ng-include/span")
    private WebElement create_form_provider_input_content;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[1]/button")
    private WebElement create_form_provider_browse_button;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[2]/tags-input/div/div")
    private WebElement create_form_seller_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[1]/button")
    private WebElement create_form_seller_browse_button;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[2]/input")
    private WebElement create_form_percent_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[4]/div[1]/input")
    private WebElement create_form_active_checkbox;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[4]/div[2]/input")
    private WebElement create_form_closed_checkbox;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[4]/div[1]/input")
    private WebElement create_form_according_to_time_limits_checkbox;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[1]/div[5]/div[2]/input")
    private WebElement create_form_according_to_provider_information_checkbox;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[2]/button[1]/span")
    private WebElement create_form_close_button;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[4]/div/div[2]/button[2]/span")
    private WebElement create_form_save_button;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/thead/tr/th[1]/tags-input/div/div/input")
    private WebElement provider_browse_form_category_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/thead/tr/th[2]/tags-input/div/div/input")
    private WebElement provider_browse_form_country_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/thead/tr/th[3]/tags-input/div/div/input")
    private WebElement provider_browse_form_city_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/thead/tr/th[4]/tags-input/div/div/input")
    private WebElement provider_browse_form_provider_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/div/button[1]/span")
    private WebElement provider_browse_form_close_button;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/thead/tr/th[1]/tags-input/div/div/input")
    private WebElement seller_browse_form_category_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/thead/tr/th[2]/tags-input/div/div/input")
    private WebElement seller_browse_form_country_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/thead/tr/th[3]/tags-input/div/div/input")
    private WebElement seller_browse_form_city_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/thead/tr/th[4]/tags-input/div/div/input")
    private WebElement seller_browse_form_seller_input;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/thead/tr/th[4]/tags-input/div/auto-complete/div/ul/li")
    private WebElement seller_browse_form_seller_input_suggestion;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/table/tbody/tr")
    private WebElement seller_browse_form_search_result;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/div/button[2]/span")
    private WebElement seller_browse_form_add_button;

    @FindBy(xpath = "//*[@id=\"SettingsFeeCtrl\"]/div[2]/form/div[5]/div/div/div/button[1]/span")
    private WebElement seller_browse_form_close_button;

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public ClxFeePage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.back.dev.location", "https://backoffice.dev.connectflexi.com") + "/");
    }

    public void initCreation(){
        log.info("Create CLX for");
        getUrl("/resources/admin/settingsfee/index.html");
        create_fee_button.click();
        waitElement(create_form_seller_browse_button, (long) 2);
        waitSec(1);
    }

    public void createOrEditCLXForSeller(String sellerName, String percent, boolean status, boolean cancellationFee, boolean editMode){
        create_form_seller_browse_button.click();
        waitElement(seller_browse_form_seller_input, (long) 2);
        seller_browse_form_seller_input.click();
        seller_browse_form_seller_input.sendKeys(sellerName);
        waitElement(seller_browse_form_seller_input_suggestion, (long) 2);
        seller_browse_form_seller_input_suggestion.click();
        waitSec(1);

        if (!editMode) {
            seller_browse_form_search_result.click();
        }
        waitElement(seller_browse_form_add_button, (long) 2);
        seller_browse_form_add_button.click();
        waitElement(create_form_percent_input, (long) 2);
        create_form_percent_input.click();
        create_form_percent_input.clear();
        create_form_percent_input.sendKeys(percent);
        if (status) {
            create_form_active_checkbox.click();
        } else {
            create_form_closed_checkbox.click();
        }
        if (cancellationFee) {
            create_form_according_to_time_limits_checkbox.click();
        } else {
            create_form_according_to_provider_information_checkbox.click();
        }
        create_form_save_button.click();
    }

    public void filterFindSeller(String sellerName){
        waitSec(1);
        log.info("Find sellername " + sellerName);
        seller_filter_input.clear();
        seller_filter_input.click();
        seller_filter_input.sendKeys(Keys.BACK_SPACE);
        waitSec(1);
        seller_filter_input.sendKeys(Keys.BACK_SPACE);
        waitSec(1);
        seller_filter_input.sendKeys(sellerName);
        waitElement(filter_firstresult_subseller_suggestion, (long) 2);
        filter_firstresult_subseller_suggestion.click();
    }

    public void editFirstSellerCLXinfo () {
        waitElement(edit_first_seller_button, (long) 2);
        waitSec(1);
        edit_first_seller_button.click();
    }

    public void deleteCLXforFirstSeller(){
        log.info("Deleting CLX for first Seller ");
        waitElement(delete_first_seller_button, (long) 2);
        waitSec(1);
        delete_first_seller_button.click();
    }

    public void checkCLXinfo(String sellerName, String percent){
        waitElement(create_form_provider_input_content, (long) 2);
        assertEquals(sellerName, create_form_provider_input_content.getText());
        assertEquals(percent, create_form_percent_input.getAttribute("value"));
        create_form_close_button.click();
    }

}
