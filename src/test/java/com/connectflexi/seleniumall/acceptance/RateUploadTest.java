package com.connectflexi.seleniumall.acceptance;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.rateupload.CreateAccomodation;
import com.connectflexi.seleniumall.rateupload.LoginRate;
import org.junit.Test;

/**
 * Created by dsh on 01.12.2017.
 */
public class RateUploadTest extends AbstractUITest {



    @Test
    public void findRateUploadandBookTest() throws Exception {

        //логинимся в Rates Upload

        String usernameRates = settings.getProperty("selenium.dev.rates.user");
        String passwordRates = settings.getProperty("selenium.dev.rates.pass");
        LoginRate loginRate = new LoginRate(webDriver);
        loginRate.login(usernameRates, passwordRates);

        //создаем accomodation
        CreateAccomodation createAccomodation = new CreateAccomodation(webDriver);
        createAccomodation.createAccomodation();

    }

}
