package com.connectflexi.seleniumall.whitelabels.pages;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class CardPaymentMethodsPage extends AbstractUITest{

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    @FindBy(xpath = "//*[@id=\"cc\"]")
    private WebElement card_number_input;

    @FindBy(xpath = "//*[@id=\"cvv\"]")
    private WebElement cvv_number_input;

    @FindBy(xpath = "//*[@id=\"ln_submit\"]")
    private WebElement process_button;

    @FindBy(xpath = "//*[@id=\"cc_expire_year\"]")
    private WebElement ccExpireYear;

    @FindBy(xpath = "//div[contains(@class, 'Textbox-inputRow')]//input[contains(@placeholder, 'Name')]")
    //@FindBy(xpath = "//*[@id=\"223451f0-208a-11e8-88ef-477ae76e2b05\"]")
    private WebElement stripe_payment_name;

    @FindBy(xpath = "//div[contains(@class, 'Textbox-inputRow')]//input[contains(@placeholder, 'Street')]")
    private WebElement stripe_payment_street;

    @FindBy(xpath = "//div[contains(@class, 'Textbox-inputRow')]//input[contains(@placeholder, 'City')]")
    private WebElement stripe_payment_city;

    @FindBy(xpath = "//div[contains(@class, 'Textbox-inputRow')]//input[contains(@placeholder, 'Postcode')]")
    private WebElement stripe_payment_postcode;

    @FindBy(xpath = "//div[contains(@class, 'Button-content')]//span[contains(., 'Payment Info')]")
    private WebElement stripe_payment_payment_info_button;

    @FindBy(xpath = "//input[contains(@placeholder, 'Card number')]")
    private WebElement stripe_payment_cardnumber;

    @FindBy(xpath = "//input[contains(@placeholder, 'MM / YY')]")
    private WebElement stripe_payment_mm_yy;

    @FindBy(xpath = "//input[contains(@placeholder, 'CVC')]")
    private WebElement stripe_payment_cvc;

    @FindBy(xpath = "//div[contains(@class, 'Button-content')]//span[contains(., 'Pay')]")
    private WebElement stripe_payment_pay_button;


    public CardPaymentMethodsPage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.travelcard.uat.location", "https://travelcard-uat.night2stay.com/"));
    }

    public void payByCardDillFieldsAndProceed(String cardNumber, String cardCvv){
        waitSec(1);
        Set<String> listHandlesSet = webDriver.getWindowHandles();
        String [] listHandles = listHandlesSet.toArray(new String[listHandlesSet.size()]);
        webDriver.switchTo().window(listHandles[(listHandles.length - 1)]);
        //webDriver.getWindowHandle();
        //waitElement(process_button, (long) 2);
        waitSec(1);
        card_number_input.sendKeys(cardNumber);
        cvv_number_input.sendKeys(cardCvv);
        Select dropdown = new Select(ccExpireYear);
        dropdown.selectByVisibleText("2020");
        process_button.click();
        webDriver.switchTo().window(listHandles[0]);
    }

    public void payByStripeAndProceed(String name, String street, String city, String postcode, String cardNumber,
    String mmYY, String cvc){
//        Set<String> listHandlesSet = webDriver.getWindowHandles();
//        String [] listHandles = listHandlesSet.toArray(new String[listHandlesSet.size()]);
//        webDriver.switchTo().window(listHandles[(listHandles.length - 1)]);
        waitSec(2);
        //webDriver.switchTo().defaultContent();
        int size = webDriver.findElements(By.tagName("iframe")).size();
        webDriver.switchTo().frame(0); // проблема с iframe, селениум не может залезть в iframe stripe
        stripe_payment_name.click();
        stripe_payment_name.sendKeys(name);
        stripe_payment_street.sendKeys(street);
        stripe_payment_city.sendKeys(city);
        stripe_payment_postcode.sendKeys(postcode);
        stripe_payment_payment_info_button.click();
        waitElement(stripe_payment_pay_button, (long) 2);
        stripe_payment_cardnumber.sendKeys(cardNumber);
        stripe_payment_mm_yy.sendKeys(mmYY);
        stripe_payment_cvc.sendKeys(cvc);
        stripe_payment_pay_button.click();
    }

}
