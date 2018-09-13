package com.connectflexi.seleniumall.whitelabels;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.backoffice.LoginBack;
import com.connectflexi.seleniumall.backoffice.settings.pages.ReservationPage;
import com.connectflexi.seleniumall.whitelabels.pages.AccomodationSearchPage;
import com.connectflexi.seleniumall.whitelabels.pages.OrderPage;
import com.connectflexi.seleniumall.whitelabels.pages.FrontPage;
import com.connectflexi.seleniumall.whitelabels.pages.CardPaymentMethodsPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import java.util.ArrayList;

public class CheckOrderAccomodationMarkupTest extends AbstractUITest {

    @Test
    public void testCheckOrderMarkupTest() throws Exception {

        String emailB2B = "Trekksoft";
        String passwordB2B = "Trekksoft";
        String[] checkIn = {"25", "MAR", "2018"};
        String[] checkOut = {"27", "MAR", "2018"};
        String emailAdminBackOffice = "OuvertProd";
        String passwordAdminBackOffice = "OuvertProd";
        String autotestCompanyName = "B2B Autotest 3 link";
        String paidToCompanyName = "Travelcard International";
        String comment = "autotest payers";
        String refundType = "Non-refundable";

        FrontPage frontPage = new FrontPage(webDriver);
        frontPage.login(emailB2B, passwordB2B);

        AccomodationSearchPage accomodationSearchPage = new AccomodationSearchPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        accomodationSearchPage.findAccomodation(
                "Poland", null, "Warsaw", null, checkIn, checkOut,
                null, String.valueOf(1), null, false);
        accomodationSearchPage.addAndScrollFoundSearchResultByIndex("4");
        orderPage.choosePayerAndTouristByIndexes(1, 1, comment);

        String accountName = accomodationSearchPage.getAccountName();
        String commentInOrder = orderPage.getOrderComment();
        String clientNameInOrder = orderPage.getTouristNameFromOrder();
        String hotelNameInOrder = orderPage.getOrderFirstElementServiceName();
        String hotelRoomTypeInOrder = orderPage.getOrderHotelRoomType();
        String hotelRefundTypeInOrder = orderPage.getOrderRefundType();
        Float touristTotalValueInOrder = orderPage.getOrderTouristTotalCostValue();
        Float agentTotalValueInOrder = touristTotalValueInOrder;//orderPage.getOrderAgentTotalCostValue()
        Float comissionValueInOrder = orderPage.getOrderAgentComissionValue();
        String orderIdInOrder = orderPage.getOrderId();

        accomodationSearchPage.compareFoundHotelInSearchAndHotelDataInOrder
                (hotelNameInOrder,  touristTotalValueInOrder, agentTotalValueInOrder, comissionValueInOrder, hotelRoomTypeInOrder,
                        hotelRefundTypeInOrder);

        orderPage.payOrderByDeposit();
//        orderPage.payOrderByCard();
//        orderPage.payOrderByStrype();
//        CardPaymentMethodsPage cardPaymentPage = new CardPaymentMethodsPage(webDriver);
//        cardPaymentPage.payByStripeAndProceed("tester", "test street", "Moscow", "111222",
//                "4242424242424242", "1022", "123");
//        orderPage.checkCardPaymentResult();

        LoginBack loginBack = new LoginBack(webDriver);
        loginBack.login(emailAdminBackOffice, passwordAdminBackOffice);
        ReservationPage reservationPage = new ReservationPage(webDriver);
        reservationPage.checkOrderDataInBackofficeForAccomodation(clientNameInOrder, hotelNameInOrder, hotelRoomTypeInOrder, accountName,
                comissionValueInOrder, agentTotalValueInOrder, orderIdInOrder, commentInOrder, autotestCompanyName, paidToCompanyName, checkIn,
                checkOut, hotelRefundTypeInOrder);
    }
}
