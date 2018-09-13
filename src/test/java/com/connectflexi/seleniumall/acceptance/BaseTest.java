package com.connectflexi.seleniumall.acceptance;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.authority.LicensePage;
import com.connectflexi.seleniumall.authority.LoginAuth;
import org.junit.Test;

/**
 * Created by dsh on 13.12.2017.
 */
public class BaseTest extends AbstractUITest{

    @Test
    public void testBase() throws Exception {

        //логинимся в authority

        String usernameAuth = settings.getProperty("selenium.auth.user");
        String passwordAuth = settings.getProperty("selenium.auth.pass");
        LoginAuth loginAuth = new LoginAuth(webDriver);
        loginAuth.login(usernameAuth, passwordAuth);

        //даем лицензию в authority и категорию

        String licenseCategory = "Accommodation";
        String companyName = "123f5966-5bdc-4e34-a4cf-889d14fec20c";

        LicensePage licensePage = new LicensePage(webDriver);
        licensePage.addCategory(companyName, licenseCategory);
    }

}
