package com.connectflexi.seleniumall.whitelabels;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.backoffice.LoginBack;
import com.connectflexi.seleniumall.backoffice.settings.pages.ReservationPage;
import com.connectflexi.seleniumall.whitelabels.pages.AirTicketsSearchPage;
import com.connectflexi.seleniumall.whitelabels.pages.OrderPage;
import com.connectflexi.seleniumall.whitelabels.pages.TransferSearchPage;
import com.connectflexi.seleniumall.whitelabels.pages.FrontPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;

public class CheckOrderFlightTicketsMarkupTest extends AbstractUITest{

    @Before
    public void init() throws Exception {
        Point point = new Point(2000, 1);
        webDriver.manage().window().setPosition(point);
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCheckOrderTransferMarkup() throws Exception {

        String emailB2B = "w2284001@mvrht.net";
        String passwordB2B = "w2284001@mvrht.net";
        String[] date = {"27", "MAR", "2018"};
        String emailAdminBackOffice = "Travelcard123";
        String passwordAdminBackOffice = "Travelcard123";
        String autotestCompanyName = "B2B Autotest 3 link";
        String paidToCompanyName = "Travelcard International";
        String comment = "autotest payers";
        String fromCity = "Moscow";
        String toCity = "Berlin";

        FrontPage frontPage = new FrontPage(webDriver);
        frontPage.login(emailB2B, passwordB2B);
        AirTicketsSearchPage airTicketsSearchPage = new AirTicketsSearchPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        airTicketsSearchPage.findAirTickets(fromCity, toCity, date);
        airTicketsSearchPage.addAndScrollFoundSearchResultByIndex("1");
        orderPage.choosePayerAndTouristByIndexes(1, 1, comment);

        String accountName = airTicketsSearchPage.getAccountName();
        String commentInOrder = orderPage.getOrderComment();
        String clientNameInOrder = orderPage.getTouristNameFromOrder();
        String serviceNameInOrder = orderPage.getOrderFirstElementServiceName();
        String orderRefundTypeInOrder = orderPage.getOrderRefundType();
        Float touristTotalValueInOrder = orderPage.getOrderTouristTotalCostValue();
        Float agentTotalValueInOrder = orderPage.getOrderAgentTotalCostValue();
        Float comissionValueInOrder = orderPage.getOrderAgentComissionValue();
        String orderIdInOrder = orderPage.getOrderId();

        //orderPage.payOrderByDeposit();

        LoginBack loginBack = new LoginBack(webDriver);
        loginBack.login(emailAdminBackOffice, passwordAdminBackOffice);
        ReservationPage reservationPage = new ReservationPage(webDriver);
        reservationPage.checkOrderDataInBackofficeForAirtickets(clientNameInOrder, accountName, serviceNameInOrder,
                comissionValueInOrder, agentTotalValueInOrder, orderIdInOrder, commentInOrder, autotestCompanyName,
                paidToCompanyName, orderRefundTypeInOrder);


    }
}
