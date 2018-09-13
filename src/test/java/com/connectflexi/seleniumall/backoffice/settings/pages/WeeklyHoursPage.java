package com.connectflexi.seleniumall.backoffice.settings.pages;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;

public class WeeklyHoursPage extends AbstractUITest {

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[1]/tags-input[1]/div/div/input")
    private WebElement country_input_filter;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[1]/tags-input[1]/div/auto-complete/div/ul/li")
    private WebElement country_input_filter_suggestion;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[1]/tags-input[2]/div/div/input")
    private WebElement city_input_filter;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[1]/tags-input[2]/div/auto-complete/div/ul/li")
    private WebElement city_input_filter_suggestion;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[1]/tags-input[3]/div/div/input")
    private WebElement company_input_filter;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[1]/tags-input[3]/div/auto-complete/div/ul/li")
    private WebElement company_input_filter_suggestion;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/label/input")
    private WebElement date_from_input;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/div/div/label/input")
    private WebElement date_till_input;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[1]/button/span")
    private WebElement create_button;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[3]/button")
    private WebElement search_button;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[3]/table/tbody/tr")
    private WebElement first_found_element;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[1]/tags-input[1]/div/div/input")
    private WebElement create_form_country_input;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[1]/tags-input[1]/div/auto-complete/div/ul/li/ti-autocomplete-match/ng-include/span/em")
    private WebElement create_form_country_suggestion;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[1]/tags-input[1]/div/div/ul/li/ti-tag-item/ng-include/span")
    private WebElement create_form_country_displayed_text;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[1]/tags-input[2]/div/div/input")
    private WebElement create_form_city_input;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[1]/tags-input[2]/div/div/ul/li/ti-tag-item/ng-include/span")
    private WebElement create_form_city_displayed_text;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[1]/tags-input[2]/div/auto-complete/div/ul/li/ti-autocomplete-match/ng-include/span")
    private WebElement create_form_city_suggestion;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[1]/tags-input[3]/div/div/input")
    private WebElement create_form_company_input;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[1]/tags-input[3]/div/auto-complete/div/ul/li")
    private WebElement create_form_company_suggestion;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[1]/tags-input[3]/div/div/ul/li/ti-tag-item/ng-include/span")
    private WebElement create_form_company_displayed_text;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[1]/div[1]/div/label/input")
    private WebElement create_form_date_from_input;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[1]/div[2]/div/label/input")
    private WebElement create_form_date_till_input;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[1]/button[1]")
    private WebElement create_form_date_add_period_button;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[1]/div[1]/input")
    private WebElement create_form_contact_phone_input;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[2]/input[1]")
    private WebElement create_form_contact_status_active_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[2]/input[2]")
    private WebElement create_form_contact_status_closed_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[2]/div[1]/input")
    private WebElement create_form_skype_input;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[1]/div[2]/input")
    private WebElement create_form_contact_phone_24_input;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[2]/div[2]/input")
    private WebElement create_form_email_input;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[8]/div/input")
    private WebElement create_form_all_weekdays_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[1]/div/input")
    private WebElement create_form_monday_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[2]/div/input")
    private WebElement create_form_tuesday_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[3]/div/input")
    private WebElement create_form_wednesday_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[4]/div/input")
    private WebElement create_form_thursday_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[5]/div/input")
    private WebElement create_form_friday_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[6]/div/input")
    private WebElement create_form_saturday_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[7]/div/input")
    private WebElement create_form_sunday_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/button/span")
    private WebElement create_form_save_button;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[9]/div[3]/div/input")
    private WebElement create_form_24hours_checkbox;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[9]/div[2]/div[1]/select")
    private WebElement create_form_from_hours_dropdown_list;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[9]/div[2]/div[2]/select")
    private WebElement create_form_from_minutes_dropdown_list;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[9]/div[2]/div[3]/select")
    private WebElement create_form_till_hours_dropdown_list;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div[2]/div[3]/div[3]/div[9]/div[2]/div[4]/select")
    private WebElement create_form_till_minutes_dropdown_list;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[3]/table/tbody/tr[1]/td[9]/div/i")
    private WebElement delete_first_element_button;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[3]/table/tbody/tr/td[8]/div/i")
    private WebElement edit_first_element_button;


    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public WeeklyHoursPage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.back.dev.location", "https://backoffice.dev.connectflexi.com") + "/");
    }

    public void creationInit() {
        log.info("Create weekly opening information");
        getUrl("/resources/admin/weeklyopeninghours/index.html");
        waitSec(1);
        waitElement(create_button, (long) 2);
        create_button.click();
    }

    public void createOrEditWeeklyHoursInfo(
            String country, String city, String company, String dateFrom, String dateTill, boolean status, String contactNumber,
            String skypeName, String contact24Number, String eMail, boolean allweekdays, String day, String[] timeFrom,
            String[] timeTill) {

        waitElement(create_form_save_button, (long) 2);
        if (country != null) {
            create_form_country_input.click();
            create_form_country_input.sendKeys(Keys.BACK_SPACE);
            waitSec(1);
            create_form_country_input.sendKeys(Keys.BACK_SPACE);
            waitSec(1);
            create_form_country_input.sendKeys(country);
            waitElement(create_form_country_suggestion, (long) 2);
            create_form_country_suggestion.click();
        }
        if (city != null) {
            create_form_city_input.sendKeys(city);
            waitElement(create_form_city_suggestion, (long) 2);
            create_form_city_suggestion.click();
        }
        if (company != null) {
            create_form_company_input.sendKeys(company);
            waitElement(create_form_company_suggestion, (long) 2);
            create_form_company_suggestion.click();
        }
        create_form_date_from_input.clear();
        create_form_date_from_input.sendKeys(dateFrom);
        create_form_date_till_input.clear();
        create_form_date_till_input.sendKeys(dateTill);
        if (contactNumber != null) {
            create_form_contact_phone_input.clear();
            create_form_contact_phone_input.sendKeys(contactNumber);
        }
        if (skypeName != null) {
            create_form_skype_input.clear();
            create_form_skype_input.sendKeys(skypeName);
        }
        if (contact24Number != null) {
            create_form_contact_phone_24_input.clear();
            create_form_contact_phone_24_input.sendKeys(contact24Number);
        }
        if (eMail != null) {
            create_form_email_input.clear();
            create_form_email_input.sendKeys(eMail);
        }
        if (status) {
            create_form_contact_status_active_checkbox.click();
        } else {
            create_form_contact_status_closed_checkbox.click();
        }
        if (allweekdays) {
            create_form_all_weekdays_checkbox.click();
        }
        if (day != null) {
            if (day.equals("monday")) {
                create_form_monday_checkbox.click();
            }
            if (day.equals("tuesday")) {
                create_form_tuesday_checkbox.click();
            }
            if (day.equals("wednesday")) {
                create_form_wednesday_checkbox.click();
            }
            if (day.equals("thursday")) {
                create_form_thursday_checkbox.click();
            }
            if (day.equals("friday")) {
                create_form_friday_checkbox.click();
            }
            if (day.equals("saturday")) {
                create_form_saturday_checkbox.click();
            }
            if (day.equals("sunday")) {
                create_form_sunday_checkbox.click();
            }
        }
        Select dropdownFromHours = new Select(create_form_from_hours_dropdown_list);
        dropdownFromHours.selectByVisibleText(timeFrom[0]);
        Select dropdownFromMinutes = new Select(create_form_from_minutes_dropdown_list);
        dropdownFromMinutes.selectByVisibleText(timeFrom[1]);
        Select dropdownTillHours = new Select(create_form_till_hours_dropdown_list);
        dropdownTillHours.selectByVisibleText(timeTill[0]);
        Select dropdownTillMinutes = new Select(create_form_till_minutes_dropdown_list);
        dropdownTillMinutes.selectByVisibleText(timeTill[1]);
        create_form_save_button.click();
    }

    public void openWeeklyHoursFirstElement() {
        waitElement(edit_first_element_button, (long) 4);
        waitSec(1);
        edit_first_element_button.click();
    }

    public void checkWeeklyHoursInfo(
            String country, String city, String company, String dateFrom, String dateTill, boolean status, String contactNumber,
            String skypeName, String contact24Number, String eMail, boolean allweekdays, String day, String[] timeFrom,
            String[] timeTill) {

        waitElement(create_form_save_button, (long) 2);
        if (country != null) {
            assertEquals(create_form_country_displayed_text.getText(), country);
        }
        if (city != null) {
            assertEquals(create_form_city_displayed_text.getText(), city);
        }
        if (company != null) {
            waitElement(create_form_company_displayed_text, (long) 2);
            assertEquals(create_form_company_displayed_text.getText(), company);
        }
        assertEquals(create_form_date_from_input.getAttribute("value"), dateFrom);
        assertEquals(create_form_date_till_input.getAttribute("value"), dateTill);
        if (contactNumber != null) {
            assertEquals(contactNumber.replace("+", ""), (create_form_contact_phone_input.getAttribute("value").replace("+", "")));
        }
        if (skypeName != null) {
            assertEquals(create_form_skype_input.getAttribute("value"), skypeName);
        }
        if (contact24Number != null) {
            assertEquals(contact24Number.replace("+", ""), (create_form_contact_phone_24_input.getAttribute("value").replace("+", "")));
        }
        if (eMail != null) {
            assertEquals(create_form_email_input.getAttribute("value"), eMail);
        }
        create_form_save_button.click();
    }

    public void searchWeeklyHoursInfo(String country, String city, String company, String dateFrom, String dateTill) {
        waitElement(search_button, (long) 2);
        if (country != null) {
            country_input_filter.sendKeys(Keys.BACK_SPACE);
            waitSec(1);
            country_input_filter.sendKeys(Keys.BACK_SPACE);
            waitSec(1);
            country_input_filter.sendKeys(country);
            waitElement(country_input_filter_suggestion, (long) 2);
            country_input_filter_suggestion.click();
        }
        if (city != null) {
            city_input_filter.sendKeys(city);
            waitElement(city_input_filter_suggestion, (long) 2);
            city_input_filter_suggestion.click();
        }
        if (company != null) {
            company_input_filter.sendKeys(company);
            waitElement(company_input_filter_suggestion, (long) 2);
            company_input_filter_suggestion.click();
        }
        if (dateFrom != null) {
            date_from_input.clear();
            date_from_input.sendKeys(dateFrom);
        }
        if (dateTill != null) {
            date_till_input.clear();
            date_till_input.sendKeys(dateTill);
        }
        search_button.click();
        waitElement(first_found_element, (long) 2);
    }

    public void checkFirstFoundedHoursInfo(String country, String company, String dateFrom, String dateTill){

    }


    public void deleteFirstElementWeeklyHoursInfo() {
        waitSec(1);
        waitElement(delete_first_element_button, (long) 2);
        delete_first_element_button.click();
    }

}
