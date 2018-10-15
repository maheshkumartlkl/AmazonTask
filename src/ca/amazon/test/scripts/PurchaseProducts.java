package ca.amazon.test.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAndHoldAction;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import ca.amazon.framework.scripts.Executor;
import ca.amazon.framework.scripts.WebActions;
import ca.amazon.test.pageobjects.DepartmentPageObjects;
import ca.amazon.test.testdata.TestData;

public class PurchaseProducts extends WebActions {

	protected static Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	/**
	 * 
	 * Test scenario: Description Go to http://amazon.ca, Go to Shop by
	 * Department and select Kindle. Click on Kindle Paperwhite and Increase
	 * quantity to 2. Click Add to Cart (do not add any additional items) and
	 * Click proceed to order. Verify that amazon asks for email address or
	 * phone number
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Test
	public static void proceedOrderWithoutEmailOrPwd() throws IOException, InterruptedException {
		String input1 = null;
		String input2 = null;

		try {

			waitForElementPresent(DepartmentPageObjects.department, "Department");

			mouseover(DepartmentPageObjects.department, "Department");

			waitForElementPresent(DepartmentPageObjects.kindle, "kindle");

			mouseover(DepartmentPageObjects.kindle, "kindle");

			waitForElementPresent(DepartmentPageObjects.kindlepaperwhite, "kindlepaperwhite");
			mouseover(DepartmentPageObjects.kindlepaperwhite, "kindlepaperwhite");

			JSClick(DepartmentPageObjects.kindlepaperwhite, "kindlepaperwhite");

			waitForElementPresent(DepartmentPageObjects.quantity, "quantity");

			selectByValue(DepartmentPageObjects.quantity, "2", "quantity");

			waitForElementPresent(DepartmentPageObjects.addToCart, "addToCart");
			click(DepartmentPageObjects.addToCart, "addToCart");

			waitForElementPresent(DepartmentPageObjects.addToOrder, "addToOrder");
			click(DepartmentPageObjects.addToOrder, "addToOrder");

			waitForElementPresent(DepartmentPageObjects.proceedTocheckOut, "proceedTocheckOut");
			click(DepartmentPageObjects.proceedTocheckOut, "proceedTocheckOut");

			waitForElementPresent(DepartmentPageObjects.Continue, "Continue");
			click(DepartmentPageObjects.Continue, "Continue");

			waitForElementPresent(DepartmentPageObjects.errorLocation, "errorLocation");

			String msg = getText(DepartmentPageObjects.errorLocation, "loginError");

			Assert.assertEquals(msg, "Enter your e-mail address or mobile phone number");

			TestData.writeResultsl(4, 4, "Passed");
			logger.info("proceedOrderWithoutEmailOrPwd is Passed");

		} catch (Exception e) {
			logger.error("proceedOrderWithoutEmailOrPwd is Failed");
			TestData.writeResultsl(4, 4, "Failed");
		} catch (Throwable e) {
			logger.error("proceedOrderWithoutEmailOrPwd is Failed");
			TestData.writeResultsl(4, 4, "Failed");
			e.printStackTrace();
		}

	}

}
