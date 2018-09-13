package com.connectflexi.seleniumall.whitelabels.pages;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends AbstractUITest{


    @FindBy(xpath = "//input[contains(@placeholder, 'Choose payer')]")
    private WebElement choose_payer_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Choose tourist')]")
    private WebElement choose_tourist_input;

    @FindBy(xpath = "//mat-radio-group")
    private WebElement choose_tourist_document_first_element;

    @FindBy(xpath = "//textarea[contains(@placeholder, 'Comment')]")
    private WebElement comment_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Flight')]")
    private WebElement flight_number_input;

    @FindBy(xpath = "//div/app-order-menu")
    private WebElement pay_button_wrapper;

    @FindBy(xpath = "//span[text()=\"Pay\"]")
    private WebElement pay_menu_button;

    @FindBy(xpath = "//span[text()=\"Deposit\"]")
    private WebElement deposit_button;

    @FindBy(xpath = "//span[text()=\"Card\"]")
    private WebElement card_button;

    @FindBy(xpath = "//span[contains(., 'paid')]")
    private WebElement service_paid_notification_text;

    @FindBy(xpath = "//span[contains(., 'I have read')]")
    private WebElement terms_and_conditions_text;

    @FindBy(xpath = "//span[contains(., 'Continue')]")
    private WebElement continue_button;

    @FindBy(xpath = "(//h4)[1]")
    private WebElement service_name_in_order_first_element;

    @FindBy(xpath = "(//mat-icon[contains(@class, 'mat-icon ng-star-inserted')]/following-sibling::span)[1]")
    private WebElement payer_name_in_order;

    @FindBy(xpath = "//mat-list/mat-list-item[5]/div/div[2]/app-autochips/mat-chip-list/div/app-chip/mat-chip/span")
    private WebElement tourist_name_in_order;

    @FindBy(xpath = "//div[contains(@class, 'login-name')]/p[1]")
    private WebElement account_name_upper_menu;

    @FindBy(xpath = "(//h4)[1]")
    private WebElement first_element_service_name_in_order;

    @FindBy(xpath = "(//h4)[3]")
    private WebElement hotel_room_type_in_order;

    @FindBy(xpath = "(//h4)[2]")
    private WebElement transfer_destinations_in_order;

    @FindBy(xpath = "//app-commodity-airticket//div[contains(@class, 'mat-list-text')]")
    private WebElement flight_destinations_in_order;

    @FindBy(xpath = "(//h4)[1]/following-sibling::p")
    private WebElement transfer_type_in_order;

    @FindBy(xpath = "(//h4)[3]/span")
    private WebElement hotel_room_type_additional_info_in_order;

    @FindBy(xpath = "(//span[contains(., 'Total')])[1]")
    private WebElement total_tourist_order_price_value;

    //@FindBy(xpath = "(//div/mat-icon[contains(@svgicon, 'app_commission')])[1]/ancestor::mat-list/mat-list-item[7]//h1")
    @FindBy(xpath = "(//div/mat-icon[contains(@svgicon, 'app_commission')])[1]/ancestor::mat-list//h1[contains(., 'Total')]")
    private WebElement total_agent_order_price_value;

    @FindBy(xpath = "//mat-list/app-total-payments/app-total-markups/mat-list-item[1]/div/div[2]/div/span")
    private WebElement commission_value;

    @FindBy(xpath = "//span[contains(., 'refun')][1]")
    private WebElement order_refund_accomodation_type;

    @FindBy(xpath = " (//app-toolbar//span[contains(@class, 'title')]/span)[1]")
    private WebElement order_id;

    @FindBy(xpath = "//span[text()=\"Tourist mode\"]")
    private WebElement tourist_mode_text;

    @FindBy(xpath = "//span[text()=\"Agent mode\"]")
    private WebElement agent_mode_text;

    @FindBy(xpath = "//app-eye")
    private WebElement agent_eye_button;

    @FindBy(xpath = "//div[contains(@data-funding-source, 'paypal')]")
    private WebElement pay_by_paypal_button;

    @FindBy(xpath = "//span[text()=\"Pay by stripe\"]")
    private WebElement pay_by_stripe_button;

    @FindBy(xpath = "//span[text()=\"Pay by card\"]")
    private WebElement pay_by_card_button;

    @FindBy(css = ("mat-body-1 app-secondary-text app-p-l-4"))
    private WebElement order_commission;

    public OrderPage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.travelcard.uat.location", "https://travelcard-uat.night2stay.com/"));
    }

    public String getTouristNameFromOrder() {
        String touristNameInOrder = tourist_name_in_order.getText();
        return touristNameInOrder;
    }

    public String getPayerNameFromOrder() {
        String payerNameInOrder = payer_name_in_order.getText();
        return payerNameInOrder;
    }

    public void payOrderByDeposit() {
        openPayWrapper();
        openPayMenu();
        try {
            deposit_button.click();
        } catch (WebDriverException e) {
            waitSec(2);
            try {
                deposit_button.click();
            } catch (WebDriverException e2) {
                openPayMenu();
                waitSec(1);
                deposit_button.click();
            }
        }
    }

    public void payOrderByCard() {
        openPayWrapper();
        openPayMenu();
        waitSec(2);
        card_button.click();
        waitElement(terms_and_conditions_text, (long) 2);
        terms_and_conditions_text.click();
        waitElement(pay_by_card_button, (long) 2);
        pay_by_card_button.click();
    }

    public void payOrderByStrype(){
        openPayWrapper();
        openPayMenu();
        waitSec(2);
        card_button.click();
        waitElement(terms_and_conditions_text, (long) 2);
        terms_and_conditions_text.click();
        waitElement(pay_by_stripe_button, (long) 2);
        pay_by_stripe_button.click();
    }

    public void payOrderByPayPal(){
        openPayWrapper();
        openPayMenu();
        waitSec(2);
        card_button.click();
        waitElement(terms_and_conditions_text, (long) 2);
        terms_and_conditions_text.click();
        waitElement(pay_by_paypal_button, (long) 2);
        pay_by_paypal_button.click();
    }

    public void openPayWrapper() {
        try {
            pay_button_wrapper.click();
        } catch (WebDriverException e) {
            waitSec(2);
            pay_button_wrapper.click();
            waitSec(1);
        }
    }

    public void openPayMenu() {
        try {
            pay_menu_button.click();
        } catch (WebDriverException e) {
            waitSec(2);
            pay_menu_button.click();
        }
    }

    public void checkCardPaymentResult() {
        waitSec(1);
        waitElement(service_paid_notification_text, (long) 2);
    }

    public String getAccountName() {
        String accountName = account_name_upper_menu.getText();
        return accountName;
    }

    public void choosePayerAndTouristByIndexes(int payerIndex, int touristIndex, String comment) {
        choose_payer_input.click();
        if (payerIndex == 1){
            choose_payer_input.sendKeys(Keys.ENTER);
        }
        else {
            for (int i = 1; i < payerIndex; i++)
                choose_payer_input.sendKeys(Keys.ARROW_DOWN);
            choose_payer_input.sendKeys(Keys.ENTER);
        }

        choose_tourist_input.click();
        if (touristIndex == 1){
            choose_tourist_input.sendKeys(Keys.ENTER);
        }
        else {
            for (int i = 1; i < touristIndex; i++)
                choose_tourist_input.sendKeys(Keys.ARROW_DOWN);
            choose_tourist_input.sendKeys(Keys.ENTER);
        }
//        try {
//            waitElement(choose_tourist_document_first_element, (long) 1);
//            choose_tourist_document_first_element.click();
//        }
//        catch (WebDriverException e){
//        }
        if (comment != null) {
            comment_input.click();
            comment_input.sendKeys(comment);
        }
    }

    public void choosePayerAndTouristByIndexes(int payerIndex, int touristIndex, String comment, String flightNumber) {
        waitSec(1);
        choose_payer_input.click();
        if (payerIndex == 1){
            choose_payer_input.sendKeys(Keys.ENTER);
        }
        else {
            for (int i = 1; i < payerIndex; i++)
                choose_payer_input.sendKeys(Keys.ARROW_DOWN);
            choose_payer_input.sendKeys(Keys.ENTER);
        }
        waitSec(1);
        choose_tourist_input.click();
        if (touristIndex == 1){
            choose_tourist_input.sendKeys(Keys.ENTER);
        }
        else {
            for (int i = 1; i < touristIndex; i++)
                choose_tourist_input.sendKeys(Keys.ARROW_DOWN);
            choose_tourist_input.sendKeys(Keys.ENTER);
        }

        if (comment != null) {
            comment_input.sendKeys(comment);
        }
        if (flightNumber != null) {
            flight_number_input.sendKeys(flightNumber);
        }
    }

    public String getOrderRefundType() {
        String accomodationType = order_refund_accomodation_type.getText();
        return accomodationType;
    }

    public String getOrderComment() {
        String orderComment = comment_input.getAttribute("value");
        return orderComment;
    }

    public String getTransferFlightData() {
        String flightData = flight_number_input.getAttribute("value");
        return flightData;
    }

    public String getOrderFirstElementServiceName() {
        String serviceName = null;
        try {
            serviceName =
                    webDriver.findElement(By.xpath
                            ("(//app-commodity-airticket//div[contains(@class, 'mat-list-text')])[1]"))
                            .getAttribute("innerText");
        } // обработка проверки авиабилетов. В поиске авиа другая верстка
        catch (WebDriverException e) {
            serviceName = first_element_service_name_in_order.getText();
        }
        return serviceName;
    }

    public String getOrderHotelRoomType() {
        String hotelRoomType = hotel_room_type_in_order.getText();
        try {
            String hotelRoomAdditionalInfo = hotel_room_type_additional_info_in_order.getText();
            hotelRoomType = hotelRoomType.replace(hotelRoomAdditionalInfo, "");
            hotelRoomType = hotelRoomType + " " + hotelRoomAdditionalInfo;
            return hotelRoomType;
        } catch (WebDriverException e) {
            return hotelRoomType;
        }
    }

    public String getOrderTransferType() {
        waitElement(transfer_type_in_order, (long) 2);
        String transferTypeInOrder = transfer_type_in_order.getText();
        return transferTypeInOrder;
    }

    public String getOrderTransferDestinations() {
        waitElement(transfer_destinations_in_order, (long) 2);
        String transferDestinationsInOrder =
                (transfer_destinations_in_order.getAttribute("textContent")).replaceAll("\\s\\(.*\\)", "");
        // приходит к нам направление с кодом в скобках. Мы удаляем этот код с конца строки.
        return transferDestinationsInOrder;
    }

    public String getOrderId() {
        String orderId = String.valueOf(order_id.getText());
        return orderId;
    }

    public float getOrderTouristTotalCostValue() {
        waitElement(total_tourist_order_price_value, (long) 2);
        String totalSecondOrderValueString = total_tourist_order_price_value.getText();
        float totalSecondOrderValueFloat = parseStringDataToFloat(totalSecondOrderValueString);
        return totalSecondOrderValueFloat;
    }

    public float getOrderAgentTotalCostValue() {
        switchToAgentMode();
        String totalSecondOrderValueString = total_agent_order_price_value.getText();
        float totalSecondOrderValueFloat = parseStringDataToFloat(totalSecondOrderValueString);
        return totalSecondOrderValueFloat;
    }

    public float getOrderAgentComissionValue() {
        switchToAgentMode();
        waitElement(commission_value, (long) 2);
        String comissionStringValue = commission_value.getText();
        float comissionValueFloat = parseStringDataToFloat(comissionStringValue);
        return comissionValueFloat;
    }

    public float parseStringDataToFloat(String incPriceString) {
        String[] PriceStringParts = incPriceString.split(" ");
        String returnStringValue = PriceStringParts[(PriceStringParts.length - 1)];
        float returnFloatValue = Float.valueOf(returnStringValue);
        return returnFloatValue;
    }

    public void switchToAgentMode() {
        try {
            agent_mode_text.isDisplayed();
        } catch (WebDriverException e) {
            waitElement(tourist_mode_text, (long) 2);
            tourist_mode_text.click();
        }
    }

    public void switchToTouristMode() {
        try {
            tourist_mode_text.isDisplayed();
        } catch (WebDriverException e) {
            waitElement(tourist_mode_text, (long) 2);
            tourist_mode_text.click();
        }
    }

}
