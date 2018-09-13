package com.connectflexi.seleniumall.whitelabels;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.whitelabels.pages.FrontPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;
import java.util.Random;

public class CreateUserB2BdistributedTravelCardTest extends AbstractUITest {

    @Before
    public void init() throws Exception {
        Point point = new Point(2000, 1);
        webDriver.manage().window().setPosition(point);
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCreateUserB2BdistributedTravelCard() throws Exception {

        Random random = new Random();
        String email = "autotest3@mail.ru";
        String password = "123567890";

        FrontPage frontPage = new FrontPage(webDriver);
        frontPage.createB2C(email, password);


    }
}
