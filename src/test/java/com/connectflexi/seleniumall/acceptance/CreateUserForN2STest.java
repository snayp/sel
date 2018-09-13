package com.connectflexi.seleniumall.acceptance;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.backoffice.CompanyPage;
import com.connectflexi.seleniumall.backoffice.LoginBack;
import com.connectflexi.seleniumall.n2s.LoginN2S;
import com.connectflexi.seleniumall.whitelabels.pages.AccomodationSearchPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

/**
 * Created by dsh on 27.11.2017.
 */
public class CreateUserForN2STest extends AbstractUITest {

    @Test
    @DisplayName("Создаем агента для n2s")
    public void testCreateUserForN2S() throws Exception {
        String[] checkIn = {"25", "MAR", "2018"};
        String[] checkOut = {"27", "MAR", "2018"};
        Random random = new Random();
        //логинимся в бэкофис

        String usernameBack = settings.getProperty("selenium.uat.louverture.user");
        String passwordBack = settings.getProperty("selenium.uat.louverture.pass");
        LoginBack loginBack = new LoginBack(webDriver);
        loginBack.login(usernameBack,passwordBack);

        //создаем Sub Seller

        String motherCompanyName = "Louverture Travel";
        String companyName = UUID.randomUUID().toString();

        CompanyPage companyPage = new CompanyPage(webDriver);
        companyPage.createSeller(companyName);

        waitSec(1);

        //получаем ID созданной компании
        CompanyPage companyPage2 = new CompanyPage(webDriver);
        String companyID;
        companyID = companyPage2.getCompanyIDByName(companyName);

        //ищем компанию предка

        companyPage2.getCompany(motherCompanyName);

        //создаем группу

        companyPage2.goToMarketingRulesList();
        String groupName = companyName.substring(0,8);
        companyPage2.createGroup(groupName);

        //переносим созданную компанию в группу

        companyPage2.goToMarketingRules();
        companyPage2.filterMarketingRules(groupName);

        companyPage2.drugCompanyToGroup(companyID, groupName);

        //открываем сервисы для группы

        companyPage2.openServicesForGroup(groupName);

        //ищем созданную компанию

        companyPage2.getCompany(companyName);

        //проверяем атрибуты компании

        companyPage2.checkCompany(companyName);

        //создаем пользователя с ролью агент

        String testagentUser = String.valueOf((random.nextInt() & Integer.MAX_VALUE));
        String testagentPass = String.valueOf((random.nextInt() & Integer.MAX_VALUE));
        companyPage.createAgent(testagentUser, testagentPass);

        //логинимся на n2s созданным пользователем

        LoginN2S loginN2S = new LoginN2S(webDriver);
        loginN2S.login(testagentUser, testagentPass);

        //ищем отель по городу

        AccomodationSearchPage accomodationSearchPage = new AccomodationSearchPage(webDriver);
        accomodationSearchPage.findAccomodation(
                "Spain", null, "Barcelona", null, checkIn, checkOut,
                null, String.valueOf(1), null, false);
    }

}

