package actiondriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.igt.listener.LoggingUtils;

import actioninterface.ActionInterface;
import basepack.BaseClass;
import utilities.LoggingUtils;

public class Action extends BaseClass implements ActionInterface {

	int seconds = 10;

	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	@Override
	public void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		log("Successfully clicked on the  element "+ele,true);

	}

	@Override
	public boolean findElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // Check if the element is present by trying to locate it
            ele.getLocation();
            flag = true; // If located, set flag to true
        } catch (NoSuchElementException e) {
            // If the element is not found, catch NoSuchElementException
            flag = false; // Set flag to false
        } finally {
            // Print message based on the flag value
            if (flag) {
                log("Successfully Found element "+ele,true);
            } else {
               log("Unable to locate element "+ele,false);
            }
        }
        return flag; // Return the flag value indicating whether the element was found or not
    }

	@Override
	public boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				log("The element is Displayed "+ele,true);
			} else {
				log("The element is not Displayed "+ele,false);
			}
		} else {
			log("Not displayed ",false);
		}
		return flag;
	}

	@Override
	public boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				log("The element is Selected "+ele,true);
			} else {
				log("The element is not Selected "+ele,false);
			}
		} else {
			log("Not selected ",false);
		}
		return flag;
	}

	@Override
	public boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				log("The element is Enabled "+ele,true);
			} else {
				log("The element is not Enabled "+ele,false);
			}
		} else {
			log("Not Enabled ",false);
		}
		return flag;
	}

	@Override
	public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			log("Location Not found",false);
			flag = false;
		} finally {
			if (flag) {
				log("Successfully entered value "+ele,true);
			} else {
				log("Unable to enter value "+ele,false);
			}

		}
		return flag;
	}

	@Override
	public boolean selectBySendkeys(String value, WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				log("Select value from the DropDown "+ele,true);
			} else {
				log("Not Selected value from the DropDown "+ele,false);
			}
		}
	}

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */
	@Override
	public boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				log("Option selected by Index "+element+"->"+index,true);
			} else {
				log("Option not selected by Index "+element+"->"+index,false);
			}
		}
	}

	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	@Override
	public boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				log("Option selected by Value "+element+"->"+value,true);
			} else {
				log("Option not selected by Value "+element+"->"+value,false);
			}
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	@Override
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				log("Option selected by VisibleText "+ele+"->"+visibletext,true);
			} else {
				log("Option not selected by VisibleText "+ele+"->"+visibletext,false);
			}
		}
	}

	@Override
	public boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				log("MouseOver Action is performed "+ele,true);
			} else {
				log("MouseOver Action is not performed "+ele,false);
			}
		}
	}

	@Override
	public boolean jsClick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				log("Click Action is performed "+ele,true);
			} else {
				log("Click Action is not performed "+ele,false);
			}
		}
		return flag;
	}

	@Override
	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		boolean flag = false;
		try {
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				log("Frame with index \"" + index + "\" is selected",true);
			} else {
				log("Frame with index \"" + index + "\" is not selected",false);
			}
		}
	}

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */
	@Override
	public boolean switchToFrameById(WebDriver driver, String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				log("Frame with Id \"" + idValue + "\" is selected",true);
			} else {
				log("Frame with Id \"" + idValue + "\" is not selected",false);
			}
		}
	}

	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * 
	 */
	@Override
	public boolean switchToFrameByName(WebDriver driver, String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				log("Frame with Name \"" + nameValue + "\" is selected",true);
			} else {
				log("Frame with Name \"" + nameValue + "\" is not selected",false);
			}
		}
	}

	@Override
	public boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}

	@Override
	public void mouseOverElement(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				log(" MouserOver Action is performed on "+element,true);
			} else {
				log("MouseOver action is not performed on "+element,false);
			}
		}
	}

	@Override
	public boolean dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				log("DragAndDrop Action is performed from source ->"+source+" target ->"+target,true);
			} else {
				log("DragAndDrop Action is not performed ->"+source+" target ->"+target,false);
			}
		}
	}

	@Override
	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				log("Slider Action is performed",true);
			} else {
				log("Slider Action is not performed",false);
			}
		}
	}

	@Override
	public boolean rightClick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				log("RightClick Action is performed "+ele,true);
			} else {
				log("RightClick Action is not performed "+ele,false);
			}
		}
	}

	@Override
	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count - 1]);

			if (driver.getTitle().contains(windowTitle)) {
				flag = true;
			} else {
				flag = false;
			}
			
			return flag;
		} catch (Exception e) {
			// flag = true;
			return false;
		} finally {
			if (flag) {
				log("Navigated to the window with title",true);
			} else {
				log("The Window with title is not Selected",false);
			}
		}
	}

	@Override
	public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s = driver.getWindowHandles();
			Object popup[] = s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {

			return flag;
		} finally {
			if (flag) {
				log("Window is Navigated with title",true);
			} else {
				log("The Window with title: is not Selected",false);
			}
		}
	}

	@Override
	public boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s = driver.getWindowHandles();
			Object popup[] = s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {

			return flag;
		} finally {
			if (flag) {
				log("Focus navigated to the window with title",true);
			} else {
				log("The Window with title: is not Selected",false);
			}
		}
	}

	@Override
	public int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}

	@Override
	public int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}

	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * 
	 */
	@Override
	public boolean alert(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (presentFlag) {
				log("The Alert is handled successfully",true);
			} else {
				log("There was no alert to handle",false);
			}
		}

		return presentFlag;
	}

	@Override
	public boolean launchUrl(WebDriver driver, String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				log("Successfully launched \"" + url + "\"",true);
			} else {
				log("Failed to launch \"" + url + "\"",false);
			}
		}
	}

	@Override
	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	@Override
	public String getTitle(WebDriver driver) {
	    String text = null;
	    try {
	        // Attempt to get the title of the page
	        text = driver.getTitle();
	 
	        // Print the title of the page
	       log("Title of the page is: \"" + text + "\"",true);
	 
	    } catch (Exception e) {
	        // Handle the exception more gracefully, log it, or take appropriate action
	       log("An exception occurred while getting the title: " + e.getMessage(),false);
	        // Set a default value or rethrow the exception if needed
	        text = "Title retrieval failed";
	    }
	 
	    return text;
	}

	public String getCurrentURL(WebDriver driver) {
	    String text = null;
	 
	    try {
	        // Attempt to get the current URL
	        text = driver.getCurrentUrl();
	 
	        // Print the current URL
	       log("Current URL is: \"" + text + "\"",true);
	 
	    } catch (WebDriverException e) {
	        // Handle the WebDriverException more gracefully, log it, or take appropriate action
	       log("WebDriverException occurred while getting the current URL: " + e.getMessage(),false);
	        // Set a default value or rethrow the exception if needed
	        text = "URL retrieval failed due to WebDriverException";
	    } catch (Exception e) {
	        // Handle any other exceptions more gracefully, log them, or take appropriate action
	       log("An unexpected exception occurred while getting the current URL: " + e.getMessage(),false);
	        // Set a default value or rethrow the exception if needed
	        text = "URL retrieval failed due to unexpected exception";
	    }
	 
	    return text;
	}

	@Override
	public void fluentWait(WebDriver driver, WebElement element) {
		try {
			Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Duration.ofSeconds(seconds))
					.ignoring(org.openqa.selenium.NoSuchElementException.class)
					.ignoring(org.openqa.selenium.StaleElementReferenceException.class);

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// Log the exception message or take appropriate action
			log("Fluent wait failed: " + e.getMessage(),true);
		}
	}

	@Override
	public void implicitWait(WebDriver driver) {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	@Override
	public void explicitWait(WebDriver driver, WebElement element) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@Override
	public WebElement waitElementTillNotVisible(WebElement ele) {
		WebDriverWait wait = null;
		try {
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
			return wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public void waitElementToBeClickable() {
		WebDriverWait wait = null;

		try {
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("element")));
		} catch (Exception e) {

		}
	}

	public static List<WebElement> waitForElementToBeVisible(List<WebElement> ele, WebDriver driver2,
			Duration seconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElements(ele));
		return element;

	}

	public static void log(String message,boolean status)
	{
		System.out.println(message);
		if(status)
			LoggingUtils.log(message);
		else
			LoggingUtils.logError(message);
	}
}
