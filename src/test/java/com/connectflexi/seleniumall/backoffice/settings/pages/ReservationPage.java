package com.connectflexi.seleniumall.backoffice.settings.pages;

import com.connectflexi.seleniumall.AbstractUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class ReservationPage extends AbstractUITest{

    @FindBy(xpath = "//label[text()=\"Order ID\"]/following-sibling::input")
    private WebElement order_id_input;

    @FindBy(xpath = "//button[text()=\"Search\"]")
    private WebElement search_button;

    @FindBy(xpath = "(//h2)[1]")
    private WebElement order_id_first_element;

    @FindBy(xpath = "(//tr[contains(@ng-repeat, 'order')])[1]/td[3]")
    private WebElement hotel_name_and_room_type_in_first_element;

    @FindBy(xpath = "(//tr[contains(@ng-repeat, 'tourist')])//td[2]")
    private WebElement client_name_in_first_element;

    @FindBy(xpath = "//b[contains(., 'Time Limit')]/parent::p")
    private WebElement time_limit_in_first_element;

    @FindBy(xpath = "//b[contains(., 'Username')]/parent::p")
    private WebElement username_in_first_element;

    @FindBy(xpath = "//b[contains(., 'Start')]/parent::p")
    private WebElement reservation_start_in_first_element;

    @FindBy(xpath = "//b[contains(., 'End')]/parent::p")
    private WebElement reservation_end_in_first_element;

    @FindBy(xpath = "(//i[contains(@class, 'fa fa-info')])[1]")
    private WebElement first_information_icon_first_element;

    @FindBy(xpath = "//div[contains(@class, 'buttons-bar')]/div[contains(., 'Commission')]")
    private WebElement first_information_icon_comission_first_element;

    @FindBy(xpath = "(//li[contains(., 'Services')])[2]")
    private WebElement services_tab_in_first_element;

    @FindBy(xpath = "(//li[contains(., 'Clients')])[2]")
    private WebElement clients_tab_in_first_element;

    @FindBy(xpath = "(//li[contains(., 'Payments')])[2]")
    private WebElement payments_tab_in_first_element;

    @FindBy(xpath = "//i[contains(@class, 'fa fa-commenting-o fa-2x')]")
    private WebElement comments_tab_in_first_element;

    @FindBy(xpath = "//textarea[contains(@name, 'remarks')]")
    private WebElement comments_tab_input_area_first_element;

    @FindBy(xpath = "//button[contains(., 'Close')]")
    private WebElement comments_tab_close_button_first_element;

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public ReservationPage(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setBaseUrl(settings.getProperty("selenium.back.uat.location", "https://backoffice.uat.connectflexi.com/"));
    }

    public void openMainPage(){
        log.info("Open main page");
        getUrl("/resources/admin/reservation/index.html");
        waitSec(1);
        waitForLoad(webDriver);
    }

    public void findReservationByID(String id) {
        waitElement(search_button, (long) 2);
        order_id_input.sendKeys(id);
        search_button.click();
        waitSec(1);
        waitForLoad(webDriver);
    }

    public void goToServicesTab(){
        waitElement(services_tab_in_first_element, (long) 2);
        services_tab_in_first_element.click();
    }

    public void goToClientsTab(){
        waitElement(clients_tab_in_first_element, (long) 2);
        clients_tab_in_first_element.click();
    }

    public String getOrderIdFromFirstElement(){
        String orderIDString = order_id_first_element.getText();
        return orderIDString;
    }

    public String getServiceNameOnlyFromFirstElement(){
        goToServicesTab();
        waitElement(hotel_name_and_room_type_in_first_element, (long) 2);
        String serviceName = hotel_name_and_room_type_in_first_element.getText();
        serviceName = (parseDataByComma(serviceName))[0];
        return serviceName;
    }

    public String getServiceNameFromFirstElementWholeString(){
        goToServicesTab();
        waitElement(hotel_name_and_room_type_in_first_element, (long) 2);
        String serviceName = hotel_name_and_room_type_in_first_element.getText();
        return serviceName;
    }

    public String getHotelRoomTypeFromFirstElement(){
        goToServicesTab();
        waitElement(hotel_name_and_room_type_in_first_element, (long) 2);
        String hotelRoomType = hotel_name_and_room_type_in_first_element.getText();
        hotelRoomType = (parseDataByComma(hotelRoomType))[1];
        return hotelRoomType;
    }

    public String[] parseDataByComma(String incData)  {
        String[] incDataParts = incData.split(",");
        return incDataParts;
    }

    public String getCommentsFromFirstElement(){
        goToServicesTab();
        waitElement(comments_tab_in_first_element, (long) 2);
        comments_tab_in_first_element.click();
        waitElement(comments_tab_input_area_first_element, (long) 2);
        String comments = comments_tab_input_area_first_element.getAttribute("value");
        waitElement(comments_tab_close_button_first_element, (long) 2);
        comments_tab_close_button_first_element.click();
        return comments;
    }

    public String getTimeLimitFromFirstElement(){
        String timeLimit = time_limit_in_first_element.getAttribute("innerText");
        return timeLimit;
    }

    public String getUsernameFromFirstElement(){
        String userName = username_in_first_element.getAttribute("innerText");
        return userName;
    }

    public String getReservationStartFromFirstElement(){
        String reservationStart = reservation_start_in_first_element.getAttribute("innerText");
        return reservationStart;
    }

    public String getReservationEndFromFirstElement(){
        String reservationEnd = reservation_end_in_first_element.getAttribute("innerText");
        return reservationEnd;
    }

    public String getClientNameFromFirstElement(){
        goToClientsTab();
        waitElement(client_name_in_first_element, (long) 2);
        String clientName = client_name_in_first_element.getText();
        return clientName;
    }

    public float getTotalPaidAmountFromPaymentsTabFirstElement(String paidFrom, String paidTo){
        waitElement(payments_tab_in_first_element, (long) 2);
        payments_tab_in_first_element.click();
        waitSec(1);
        String totalAmountString =
                webDriver.findElement(By.xpath("(//td[contains(., \"" + paidFrom + "\")])[1]/following-sibling::td[contains(., \"" + paidTo + "\")]/following-sibling::td")).getText();
        totalAmountString = totalAmountString.replaceAll("[^\\d.]", "");
        return Float.valueOf(totalAmountString);
    }

    public float getComissionFromFirstElement(){
        waitElement(first_information_icon_first_element, (long) 2);
        first_information_icon_first_element.click();
        waitElement(first_information_icon_comission_first_element, (long) 2);
        String comission = (first_information_icon_comission_first_element.getText()).replaceAll("[^\\d.]", "");
        first_information_icon_first_element.click();
        return Float.valueOf(comission);
    }

    public void checkOrderDataInBackofficeForAccomodation(
            String clientName, String hotelName, String hotelRoomType, String accountName, Float comissionValue,
            Float agentTotalValue,
            String orderId, String commentOrder, String paidFrom, String paidTo, String[] checkIn, String[] checkOut,
            String timeLimit)
            // todo доделать даты
    {
        findReservationByID(String.valueOf(orderId));
        assertEquals(String.valueOf(getOrderIdFromFirstElement()), String.valueOf(orderId));
        assertEquals(hotelName, getServiceNameOnlyFromFirstElement());
        assertEquals(hotelRoomType, getHotelRoomTypeFromFirstElement().split(";")[0]);
        assertThat(getUsernameFromFirstElement(), containsString(accountName));
        assertEquals(getCommentsFromFirstElement(), commentOrder);
        assertEquals(getComissionFromFirstElement(), comissionValue, 0.02);
        assertEquals(getClientNameFromFirstElement(), clientName);
        assertEquals(getTotalPaidAmountFromPaymentsTabFirstElement(paidFrom, paidTo), agentTotalValue, 0.02);
        String locCheckIn = checkIn[1] + " " + checkIn[0] + ", " + checkIn[2];
        locCheckIn = "Reservations Start: " + locCheckIn.substring(0,1).toUpperCase() + locCheckIn.substring(1).toLowerCase();
        String locCheckOut = checkOut[1] + " " + checkOut[0] + ", " + checkOut[2]; // конвертим входящие массивы в строку
        locCheckOut = "Reservations End: " + locCheckOut.substring(0,1).toUpperCase() + locCheckOut.substring(1).toLowerCase();
        // попутно приводим строку к нужному case
        assertEquals(getReservationStartFromFirstElement(), locCheckIn);
        assertEquals(getReservationEndFromFirstElement(), locCheckOut);
        assertEquals((getTimeLimitFromFirstElement().replaceAll("Time Limit: ", "")).toLowerCase(),
                timeLimit.toLowerCase());
    }

    public void checkOrderDataInBackofficeForTransfer
            (String clientName, String destinations, String transferType, String accountName, Float comissionValue,
             Float agentTotalValue, String orderId, String flightData, String commentOrder, String paidFrom, String paidTo,
             String timeLimit){
        // todo доделать даты
        openMainPage();
        findReservationByID(String.valueOf(orderId));
        assertEquals(String.valueOf(getOrderIdFromFirstElement()), String.valueOf(orderId));
        String locDestinations = destinations.replaceAll("\\s–.*?,", "");
        // вырезаем все символы от пробела и - до запятой
        String [] tmpArr = locDestinations.split(" ", 2);
        locDestinations = tmpArr[1].replaceAll("[^A-Za-z]+", "");
        // удаляем лишнее упоминание города из строки а так же все лишние символы пунктуаций и пробелов
        assertEquals(locDestinations, getServiceNameOnlyFromFirstElement().replaceAll("[^A-Za-z]+", ""));
        assertThat(transferType, containsString(getHotelRoomTypeFromFirstElement().substring(1)));
        // сабстринг вырезает первый пробел в строке
        assertThat(getUsernameFromFirstElement(), containsString(accountName));
        assertEquals(getCommentsFromFirstElement(), commentOrder);
        assertEquals(getComissionFromFirstElement(), comissionValue, 0.02);
        assertEquals(getClientNameFromFirstElement(), clientName);
        assertEquals(getTotalPaidAmountFromPaymentsTabFirstElement(paidFrom, paidTo), agentTotalValue, 0.02);
        assertEquals((getTimeLimitFromFirstElement().replaceAll("Time Limit: ", "")).toLowerCase(),
                timeLimit.toLowerCase());
    }

    public void checkOrderDataInBackofficeForAirtickets
            (String clientName, String accountName, String serviceNameInOrder, Float comissionValue,
             Float agentTotalValue, String orderId, String commentOrder, String paidFrom, String paidTo,
             String timeLimit){
        // todo доделать даты
        openMainPage();
        findReservationByID(String.valueOf(orderId));
        assertEquals(String.valueOf(getOrderIdFromFirstElement()), String.valueOf(orderId));
        assertThat(getUsernameFromFirstElement(), containsString(accountName));
        assertEquals(getServiceNameOnlyFromFirstElement(), serviceNameInOrder);
        assertEquals(getCommentsFromFirstElement(), commentOrder);
        assertEquals(getComissionFromFirstElement(), comissionValue, 0.02);
        assertEquals(getClientNameFromFirstElement(), clientName);
        assertEquals(getTotalPaidAmountFromPaymentsTabFirstElement(paidFrom, paidTo), agentTotalValue, 0.02);
        assertEquals((getTimeLimitFromFirstElement().replaceAll("Time Limit: ", "")).toLowerCase(),
                timeLimit.toLowerCase());
    }

}
