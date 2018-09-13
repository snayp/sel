package com.connectflexi.seleniumall.authority;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dsh on 07.12.2017.
 */
public class LicensePage extends AbstractUITest {
    @FindBy(xpath = "/html/body/div[3]/div/form/div/div[1]/button")
    private WebElement create_license;

    @FindBy(xpath = "/html/body/div[4]/div/form/div[2]/div[1]/tags-input/div/div/input")
    private WebElement company_name;

    @FindBy(xpath = "/html/body/div[3]/div/form/div/div[2]/div[1]/tags-input/div/div/input")
    private WebElement company_name_search;

    @FindBy(xpath = "/html/body/div[4]/div/form/div[2]/div[1]/tags-input/div/auto-complete/div/ul/li")
    private WebElement suggest_company;

    @FindBy(xpath = "/html/body/div[3]/div/form/div/div[2]/div[1]/tags-input/div/auto-complete/div/ul/li[1]/ti-autocomplete-match/ng-include/span")
    private WebElement suggest_company_search;

    @FindBy(xpath = "/html/body/div[3]/div/form/div/div[2]/div[3]/button")
    private WebElement company_search_button;

    @FindBy(xpath = "/html/body/div[4]/div/form/div[2]/div[2]/label/input")
    private WebElement general_licence_from;

    @FindBy(xpath = "/html/body/div[4]/div/form/div[2]/div[3]/label/input")
    private WebElement general_licence_till;

    @FindBy(xpath = "/html/body/div[4]/div/form/button[1]")
    private WebElement add_licence;

    @FindBy(xpath = "/html/body/div[4]/div/form/div[3]/div/div[1]/select")
    private WebElement select_licence;

    @FindBy(xpath = "/html/body/div[4]/div/form/button[3]")
    private WebElement save_licence;

    @FindBy(xpath = "/html/body/div[3]/div/form/div/div[4]/table/tbody/tr/td[8]/div/i")
    private WebElement edit_company_button;

    @FindBy(xpath = "/html/body/div[4]/div/form/button[2]")
    private WebElement add_category_button;

    @FindBy(xpath = "/html/body/div[4]/div/form/div[4]/div/div[1]/select")
    private WebElement select_category;

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public LicensePage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.auth.dev.location", "https://authority.dev.connectflexi.com") + "/");
    }

    public void createLicenseN2S(String companyName) throws Exception {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(create_license)
        ));
        create_license.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(company_name)
        ));
        company_name.sendKeys(companyName);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(suggest_company)
        ));
        suggest_company.click();
        general_licence_from.sendKeys("2017-11-01");
        general_licence_till.sendKeys("2027-11-01");
        add_licence.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(select_licence)
        ));
        Select dropdown = new Select(select_licence);
        dropdown.selectByVisibleText("Night2Stay");
        save_licence.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(company_name_search)
        ));
    }
    
    public void addCategory(String companyName, String category) throws Exception {

        company_name_search.sendKeys(companyName);
        waitElement(suggest_company_search, (long) 2);
        suggest_company_search.click();
        company_search_button.click();
        waitSec(1);
        edit_company_button.click();
        waitElement(add_category_button, (long) 2);
        add_category_button.click();
        waitElement(select_category, (long) 2);
        Select dropdown = new Select(select_category);
        dropdown.selectByVisibleText(category);
        save_licence.click();
        waitElement(company_name, (long) 2);
    }
}
