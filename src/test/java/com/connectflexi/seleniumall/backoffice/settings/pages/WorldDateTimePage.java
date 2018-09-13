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

public class WorldDateTimePage extends AbstractUITest{

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[1]/div[1]/button/span")
    private WebElement create_button;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[1]/div[2]/div[1]/tags-input/div/div/input")
    private WebElement country_input;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[1]/div[2]/div[3]/input")
    private WebElement flexi_connect_input;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[1]/div[2]/div[2]/tags-input/div/div/input")
    private WebElement city_input;

    @FindBy(xpath = "div.pure-u-2-3.filters > div:nth-child(4) > div:nth-child(2) > input")
    private WebElement status_active;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[1]/div[2]/div[4]/div[2]/input")
    private WebElement status_closed;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[2]/div/div/div[2]/div[1]/div[1]/tags-input/div/div")
    private WebElement create_form_provider_input;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[2]/div/div/div[2]/div[1]/div[1]/button")
    private WebElement create_form_provider_browse_button;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[3]/div/div/table/thead/tr/th[1]/tags-input/div/div/input")
    private WebElement create_form_browse_category_input;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[3]/div/div/table/thead/tr/th[2]/tags-input/div/div")
    private WebElement create_form_browse_country_input;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[3]/div/div/table/thead/tr/th[3]/tags-input/div/div/input")
    private WebElement create_form_browse_city_input;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[3]/div/div/table/thead/tr/th[4]/tags-input/div/div/input")
    private WebElement create_form_browse_provider_input;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[3]/div/div/div[2]/button[1]")
    private WebElement create_form_browse_close_button;

    @FindBy(xpath = "//*[@id=\"clientOverviewCtrl\"]/div[2]/div/main/form[3]/div/div/div[2]/button[2]")
    private WebElement create_form_browse_search_button;




    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public WorldDateTimePage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.back.dev.location", "https://backoffice.dev.connectflexi.com") + "/");
    }


}
