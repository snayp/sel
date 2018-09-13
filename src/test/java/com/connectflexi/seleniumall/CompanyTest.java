package com.connectflexi.seleniumall;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

public class CompanyTest extends AbstractUITest {
	//authorization is done in setup method of parent class
	@Test
	public void testCompanySearch() throws Exception {
		
		getUrl("resources/admin/company/index.html");

        waitSec(2);
		Assert.assertNotNull("General field is missing", findElementByName("general"));

		WebElement general = findElementByName("general");
		general.sendKeys("Herma Ltd. (B2B)");
//		general.click();
//		general.sendKeys(Keys.SPACE);
//		Actions a = new Actions(getDriver());
//        a.click(general).keyDown(Keys.SHIFT).keyUp(Keys.SHIFT);
		waitSec(5);
		
//		log.info(getDriver().getPageSource());
		Assert.assertNotNull("Search did not run", findElementByClass("company-with-status"));
		Assert.assertEquals("Search did not find the right company", "CMPN145727HE", findElementByClass("company-with-status").getText().trim());
		
	}
}
