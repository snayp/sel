package com.connectflexi.seleniumall.whitelabels.pages;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class FrontPage extends AbstractUITest{

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

//    @FindBy(xpath = "/html/body/app-root/app-sidenav/mat-sidenav-container/mat-sidenav[1]/app-scrollbar/div[1]/app-account/app-nav-list[2]/mat-nav-list/div[1]/mat-list-item/div/div[2]/p")
//    private WebElement client_link;

    @FindBy(xpath = "//p[text()=\"Client\"]")
    private WebElement client_link;

    @FindBy(xpath = "//p[text()=\"Get distributed (B2B)\"]")
    private WebElement get_distributed_link;

    @FindBy(xpath = "//p[text()=\"Buy from us (B2B)\"]")
    private WebElement buy_from_us_link;

    @FindBy(xpath = "//input[contains(@placeholder, 'Login')]")
    private WebElement email_input;

//    @FindBy(xpath = "//input[@placeholder, 'Enter your e-mail']")
//    private WebElement login_form_email;

    @FindBy(xpath = "//input[contains(@placeholder, 'Password')]")
    private WebElement password_input;

    @FindBy(xpath = "//span[text()=\"Next\"]")
    private WebElement next_button;

    @FindBy(xpath = "//a[text()=\"Join us\"]")
    private WebElement join_us_link;

    @FindBy(xpath = "//a[text()=\"Start working with us\"]")
    private WebElement start_working_link;

    @FindBy(xpath = "//div[contains(@placeholder, 'Company type')]")
    private WebElement company_type_dropdown;

    @FindBy(xpath = "//input[contains(@placeholder, 'Name of company')]")
    private WebElement name_of_company_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Postal code')]")
    private WebElement postal_code_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Country')]")
    private WebElement country_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'City/Village')]")
    private WebElement city_village_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Street name')]")
    private WebElement street_name_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'House building')]")
    private WebElement house_building_number_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Business center')]")
    private WebElement business_center_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Office number')]")
    private WebElement office_number_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Floor')]")
    private WebElement floor_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Registration number')]")
    private WebElement registration_number_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Tax number')]")
    private WebElement tax_number_input;

    @FindBy(xpath = "")
    private WebElement general_contact_sex_dropdown;

    @FindBy(xpath = "")
    private WebElement contact_name_input;

    @FindBy(xpath = "")
    private WebElement general_contact_surname_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'General phone')]")
    private WebElement general_contact_phone_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'General e-mail')]")
    private WebElement general_contact_email_input;

    @FindBy(xpath = "")
    private WebElement contracting_contact_sex_dropdown;

    @FindBy(xpath = "//*[@id=\"mat-input-54\"]")
    private WebElement contracting_contact_name_input;

    @FindBy(xpath = "//*[@id=\"mat-input-55\"]")
    private WebElement contracting_contact_surname_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Contracting phone')]")
    private WebElement contracting_contact_phone_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Contracting e-mail')]")
    private WebElement contracting_contact_email_input;

    @FindBy(xpath = "")
    private WebElement accounting_contact_sex;

    @FindBy(xpath = "")
    private WebElement accounting_contact_name_input;

    @FindBy(xpath = "")
    private WebElement accounting_contact_surname_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Accounting phone')]")
    private WebElement accounting_contact_phone_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Accounting e-mail')]")
    private WebElement accounting_contact_email_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Website B2B')]")
    private WebElement website_b2b_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Website B2C')]")
    private WebElement website_b2c_input;

    @FindBy(xpath = "//span[text()=\"Cancel\"]")
    private WebElement cancel_button;

    public FrontPage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.louverturetravels.uat.location", "https://louverturetravels-uat.night2stay.com/"));
    }

    public void openMainPage(){
        log.info("Open main page");
        getUrl("");
        waitSec(1);
    }

    public void createB2C (String email, String password){
        openMainPage();
        waitSec(1);
        waitElement(client_link, (long) 2);
        client_link.click();
        waitElement(next_button, (long) 2);
        waitElement(join_us_link, (long) 2);
        join_us_link.click();
        waitElement(email_input, (long) 3);
        email_input.sendKeys(email);
        waitElement(password_input, (long) 2);
        password_input.sendKeys(password);
        next_button.click();
        waitSec(1);
        waitElement(next_button, (long) 2);
        next_button.click();
    }

//    public void createB2BDistributedOnlyRequired(String email, String password){
//        openMainPage();
//        waitSec(1);
//        waitElement(get_distributed_link, (long) 2);
//        get_distributed_link.click();
//    }

    public void login (String email, String password){
        openMainPage();
        waitElement(client_link, (long) 2);
        client_link.click();
        waitElement(next_button, (long) 2);
        waitSec(1);
        email_input.sendKeys(email);
        waitSec(1);
        password_input.click();
        password_input.sendKeys(password);
        next_button.click();
        waitSec(1);
    }
}
