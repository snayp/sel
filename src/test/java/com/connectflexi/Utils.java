package com.connectflexi;

import io.restassured.RestAssured;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dsh on 28.11.2017.
 */
public class Utils {

    public int httpResponseCodeViaGet(String url) {
        return RestAssured.get(url).statusCode();
    }

    public int httpResponseCodeViaPost(String url) {
        return RestAssured.post(url).statusCode();
    }

    public static Date parseDate(String date, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }

    public static String formatDate(String date, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

}
