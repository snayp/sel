package com.connectflexi.seleniumall.backoffice;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by dsh on 07.12.2017.
 */
public class CompanyPage extends AbstractUITest {

    @FindBy(name = "general")
    public static WebElement general;

    @FindBy(id = "name")
    private WebElement company_name;

    @FindBy(id = "addressStreet")
    private WebElement address_street;

    @FindBy(id = "addressNumber")
    private WebElement address_number;

    @FindBy(id = "taxNumber")
    private WebElement tax_number;

    @FindBy(id = "registrationNumber")
    private WebElement registration_number;

    @FindBy(xpath = "//*[@id=\"contentScroll\"]/form/fieldset/div/div[1]/div[11]/tags-input/div/div/input")
    private WebElement company_city;

    @FindBy(xpath = "//span[text()='Create Seller']")
    private WebElement create_seller;

    @FindBy(xpath = "//*[@id=\"contentScroll\"]/form/fieldset/div/div[1]/div[11]/tags-input/div/auto-complete/div/ul/li")
    private WebElement suggest_city;

    @FindBy(xpath = "//*[@id=\"contentScroll\"]/form/fieldset/div/div[8]/tags-input/div/div/input")
    private WebElement currency;

    @FindBy(xpath = "//*[@id=\"contentScroll\"]/form/fieldset/div/div[8]/tags-input/div/auto-complete/div/ul/li")
    private WebElement suggest_currency;

    @FindBy(xpath = "//*[@id=\"contentScroll\"]/form/fieldset/div/div[3]/div[2]/input")
    private WebElement open_and_active;

    @FindBy(xpath = "//*[@id=\"contentScroll\"]/form/fieldset/div/div[6]/label/span[2]/input")
    private WebElement all_countries;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement save_company;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[2]/div/form/button[1]")
    private WebElement save_and_continue2;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[8]/div/button")
    private WebElement save_and_continue3;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[2]/div/div[3]/button[3]/span")
    private WebElement edit_company;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[11]/form/div[1]/div[1]/button/span")
    private WebElement add_user;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[11]/form/div[2]/div/div[1]/div[1]/input")
    private WebElement user_login;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[11]/form/div[2]/div/div[1]/div[2]/input")
    private WebElement user_password;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[11]/form/div[2]/div/div[1]/div[3]/input")
    private WebElement user_name;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[11]/form/div[1]/table/tbody/tr/td[2]/div")
    private WebElement user_login_td;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[11]/form/div[2]/div/div[2]/button/span")
    private WebElement user_save;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div/form/button[2]")
    private WebElement edit_group_list;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div/form/div[1]/button")
    private WebElement create_group_name;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div/form/button[1]")
    private WebElement save_and_continue_group_name;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div/form/div[2]/div[1]/div/strong")
    private WebElement group_name;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[4]/div/div[4]/div[5]/div[1]/strong")
    private WebElement group_name_2;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[4]/div/div[4]/div[1]/tags-input/div/auto-complete/div/ul/li")
    private WebElement group_name_suggest;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[4]/div/div[4]/div[3]/div[1]/strong")
    private WebElement group_id;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div[2]/table/tbody/tr/td[2]/div/div")
    private WebElement company_id;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[4]/div/div[3]/div[2]/button[2]/span")
    private WebElement save_and_exit;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[4]/div/div[3]/div[2]/button[1]/span")
    private WebElement save_group;

    @FindBy(id = "companyTypeId")
    private WebElement company_type_id;

    @FindBy(xpath = "/html/body/div[2]/div/main/ul/li[4]")
    private WebElement marketing_rules_list;

    @FindBy(xpath = "/html/body/div[2]/div/main/ul/li[5]")
    private WebElement marketing_rules;

    @FindBy(xpath = "/html/body/div[2]/div/main/ul/li[2]")
    private WebElement users_tab;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[4]/div/div[4]/div[1]/tags-input/div/div/input")
    private WebElement marketing_rules_input;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[3]/div/form/div[4]/div[1]/input")
    private WebElement group_name_input;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[4]/div/div[4]/div[2]/tags-input/div/div/input")
    private WebElement company_name_input;


    @FindBy(xpath = "/html/body/div[2]/div/main/div[4]/div/div[4]/div[2]/tags-input/div/auto-complete/div/ul/li/ti-autocomplete-match/ng-include/span/em")
    private WebElement company_name_suggest;

    @FindAll({
        @FindBy(xpath = "//input[@ng-model='marketingRule.name']")
    })
    private List<WebElement> group_name_inputs_all;


    @FindAll({
        @FindBy(xpath = "//input[@ng-model='category.checked']")
    })
    private List<WebElement> settings_all;

    @FindBy(xpath = "/html/body/div[2]/div/main/div[8]/div/div[1]/button")
    private WebElement settings_back_button;


    @FindBy(xpath = "/html/body/div[2]/div/main/div[8]/div/div[5]/button")
    private WebElement settings_save_button;

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public CompanyPage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
//        setBaseUrl(settings.getProperty("selenium.back.dev.location", "https://backoffice.dev.connectflexi.com") + "/");
    }

    public void createSeller(String companyName) {

        getUrl("/resources/admin/company/index.html");

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(create_seller)
        ));
        create_seller.click();
        ArrayList<String> tabs1 = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs1.get(1));
        log.info("Create Seller with name = " + companyName);
        Select dropdown = new Select(company_type_id);
        dropdown.selectByVisibleText("Agency");
        company_name.sendKeys(companyName);
        address_street.sendKeys("Veselaya");
        address_number.sendKeys("465");
        tax_number.sendKeys("4287872");
        registration_number.sendKeys("0967282");
        company_city.sendKeys("Moscow");

        wait.until(ExpectedConditions.or(
           ExpectedConditions.visibilityOf(suggest_city)
        ));
        suggest_city.click();
        currency.sendKeys("EUR");

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(suggest_currency)
        ));
        suggest_currency.click();
        open_and_active.click();
        all_countries.click();
        save_company.click();
    }

    public void waitGeneral(){
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.name("general"))
        ));
    }

    public void checkCompany(String companyName) {
        assertEquals("Не совпадает имя компании", company_name.getAttribute("value"), companyName);
        assertEquals("Не совпадает улица в адресе", address_street.getAttribute("value"), "Veselaya");
        assertEquals("Не совпадает номер дома в адресе", address_number.getAttribute("value"), "465");
        assertEquals("Не совпадает tax номер", tax_number.getAttribute("value"), "4287872");
        assertEquals("Не совпадает registration номер", registration_number.getAttribute("value"), "0967282");
    }

    public void createAgent(String testUser, String testPass){
        edit_company.click();
        goToUsers();
        add_user.click();
        log.info("Test Agent = " + testUser);
        user_login.sendKeys(testUser);
        log.info("Test Password = " + testPass);
        user_password.sendKeys(testPass);
        user_name.sendKeys("testagent");
        findElementByXpath("/html/body/div[2]/div/main/div[11]/form/div[2]/div/div[1]/div[4]/div/div[1]/label/span").click();
        Select dropdown = new Select(findElementByXpath("/html/body/div[2]/div/main/div[11]/form/div[2]/div/div[1]/div[5]/select"));
        dropdown.selectByVisibleText("Night2stay B2C");
        user_save.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + testUser + "')]"))
        ));
    }

    public void createGroup(String groupName){
        edit_group_list.click();
        create_group_name.click();
        waitSec(1);
        log.info(String.valueOf(group_name_inputs_all.size()));
        for (int i = 0; i < group_name_inputs_all.size(); i++) {
            WebElement e = group_name_inputs_all.get(i);
            if (e.isEnabled()){
                e.sendKeys(groupName);
            }
        }
        save_and_continue_group_name.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(group_name)
        ));
//        WebElement groupName = findElementByXpath()
    }

    public String getCompanyIDByName(String companyName){
        getUrl("resources/admin/company/index.html");
        waitGeneral();
        general.sendKeys(companyName);
        waitSec(1);
        String companyID = company_id.getText();
        log.info("companyID = " + companyID);
        return companyID;
    }

    public void getCompany(String companyName){
        getUrl("/resources/admin/company/index.html");
        waitGeneral();
        general.sendKeys(companyName);
        waitSec(1);
        company_id.click();
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(tabs.size()-1));
//        waitSec(1);
    }

    public void drugCompanyToGroup(String companyID, String groupName){
        WebElement draggable = findElementById("company_" + companyID);
        WebElement target_group = findElementById(findTargetGroupId(groupName));
        new Actions(webDriver).dragAndDrop(draggable, target_group).perform();
        save_group.click();
        waitSec(1);
    }

    public String findTargetGroupId(String groupName){
        String target_group_id = "marketingRule_" + findGroupId(groupName);
        return target_group_id;
    }

    public String findGroupId(String groupName){
        String groupID = findElementByXpath("//div/div[contains(text(), '" + groupName + "')]/strong").getText();
        return groupID;
    }

    public void createMarkupSheet(){

    }

    public void goToMarketingRulesList(){
        marketing_rules_list.click();
    }
    public void goToMarketingRules(){
        marketing_rules.click();
    }
    public void goToUsers(){
        users_tab.click();
    }
    public void filterMarketingRules(String groupName){
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(marketing_rules_input)
        ));
        marketing_rules_input.sendKeys(groupName);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(group_name_suggest)
        ));
        group_name_suggest.click();
    }

    public void openServicesForGroup(String groupName){
        WebElement button_settings = findElementByXpath("//*[@id='" + findTargetGroupId(groupName) + "']/following-sibling::div/button/span");
        button_settings.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(settings_back_button)
        ));
        for (int i = 0; i < settings_all.size(); i++) {
            WebElement e = settings_all.get(i);
            e.click();
        }
        settings_save_button.click();
        waitForLoad(webDriver);
    }
}
