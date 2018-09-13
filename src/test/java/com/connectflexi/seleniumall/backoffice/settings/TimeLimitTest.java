package com.connectflexi.seleniumall.backoffice.settings;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.backoffice.LoginBack;
import com.connectflexi.seleniumall.backoffice.settings.pages.TimeLimitPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;

/**
 * Created by dsh on 12.01.2018.
 */
public class TimeLimitTest extends AbstractUITest {

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
        getUrl("/resources/admin/paymentsetting/index.html");
    }

    String sellerName = "d725f1a0-d0f2-43aa-9511-b31eec34a142";

    @Test
    public void timeLimitForSeller() throws Exception{
        TimeLimitPage timeLimitPage = new TimeLimitPage(webDriver);
        timeLimitPage.createTimeLimitForSeller(this.sellerName);
        timeLimitPage.editTimeLimitForSeller(this.sellerName);
        timeLimitPage.deleteTimeLimitForSeller(this.sellerName);
    }
}
