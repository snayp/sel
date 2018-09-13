package com.connectflexi.seleniumall.backoffice.settings;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.backoffice.LoginBack;
import com.connectflexi.seleniumall.backoffice.settings.pages.ClxFeePage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;

public class ClxFeePageTest extends AbstractUITest {

    @Before
    public void init() throws Exception {

        Point point = new Point(2000, 1);
        webDriver.manage().window().setPosition(point);
        webDriver.manage().window().maximize();
        //логинимся в бэкофис
        String usernameBack = settings.getProperty("selenium.dev.uitestprod.user");
        String passwordBack = settings.getProperty("selenium.dev.uitestprod.pass");
        LoginBack loginBack = new LoginBack(webDriver);
        loginBack.login(usernameBack, passwordBack);
    }

    @Test
    public void createClxFeeTest() throws Exception {
        String sellerName = "fdb7bd9d-9fb7-4a5a-a0ab-bead49fecff5";
        String percentage = "5";
        ClxFeePage clxFeePage = new ClxFeePage(webDriver);
        clxFeePage.initCreation();
        clxFeePage.createOrEditCLXForSeller(sellerName, percentage, true, true, false);
        clxFeePage.filterFindSeller(sellerName);
        clxFeePage.editFirstSellerCLXinfo();
        clxFeePage.checkCLXinfo(sellerName, percentage);
        percentage = "20";
        clxFeePage.editFirstSellerCLXinfo();
        clxFeePage.createOrEditCLXForSeller(sellerName, percentage, true, true, true);
        clxFeePage.filterFindSeller(sellerName);
        clxFeePage.editFirstSellerCLXinfo();
        clxFeePage.checkCLXinfo(sellerName, percentage);
        clxFeePage.filterFindSeller(sellerName);
        clxFeePage.deleteCLXforFirstSeller();
    }
}
