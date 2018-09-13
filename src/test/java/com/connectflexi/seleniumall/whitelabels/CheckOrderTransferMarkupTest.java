package com.connectflexi.seleniumall.whitelabels;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.backoffice.LoginBack;
import com.connectflexi.seleniumall.backoffice.settings.pages.ReservationPage;
import com.connectflexi.seleniumall.whitelabels.pages.OrderPage;
import com.connectflexi.seleniumall.whitelabels.pages.TransferSearchPage;
import com.connectflexi.seleniumall.whitelabels.pages.FrontPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;

public class CheckOrderTransferMarkupTest extends AbstractUITest {

    @Before
    public void init() throws Exception {
        Point point = new Point(2000, 1);
        webDriver.manage().window().setPosition(point);
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCheckOrderTransferMarkup() throws Exception {

        String emailB2B = "Trekksoft";
        String passwordB2B = "Trekksoft";
        String[] date = {"23", "FEB", "2018"};
        String emailAdminBackOffice = "Travelcard123";
        String passwordAdminBackOffice = "Travelcard123";
        String autotestCompanyName = "B2B Autotest 3 link";
        String paidToCompanyName = "Travelcard International";
        String comment = "autotest payers";
        String flightNum = "1234567";
        String fromCity = "Warsaw";
        String fromAccomodation = "Warsaw Chopin Airport";
        String toCity = "Warsaw";
        String toAccomodation = "Novotel Warsaw Centrum";
        String timeHours = "11";
        String timeMinutes = "00";

        FrontPage frontPage = new FrontPage(webDriver);
        frontPage.login(emailB2B, passwordB2B);
        TransferSearchPage transferSearchPage = new TransferSearchPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        transferSearchPage.findTransfer(fromCity, fromAccomodation, toCity, toAccomodation, date, "1", timeHours, timeMinutes);

        transferSearchPage.addAndScrollFoundSearchResultByIndex("1");
        orderPage.choosePayerAndTouristByIndexes(1, 1, comment, flightNum);

        String accountName = transferSearchPage.getAccountName();
        String commentInOrder = orderPage.getOrderComment();
        String flightDataInOrder = orderPage.getTransferFlightData();
        String clientNameInOrder = orderPage.getTouristNameFromOrder();
        String serviceNameInOrder = orderPage.getOrderFirstElementServiceName();
        String transferTypeInOrder = orderPage.getOrderTransferType();
        String orderRefundTypeInOrder = orderPage.getOrderRefundType();
        Float touristTotalValueInOrder = orderPage.getOrderTouristTotalCostValue();
        Float agentTotalValueInOrder = orderPage.getOrderAgentTotalCostValue();
        Float comissionValueInOrder = orderPage.getOrderAgentComissionValue();
        String transferDestinationsInOrder = orderPage.getOrderTransferDestinations();
        String orderIdInOrder = orderPage.getOrderId();

        transferSearchPage.compareFoundTransferInSearchAndTransferDataInOrder
                (serviceNameInOrder,  touristTotalValueInOrder, agentTotalValueInOrder, comissionValueInOrder,
                        transferTypeInOrder, orderRefundTypeInOrder, transferDestinationsInOrder);

        orderPage.payOrderByDeposit();
//        orderPage.payOrderByCard();
//        CardPaymentMethodsPage cardPaymentPage = new CardPaymentMethodsPage(webDriver);
//        cardPaymentPage.payByCardDillFieldsAndProceed("5413330000000001", "859");
        orderPage.checkCardPaymentResult();
        LoginBack loginBack = new LoginBack(webDriver);
        loginBack.login(emailAdminBackOffice, passwordAdminBackOffice);
        ReservationPage reservationPage = new ReservationPage(webDriver);

        reservationPage.checkOrderDataInBackofficeForTransfer(clientNameInOrder, transferDestinationsInOrder, transferTypeInOrder, accountName,
                comissionValueInOrder, agentTotalValueInOrder, orderIdInOrder, flightDataInOrder, commentInOrder, autotestCompanyName,
                paidToCompanyName, orderRefundTypeInOrder);
    }
}
