package com.connectflexi.seleniumall.whitelabels.pages;

import com.connectflexi.seleniumall.AbstractUITest;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertEquals;

public class SearchBasePage extends AbstractUITest {

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public SearchBasePage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.travelcard.uat.location", "https://travelcard-uat.night2stay.com/"));
    }

    @FindBy(xpath = "//div[contains(@class, 'login-name')]/p[1]")
    protected WebElement account_name_upper_menu;

    @FindBy(xpath = "//p[text()=\"Accommodation\"]")
    protected WebElement main_menu_accomodation_link;

    @FindBy(xpath = "//p[text()=\"Air Tickets\"]")
    protected WebElement main_menu_air_tickets_link;

    @FindBy(xpath = "//input[contains(@placeholder, 'Search country')]")
    protected WebElement search_country_input;

    @FindBy(xpath = "//*[contains(@id, 'mat-option-')]/span")
    protected WebElement search_country_input_suggest;

    @FindBy(xpath = "//input[contains(@placeholder, 'Search island')]")
    protected WebElement search_island_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Search city')]")
    protected WebElement search_city_input;

    @FindBy(xpath = "//*[contains(@id, 'mat-option-')]/span")
    protected WebElement search_city_input_suggest;

    @FindBy(xpath = "//input[contains(@placeholder, 'Search accomodation')]")
    protected WebElement search_accomodation_input;

    @FindBy(xpath = "(//input[contains(@placeholder, 'MM/DD/YY')])[1]")
    protected WebElement checkin_field;

    @FindBy(xpath = "(//input[contains(@placeholder, 'MM/DD/YY')])[2]")
    protected WebElement checkout_field;

    @FindBy(xpath = "/html/body/app-root/app-sidenav/mat-sidenav-container/mat-sidenav-content/app-content/app-commodity/app-scrollbar/div[1]/mat-card[1]/mat-list/form/mat-list-item[1]/div/button")
    protected WebElement rooms_button;

    @FindBy(xpath = "/html/body/app-root/app-sidenav/mat-sidenav-container/mat-sidenav-content/app-content/app-commodity/app-scrollbar/div[1]/mat-card[1]/mat-list/form/app-persons-camp/mat-list-item/div/button[1]")
    protected WebElement adults_button;

    protected WebElement adults_button_suggest(String adults) {
        String adults_button_suggest = "//*[@id=\"cdk-overlay-6\"]/div/div[1]/button[adults]";
        return webDriver.findElement(By.xpath(adults_button_suggest.replace("adults", adults)));
    }

    @FindBy(xpath = "/html/body/app-root/app-sidenav/mat-sidenav-container/mat-sidenav-content/app-content/app-commodity/app-scrollbar/div[1]/mat-card[1]/mat-list/form/app-persons-camp/mat-list-item/div/button[2]")
    protected WebElement childrens_button;

    @FindBy(xpath = "//span[text()=\"Show only with pictures\"]")
    protected WebElement show_only_with_pictures_button;

    @FindBy(xpath = "//span[text()=\"Search\"]")
    protected WebElement search_button;

    @FindBy(xpath = " (//app-toolbar//span[contains(@class, 'title')]/span)[1]")
    protected WebElement order_id;

    @FindBy(xpath = "//span[text()=\"Add to order\"]")
    protected WebElement add_to_order_button;

    @FindBy(xpath = "//button[contains(@aria-label, 'Choose month and year')]")
    protected WebElement calendar_date_dropdown;

    @FindBy(xpath = "//input[contains(@placeholder, 'Choose payer')]")
    protected WebElement choose_payer_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'Choose tourist')]")
    protected WebElement choose_tourist_input;

    @FindBy(xpath = "//textarea[contains(@placeholder, 'Comment')]")
    protected WebElement comment_input;

    @FindBy(xpath = "//mat-list/mat-list-item[2]/div/app-order-menu")
    protected WebElement pay_button_wrapper;

    @FindBy(xpath = "//span[text()=\"Pay\"]")
    protected WebElement pay_menu_button;

    @FindBy(xpath = "//span[text()=\"Deposit\"]")
    protected WebElement deposit_button;

    @FindBy(xpath = "//span[text()=\"Card\"]")
    protected WebElement card_button;

    @FindBy(xpath = "//span[contains(., 'paid')]")
    protected WebElement service_paid_notification_text;

    @FindBy(xpath = "//span[contains(., 'I have read')]")
    protected WebElement terms_and_conditions_text;

    @FindBy(xpath = "//span[contains(., 'Continue')]")
    protected WebElement continue_button;

    @FindBy(xpath = "(//h4)[1]")
    protected WebElement hotel_name_in_order;

    @FindBy(xpath = "(//h4)[3]")
    protected WebElement hotel_room_type_in_order;

    @FindBy(xpath = "(//h4)[3]/span")
    protected WebElement hotel_room_type_additional_info_in_order;

    @FindBy(xpath = "(//span[contains(., 'Total')])[1]")
    protected WebElement total_first_order_price;

    @FindBy(xpath = "(//div/mat-icon[contains(@svgicon, 'app_commission')])[1]/ancestor::mat-list/mat-list-item[7]//h1")
    protected WebElement total_second_order_price;

    @FindBy(xpath = "(//div/mat-icon[contains(@svgicon, 'app_commission')])[1]/following-sibling::div[1]/p[1]")
    protected WebElement comission_value;

    @FindBy(xpath = "//span[contains(., 'refun')][1]")
    protected WebElement order_refund_accomodation_type;

    @FindBy(xpath = "//span[text()=\"Tourist mode\"]")
    protected WebElement tourist_mode_text;

    @FindBy(xpath = "//span[text()=\"Agent mode\"]")
    protected WebElement agent_mode_text;

    @FindBy(xpath = "//app-eye")
    protected WebElement agent_eye_button;

    @FindBy(xpath = "//p[text()=\"Transfer\"]")
    protected WebElement main_menu_transfer_link;

    @FindBy(xpath = "//input[contains(@placeholder, 'From city')]")
    protected WebElement from_city_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'From airport')]")
    protected WebElement from_airport_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'From accommodation/airport/location')]")
    protected WebElement from_accomodation_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'To city')]")
    protected WebElement to_city_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'To accommodation/airport/location')]")
    protected WebElement to_accomodation_input;

    @FindBy(xpath = "//input[contains(@placeholder, 'To airport')]")
    protected WebElement to_airport_input;

    @FindBy(xpath = "(//input[contains(@placeholder, 'MM/DD/YY')])[1]")
    protected WebElement date_field_input_first;

    @FindBy(xpath = "(//input[contains(@placeholder, 'MM/DD/YY')])[2]")
    protected WebElement date_field_input_second;

    @FindBy(xpath = "//input[contains(@class, 'hours ng-untouched ng-pristine ng-valid')]")
    protected WebElement time_input_hours_field;

    @FindBy(xpath = "//input[contains(@class, 'minutes ng-untouched ng-pristine ng-valid')]")
    protected WebElement time_input_minutes_field;

    @FindBy(xpath = "//div[contains(@class, 'mat-autocomplete-visible')]")
    protected WebElement autocomplete_accomodation;

    @FindBy(xpath = "//input[contains(@placeholder, 'Flight')]")
    protected WebElement flight_number_input;

    @FindBy(xpath = "(//h4)[1]")
    protected WebElement transfer_name_in_order;

//    @FindBy(xpath = "")
//    private WebElement test;

    public void addAndScrollFoundSearchResultByIndex(String index) {
        String xpathMoveToLocatorString = "(//span[text()=\"Add to order\"])" + "[" +
                String.valueOf(Integer.valueOf(index) + 1)
                + "]";
        String xpathClickLocatorString = "(//span[text()=\"Add to order\"])" + "[" + index + "]";
        WebElement elementToClick, elementToMove;
        try {
            elementToClick = webDriver.findElement(By.xpath(xpathClickLocatorString));
            elementToMove = webDriver.findElement(By.xpath(xpathMoveToLocatorString));
        } catch (WebDriverException e) {
            waitSec(5);
            try {
                waitElement(webDriver.findElement(By.xpath(xpathClickLocatorString)), (long) 500); // этот случай нужен для долгих авиабилетов
            }
            catch (WebDriverException exception){ // этот случай ну если совсем все плохо со скоростью загрузки билетов
                waitSec(10);
                waitElement(webDriver.findElement(By.xpath(xpathClickLocatorString)), (long) 500);
                elementToClick = webDriver.findElement(By.xpath(xpathClickLocatorString));
                elementToMove = webDriver.findElement(By.xpath(xpathMoveToLocatorString));
            }
            elementToClick = webDriver.findElement(By.xpath(xpathClickLocatorString));
            elementToMove = webDriver.findElement(By.xpath(xpathMoveToLocatorString));
        }
        Actions actions = new Actions(webDriver);
        actions.moveToElement(elementToClick);
        actions.perform();
        try {
            elementToClick.click();
        } catch (Exception e) {
            waitSec(1);
            actions.perform();
        }
        actions.moveToElement(elementToMove);
        actions.perform();
        waitSec(1);
        // из-за того, что часто возникает исключение, драйвер не может найти элементы в поиске, так как при add order
        // результаты поиска сужаются. Поэтому мы ищем по индексу, но мотаем страницу вниз на индекс+1, чтобы
        // гарантированно позже не получать ошибок отсутствия элементов из search панели
    }

    public Float getTotalTouristPriceValueInSearch(String serviceName){
        waitSec(1);
        waitForLoad(webDriver);
        String xpathWay = "//p[text()=\"" + serviceName + "\"]/ancestor::mat-list/mat-list-item[3]//span[contains(., 'otal')]";
        WebElement element = webDriver.findElement(By.xpath(xpathWay));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element);
        actions.perform();
        String hotelTotalPriceInSearchString = element.getText();
        if (StringUtils.isEmpty(hotelTotalPriceInSearchString)) {
            waitSec(1);
            hotelTotalPriceInSearchString = element.getText();
        } else if (StringUtils.isBlank(hotelTotalPriceInSearchString)) {
            waitSec(1);
            hotelTotalPriceInSearchString = element.getText();
        }
        try {
            float hotelTotalPriceInSearchFloat = parseStringDataToFloat(hotelTotalPriceInSearchString);
        }
        catch (Exception e1){
            waitSec(3);
        }
        float hotelTotalPriceInSearchFloat = parseStringDataToFloat(hotelTotalPriceInSearchString);
        return hotelTotalPriceInSearchFloat;
    }

    public String getServiceRefundTypeInSearch(String hotelName){
        String hotelServiceTypeInSearch =
                webDriver.findElement(By.xpath("//p[text()=\"" + hotelName + "\"]/ancestor::mat-list//span[contains(., 'refund')]")).getText();
        return hotelServiceTypeInSearch;
    }

    public String getAccountName() {
        String accountName = account_name_upper_menu.getText();
        return accountName;
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

    public float getAgentComissionInSearch() {
        switchToAgentMode();
        String comissionValueInOrderString = comission_value.getText();
        float comissionValueInOrderFloat = parseStringDataToFloat(comissionValueInOrderString);
        return comissionValueInOrderFloat;
    }

    public String getServiceNameInSearch(String serviceName){
        waitSec(1);
        Actions actions = new Actions(webDriver);
        WebElement element = webDriver.findElement(By.xpath("//p[text()=\"" + serviceName + "\"]"));
        actions.moveToElement(element);
        actions.perform();
        String serviceNameInSearch = element.getText();
        if (StringUtils.isEmpty(serviceNameInSearch)) {
            waitSec(1);
            serviceNameInSearch =
                    webDriver.findElement(By.xpath("//p[text()=\"" + serviceName + "\"]")).getText();
        } else if (StringUtils.isBlank(serviceNameInSearch)) {
            waitSec(1);
            serviceNameInSearch =
                    webDriver.findElement(By.xpath("//p[text()=\"" + serviceName + "\"]")).getText();
        }
        return serviceNameInSearch;
    }

    public float getAgentTotalValueInSearch(String serviceName){
        //String xpathWay = "//p[text()=\"" + serviceName + "\"]/ancestor::mat-list/mat-list-item[5]//h1[contains(., 'otal')]";
        String xpathWay = "(//mat-card/mat-list/mat-list-item[1]/div/div[2]/p[1]/button/span/p[text()=\"" + serviceName + "\"]/ancestor::mat-list//h1[contains(., 'Total')])";

        WebElement element = webDriver.findElement(By.xpath(xpathWay));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element);
        actions.perform();
        String hotelAgentPriceInSearchString = element.getText();
        log.info(hotelAgentPriceInSearchString);
        if (StringUtils.isEmpty(hotelAgentPriceInSearchString)) {
            waitSec(1);
            hotelAgentPriceInSearchString = element.getText();
        } else if (StringUtils.isBlank(hotelAgentPriceInSearchString)) {
            waitSec(1);
            hotelAgentPriceInSearchString = element.getText();
        }
        try {
            float hotelTotalPriceInSearchFloat = parseStringDataToFloat(hotelAgentPriceInSearchString);
        }
        catch (Exception e1){
            waitSec(3);
        }
        float hotelAgentPriceInSearchFloat = parseStringDataToFloat(hotelAgentPriceInSearchString);
        return hotelAgentPriceInSearchFloat;
    }

    public float getAgentComissionInSearch(String hotelName){
        String xpathWay = "//mat-card/mat-list/mat-list-item[1]/div/div[2]/p[1]/button/span/p[text()=\"" + hotelName + "\"]/ancestor::mat-card/mat-list/app-total-markups/mat-list-item[1]/div/div[2]/div/span";
        WebElement element = webDriver.findElement(By.xpath(xpathWay));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element);
        actions.perform();
        String hotelAgentComissionInSearchString = element.getText();
        if (StringUtils.isEmpty(hotelAgentComissionInSearchString)) {
            waitSec(1);
            hotelAgentComissionInSearchString = element.getText();
        } else if (StringUtils.isBlank(hotelAgentComissionInSearchString)) {
            waitSec(1);
            hotelAgentComissionInSearchString = element.getText();
        }
        try {
            float hotelAgentComissionInSearchFloat = parseStringDataToFloat(hotelAgentComissionInSearchString);
        }
        catch (Exception e1){
            waitSec(3);
        }
        float hotelAgentComissionInSearchFloat = parseStringDataToFloat(hotelAgentComissionInSearchString);
        return hotelAgentComissionInSearchFloat;
    }

    public String getHotelRoomTypeInSearch(String hotelName){
        String hotelRoomTypeInSearch =
                webDriver.findElement(By.xpath("//p[text()=\"" + hotelName + "\"]/ancestor::mat-list//mat-list-item[2]//span[contains(@class, 'title')]")).getText();
        return hotelRoomTypeInSearch;
    }

    public String getTransferTypeInSearch(String transferName){
        String transferTypeInSearch =
                webDriver.findElement(By.xpath("//p[text()=\"" + transferName + "\"]/ancestor::mat-list//mat-list-item[1]//p[contains(@class, 'app-secondary-text mat-line ng-star-inserted')]")).getText();
        return transferTypeInSearch;
    }

    public String getTransferDestinationsInSearch(String transferName){
        String transferDestinationsInSearch =
                webDriver.findElement(By.xpath("//p[text()=\"" + transferName + "\"]/ancestor::mat-list/mat-list-item[2]//p[contains(@class, 'title')]")).getText();
        return  transferDestinationsInSearch;
    }

    public void compareFoundHotelInSearchAndHotelDataInOrder(
            String hotelNameInOrder,  Float touristTotalValueInOrder, Float agentTotalValueInOrder,  Float comissionValueInOrder,
            String hotelRoomTypeInOrder, String hotelRefundTypeInOrder
    ) {
        switchToAgentMode();
        waitSec(1);
        assertEquals(hotelNameInOrder, getServiceNameInSearch(hotelNameInOrder));
        float totalTouristPriceValueInSearch = getTotalTouristPriceValueInSearch(hotelNameInOrder);
        assertEquals(touristTotalValueInOrder, getTotalTouristPriceValueInSearch(hotelNameInOrder), 0.02);
        float getAgentTotalValueInSearch = getAgentTotalValueInSearch(hotelNameInOrder);
        assertEquals(agentTotalValueInOrder, getAgentTotalValueInSearch(hotelNameInOrder), 0.02);
        float getAgentComissionInSearch = getAgentComissionInSearch(hotelNameInOrder);
        assertEquals(comissionValueInOrder, getAgentComissionInSearch(hotelNameInOrder), 0.02);
        assertEquals(hotelRefundTypeInOrder, getServiceRefundTypeInSearch(hotelNameInOrder));
        assertEquals(hotelRoomTypeInOrder, getHotelRoomTypeInSearch(hotelNameInOrder));
    }

    public void compareFoundTransferInSearchAndTransferDataInOrder(
            String serviceNameInOrder,  Float touristTotalValueInOrder, Float agentTotalValueInOrder,
            Float comissionValueInOrder, String transferTypeInOrder, String serviceRefundTypeInOrder,
            String transferDestinationsInOrder
    ) {
        switchToAgentMode();
        waitSec(1);
        assertEquals(serviceNameInOrder, getServiceNameInSearch(serviceNameInOrder));
        float totalTouristPriceValueInSearch = getTotalTouristPriceValueInSearch(serviceNameInOrder);
        assertEquals(touristTotalValueInOrder, getTotalTouristPriceValueInSearch(serviceNameInOrder), 0.02);
        float agentTotalValueInSearch = getAgentTotalValueInSearch(serviceNameInOrder);
        float getAgentTotalValueInSearch = getAgentTotalValueInSearch(serviceNameInOrder);
        assertEquals(agentTotalValueInOrder, getAgentTotalValueInSearch(serviceNameInOrder), 0.02);
        //float getAgentComissionInSearch = getAgentComissionInSearch(serviceNameInOrder);
        // TODO пока отображение комиссии на странице поиска сломано в самой системе
        //assertEquals(comissionValueInOrder, getAgentComissionInSearch(serviceNameInOrder), 0.02);
        assertEquals(serviceRefundTypeInOrder, getServiceRefundTypeInSearch(serviceNameInOrder));
        assertEquals(transferTypeInOrder, getTransferTypeInSearch(serviceNameInOrder));
        assertEquals(transferDestinationsInOrder, getTransferDestinationsInSearch(serviceNameInOrder));
    }

    public void compareFoundAirTicketsInSearchAndAirTicketsDataInOrder(
            String serviceNameInOrder,  Float touristTotalValueInOrder, Float agentTotalValueInOrder,
            Float comissionValueInOrder, String transferTypeInOrder, String serviceRefundTypeInOrder,
            String transferDestinationsInOrder
    ) {
        switchToAgentMode();
        waitSec(1);
        assertEquals(serviceNameInOrder, getServiceNameInSearch(serviceNameInOrder));
        float totalTouristPriceValueInSearch = getTotalTouristPriceValueInSearch(serviceNameInOrder);
        assertEquals(touristTotalValueInOrder, getTotalTouristPriceValueInSearch(serviceNameInOrder), 0.02);
        float agentTotalValueInSearch = getAgentTotalValueInSearch(serviceNameInOrder);
        float getAgentTotalValueInSearch = getAgentTotalValueInSearch(serviceNameInOrder);
        assertEquals(agentTotalValueInOrder, getAgentTotalValueInSearch(serviceNameInOrder), 0.02);
        //float getAgentComissionInSearch = getAgentComissionInSearch(serviceNameInOrder);
        // TODO пока отображение комиссии на странице поиска сломано в самой системе
        //assertEquals(comissionValueInOrder, getAgentComissionInSearch(serviceNameInOrder), 0.02);
        assertEquals(serviceRefundTypeInOrder, getServiceRefundTypeInSearch(serviceNameInOrder));
        assertEquals(transferTypeInOrder, getTransferTypeInSearch(serviceNameInOrder));
        assertEquals(transferDestinationsInOrder, getTransferDestinationsInSearch(serviceNameInOrder));
    }
}
