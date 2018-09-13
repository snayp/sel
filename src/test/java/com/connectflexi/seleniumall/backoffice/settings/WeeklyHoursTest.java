package com.connectflexi.seleniumall.backoffice.settings;

import com.connectflexi.seleniumall.AbstractUITest;
import com.connectflexi.seleniumall.backoffice.LoginBack;
import com.connectflexi.seleniumall.backoffice.settings.pages.WeeklyHoursPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;

public class WeeklyHoursTest extends AbstractUITest {

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

    String country = "Russian Federation";
    String city = "Moscow";
    String company = "3469afe2-7115-43c2-b5cb-bb2497eb97fb";
    String dateFrom = "2018-01-22";
    String dateTill = "2018-01-31";
    boolean status = true;
    String contactNumber = "+90000222933";
    String skypeName = "testername";
    String conact24Number = "+79034488765";
    String email = "test@mail.ru";
    boolean allweekdays = true;
    String[] timeFrom = {"2", "10"};
    String[] timeTill = {"17", "40"};
    String day = null;

    @Test
    public void createDefaultWeeklyHoursTest() throws Exception {
        WeeklyHoursPage weeklyHoursPage = new WeeklyHoursPage(webDriver);
        weeklyHoursPage.creationInit();
        weeklyHoursPage.createOrEditWeeklyHoursInfo(
                this.country, this.city, this.company, this.dateFrom, this.dateTill, this.status,
                this.contactNumber, this.skypeName, this.conact24Number, this.email,
                this.allweekdays, day, this.timeFrom, this.timeTill);
        weeklyHoursPage.searchWeeklyHoursInfo(this.country, this.city, this.company, this.dateFrom, this.dateTill);
        weeklyHoursPage.openWeeklyHoursFirstElement();
        weeklyHoursPage.checkWeeklyHoursInfo(this.country, this.city, this.company, this.dateFrom, this.dateTill, this.status,
                this.contactNumber, this.skypeName, this.conact24Number, this.email,
                this.allweekdays, day, this.timeFrom, this.timeTill);
        weeklyHoursPage.searchWeeklyHoursInfo(this.country, this.city, this.company, this.dateFrom, this.dateTill);
        this.day = "monday";
        this.dateFrom = "2018-02-10";
        this.dateTill = "2018-02-15";
        weeklyHoursPage.openWeeklyHoursFirstElement();
        weeklyHoursPage.createOrEditWeeklyHoursInfo(
                this.country, this.city, this.company, this.dateFrom, this.dateTill, this.status,
                this.contactNumber, this.skypeName, this.conact24Number, this.email,
                this.allweekdays, day, this.timeFrom, this.timeTill);
        weeklyHoursPage.searchWeeklyHoursInfo(this.country, this.city, this.company, this.dateFrom, this.dateTill);
        weeklyHoursPage.deleteFirstElementWeeklyHoursInfo();
    }



}
