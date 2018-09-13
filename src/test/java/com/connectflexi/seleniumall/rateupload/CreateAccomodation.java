package com.connectflexi.seleniumall.rateupload;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dsh on 13.12.2017.
 */
public class CreateAccomodation extends RatesBase {


    @FindBy(xpath = "//*[@id=\"left-panel\"]/nav/ul/li[1]/a")
    private WebElement menu_accomodation;

    @FindBy(xpath = "//*[@id=\"left-panel\"]/nav/ul/li[1]/ul/li[1]")
    private WebElement menu_add_accomodation;

    @FindBy(xpath = "//*[@id=\"accommodation-contract--\"]/div/div/div/div[1]/div[1]/div[1]/search-component/div/div/div/input")
    private WebElement country;

    @FindBy(xpath = "//*[@id=\"accommodation-contract--\"]/div/div/div/div[1]/div[1]/div[1]/search-component/div/div/div/div/div/div[1]")
    private WebElement suggest_country;

    @FindBy(xpath = "//*[@id=\"accommodation-contract--\"]/div/div/div/div[1]/div[1]/div[2]/search-component/div/div/div/input")
    private WebElement region;

    @FindBy(xpath = "//*[@id=\"accommodation-contract--\"]/div/div/div/div[1]/div[1]/div[2]/search-component/div/div/div/div/div/div[1]")
    private WebElement suggest_region;

    @FindBy(xpath = "//*[@id=\"accommodation-contract--\"]/div/div/div/div[1]/div[1]/div[3]/search-component/div/div/div/input")
    private WebElement accomodation;

    @FindBy(xpath = "//*[@id=\"accommodation-contract--\"]/div/div/div/div[1]/div[1]/div[3]/search-component/div/div/div/div/div/div[1]")
    private WebElement suggest_accomodation;

    @FindBy(xpath = "//*[@id=\"accommodation-contract--\"]/div/div/div/div[1]/div[1]/div[4]/search-component/div/div/div/input")
    private WebElement provider;

    @FindBy(xpath = "//*[@id=\"accommodation-contract--\"]/div/div/div/div[1]/div[1]/div[4]/search-component/div/div/div/div/div/div")
    private WebElement suggest_provider;

    @FindBy(xpath = "//*[starts-with(@id, \"select\")]")
    private WebElement room_types;

    @FindBy(xpath = "//*[@id=\"md-checkbox-2\"]/label/div")
    private WebElement all_room_types;

    @FindBy(xpath = "//*[@id=\"md-checkbox-1\"]/label/div")
    private WebElement active;

    @FindBy(xpath = "//*[@id=\"accommodation-contract--\"]/div/div/div/div[2]/div/div[2]/a[2]")
    private WebElement save_contract;

    @FindBy(id = ("md-checkbox-10"))
    private WebElement check_2_type;

    @FindBy(id =("md-checkbox-9"))
    private WebElement check_1_type;

    @FindBys({
            @FindBy(xpath = ("//*[starts-with(@id, \"accommodation-contract-\")]")),
            @FindBy(xpath = ("//div/div[1]/accordion/single-occ-setting/accordion-group/div/div[2]/div/div/div/div/div[1]/div[2]/div[4]/div/fieldset/div/div/div[1]/input"))
    })
    private WebElement ages_from;

    @FindBys({
            @FindBy(xpath = ("//*[starts-with(@id, \"accommodation-contract-\")]")),
            @FindBy(xpath = ("//div/div[1]/accordion/single-occ-setting/accordion-group/div/div[2]/div/div/div/div/div[1]/div[2]/div[4]/div/fieldset/div/div/div[2]/input"))
    })
    private WebElement ages_till;

    @FindBys({
            @FindBy(xpath = ("//*[starts-with(@id, \"accommodation-contract-\")]")),
            @FindBy(xpath = ("//div/div[1]/accordion/single-occ-setting/accordion-group/div/div[2]/div/div/div/div/div[2]/div/div[1]/a"))
    })
    private WebElement save_and_continue_occupation;

    @FindBys({
            @FindBy(xpath = ("//*[starts-with(@id, \"accommodation-contract-\")]")),
            @FindBy(xpath = ("//div/div[1]/accordion/single-periods-meal/accordion-group/div/div[2]/div/div/div/div/div[1]/div[1]/div[3]/div[1]/div/label/span"))
    })
    private WebElement check_1_type_pm;

    @FindBys({
            @FindBy(xpath = ("//*[starts-with(@id, \"accommodation-contract-\")]")),
            @FindBy(xpath = ("//div/div[1]/accordion/single-periods-meal/accordion-group/div/div[2]/div/div/div/div/div[1]/div[1]/div[3]/div[2]/div/label/span"))
    })
    private WebElement check_2_type_pm;


    @FindBys({
            @FindBy(xpath = ("//*[starts-with(@id, \"accommodation-contract-\")]")),
            @FindBy(xpath = ("//div/div[1]/accordion/single-periods-meal/accordion-group/div/div[2]/div/div/div/div/div[2]/div[1]/div[2]/label/span"))
    })
    private WebElement all_day_of_week;

    @FindBys({
            @FindBy(xpath = ("//*[starts-with(@id, \"accommodation-contract-\")]")),
            @FindBy(xpath = ("//div/div[1]/accordion/single-periods-meal/accordion-group/div/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div[3]/select"))
    })
    private WebElement currency;

    @FindBys({
            @FindBy(xpath = ("//*[starts-with(@id, \"select-\")]")),
            @FindBy(css = ("select-container"))
    })
    private WebElement seller;

    @FindBy(id = ("md-input-8"))
    private WebElement min_nights;

    @FindBy(id = ("md-input-9"))
    private WebElement max_nights;

    @FindBy(id = ("md-input-10"))
    private WebElement mark_up;

    @FindBy(id = ("md-checkbox-10"))
    private WebElement pm_active;

    @FindBy(id = ("md-input-6"))

    private WebElement rate_from;

    @FindBy(id = ("md-input-7"))
    private WebElement rate_till;
//
//    @FindBy(id = ("//*[@id=\"select-c6194070-9fd1-c2f7-0e7c-e39d704605bb\"]"))
//    private WebElement rate_till;


    WebDriverWait wait = new WebDriverWait(webDriver, 25);

    public CreateAccomodation(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void createAccomodation() {

        //выбираем пункт меню
        menu_accomodation.click();
        menu_add_accomodation.click();

        //заполняем контракт
        country.sendKeys("Italy");
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(suggest_country)
        ));
        suggest_country.click();
        region.sendKeys("Naples");
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(suggest_region)
        ));
        suggest_region.click();
        accomodation.sendKeys("Millennium Gold");
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(suggest_accomodation)
        ));
        suggest_accomodation.click();
        provider.sendKeys("Herma");
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(suggest_provider)
        ));
        suggest_provider.click();
        room_types.click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(all_room_types)
        ));
        all_room_types.click();
        active.click();
        save_contract.click();
        waitSec(2);
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,700);");

        //заполняем размещение
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(check_1_type)
        ));
        check_1_type.click();
        check_2_type.click();
        ages_from.sendKeys("18");
        ages_till.sendKeys("60");
        save_and_continue_occupation.click();
        waitSec(2);
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,900);");

        //заполняем периоды с питанием
        check_1_type_pm.click();
        check_2_type_pm.click();
        all_day_of_week.click();
        Select dropdown = new Select(currency);
        dropdown.selectByVisibleText("GBP");
        min_nights.sendKeys("2");
        mark_up.sendKeys("10");
        pm_active.click();
        rate_from.sendKeys("12/13/2017");
        rate_till.sendKeys("12/15/2017");
        seller.click();
    }
}
