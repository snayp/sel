package com.connectflexi.seleniumall;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;


public class AbstractUITest extends BasePage {

	private static final String settingsFileName = "selenium.properties";

    public static final Properties settings = new Properties();

    @Before
	public void setup() throws Exception {
		settings.load(getClass().getClassLoader().getResourceAsStream(settingsFileName));
        System.setProperty("webdriver.chrome.driver", settings.getProperty("selenium.chrome.driver"));
        webDriver = new ChromeDriver();
        Point point = new Point(-2000, 1);
        webDriver.manage().window().setPosition(point);
        webDriver.manage().window().maximize();
	}

	@After
	public void cleanup() {
		if (webDriver != null) {
//			webDriver.close();
//	        webDriver.quit();
		}
	}

    public void waitSec(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            log.error("Sleepless thread here. " + e.getMessage());
        }
    }


    public void waitElement(WebElement element, Long timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        try {
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(element))); }
        catch (Exception e){
            //int i = timeout.intValue();
            waitSec(4);
            wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(element)));
        }
    }

    public void waitForLoad(WebDriver driver) {
        this.webDriver = driver;
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

//    public boolean waitForJSandJQueryToLoad(WebDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//
//        // wait for jQuery to load
//        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//
//            public Boolean apply(WebDriver driver) {
//                try {
//                    return ((Long)((JavascriptExecutor)getDriver()).executeScript("return jQuery.active") == 0);
//                }
//                catch (Exception e) {
//                    // no jQuery present
//                    return true;
//                }
//            }
//        };
//
//        // wait for Javascript to load
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//
//            public Boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor)getDriver()).executeScript("return document.readyState")
//                        .toString().equals("complete");
//            }
//        };
//
//        return wait.until(jQueryLoad) && wait.until(jsLoad);
//    }

    public String executeJavascript(String javascriptSnippet) {
        return ((JavascriptExecutor) webDriver).executeScript(javascriptSnippet).toString();
    }

    public void getUrl(String relativeUrl) {
        log.info("Accessing URL: " + relativeUrl);
        webDriver.get(getBaseUrl() + relativeUrl);
    }

    public WebElement findElementById(String id) {
        try {
            return webDriver.findElement(By.id(id));
        } catch (NoSuchElementException e) {
            log.error("Field with id " + id + " not found");
            return null;
        }
    }

    public WebElement findElementByName(String name) {
        try {
            return webDriver.findElement(By.name(name));
        } catch (NoSuchElementException e) {
            log.error("Field with name " + name + " not found");
            return null;
        }
    }

    public WebElement findElementByClass(String className) {
        try {
            return webDriver.findElement(By.className(className));
        } catch (NoSuchElementException e) {
            log.error("Field with class " + className + " not found");
            return null;
        }
    }

    public WebElement findElementByTag(String tagName) {
        try {
            return webDriver.findElement(By.tagName(tagName));
        } catch (NoSuchElementException e) {
            log.error("Field with tag " + tagName + " not found");
            return null;
        }
    }

    public WebElement findElementByXpath(String xpath) {
        try {
            return webDriver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            log.error("Field with xpath " + xpath + " not found");
            return null;
        }
    }

}
