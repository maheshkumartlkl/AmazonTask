package ca.amazon.framework.scripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebActions  extends TestBase {
	
	protected static Logger logger  =  Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName() );
	
	/**
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Login Button, SignIn Link
	 *            etc..)
	 * @return --boolean (true or false)
	 * @throws Throwable
	 */
	public static boolean click(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			driver.findElement(locator).click();
			flag = true;
		} catch (Exception e) {

		} finally {
			if (!flag) {
				logger.error("Click,,Unable to clicked on"
						+ locatorName);
				return true;
			} else if (flag) {
				logger.info("Click,,Successfully clicked on"
						+ locatorName);

			}
		}
		return flag;
	}
	
	
	/**
	 * This method Click on element and wait for an element
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param waitElement
	 *            : Element name wish to wait for that (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Login Button, SignIn Link
	 *            etc..)
	 */
	public static boolean clickAndWaitForElementPresent(By locator, By waitElement, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			click(locator, locatorName);
			waitForElementPresent(waitElement, locatorName);
			flag = true;
		} catch (Exception e) {

		} finally {
			if (!flag) {
				logger.error("Click,,Unable to clicked on"
						+ locatorName);
				return true;
			} else if (flag) {
				logger.info("Click,,Successfully clicked on"
						+ locatorName);

			}
		}
		return flag;
	}
	
	
	/**
	 * This method used type value in to text box or text area
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param testdata
	 *            : Value wish to type in text box / text area
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Textbox,Text Area etc..)
	 * 
	 * @throws NoSuchElementException
	 */
	public static boolean type(By locator, String testdata, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(testdata);
			flag = true;

		} catch (Exception e) {

		} finally {
			if (!flag) {
				logger.error("Type ,,Data typing action is not perform on " + locatorName
								+ " with data is " + testdata);
				return true;
			} else if ( flag) {

				logger.info("Type ,,Data typing action is performed on" + locatorName
								+ " with data is " + testdata);

			}
		}
		return flag;
	}

	
	
	/**
	 * Moves the mouse to the middle of the element. The element is scrolled
	 * into view 
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:link,menus etc..)
	 * 
	 */
	public static boolean mouseover(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement mo = driver.findElement(locator);
			new Actions(driver).moveToElement(mo).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				logger.error("MouseOver,,MouseOver action is not perform on" + locatorName);

			} else if ( flag) {

				logger.info("MouseOver,,MouserOver Action is Done on" + locatorName);
			}
		}
	}

	
	/**
	 * Wait for an ElementPresent
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @return Whether or not the element is displayed
	 */
	public static boolean waitForElementPresent(By by, String locator)
			throws Throwable {
		boolean flag = false;
		try {
			for (int i = 0; i < 300; i++) {
				if (driver.findElement(by).isDisplayed()) {
					flag = true;
					return true;

				} else {
					Thread.sleep(100);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				logger.error("WaitForElementPresent,,Falied to locate element " + locator);
			} else if ( flag) {
				logger.info("WaitForElementPresent,,Successfullly located element " + locator);
			}
		}

		return flag;

	}
	
	/**
	 * Clicking on an element using JavaScript commands
	 * @param locator
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public static boolean JSClick(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;
		
		}

		catch (Exception e) {

			
		} finally {
			if (!flag) {
				logger.error("MouseOver ,,MouseOver action is not perform on" + locatorName);
				return flag;
			} else if (flag) {
				logger.info("MouseOver,,MouserOver Action is Done on" + locatorName);
				return flag;
			}
		}
		return flag;
	}
	
	
	/**
	 * select value from DD by using value
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param value
	 *            : Value wish to select from dropdown list.
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Year Dropdown, items
	 *            Listbox etc..)
	 */

	public static boolean selectByValue(By locator, String value,
			String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				logger.error("Select,,Option with value attribute" + value
								+ " is Not Select from the DropDown"
								+ locatorName);

			} else if ( flag) {
				logger.info("Select,,Option with value attribute" + value
								+ " is  Selected from the DropDown"
								+ locatorName);
			}
		}
	}
	
	/**
	 * The innerText of this element.
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:label text, SignIn Link
	 *            etc..)
	 * 
	 * @return: String return text on element
	 * 
	 */

	public static String getText(By locator, String locatorName)
			throws Throwable {
		String text = "";
		boolean flag = false;
		try {
			if (isElementPresent(locator, locatorName)) {
				text = driver.findElement(locator).getText();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				logger.error("GetText,"+ "Unable to get Text from"
						+ locatorName);
			} else if (flag) {
				logger.info("GetText,"+ "Able to get Text from"
						+ locatorName);
			}
		}
		return text;
	}
	
	
	/**
	 * This method returns check existence of element
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Textbox, checkbox etc)
	 * @return: Boolean value(True or False)
	 * @throws NoSuchElementException
	 */
	public static boolean isElementPresent(By by, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			driver.findElement(by);
			flag = true;
			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		} finally {
			if (!flag) {
				logger.error("Check IsElementPresent," +locatorName+" Element is not present on the page");
			} else if (flag) {
				logger.info("IsElementPresent ,"+"Able to locate element" + locatorName);
			}

		}
	}

}
