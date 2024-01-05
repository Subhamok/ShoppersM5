package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	/**Author : Subham
	 * When we get Element click intercepted exception(when element is hidden by other element)
	 * then we will use java script click
	 * it will take WebDriver object and element ref on which you want to perform javascript click  
	 * @param driver
	 * @param ele
	 */
	public void javascriptClick(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ele);
	}
	
	/**Author : Subham
	 * to avoid ElementClickInterceptedException
	 * @param driver
	 * @param ele
	 * @param data
	 */
	public void javascriptSendKeys(WebDriver driver,WebElement ele,String data)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value=arguments[1];", ele,data);
	}
	
	/**Author : Subham
	 * this method will scroll the webpage till the given element
	 * @param driver
	 * @param ele
	 */
	public void javascriptScrollTillWebElement(WebElement driver,WebElement ele)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	/**Author : Subham
	 * this method will scroll the webpage with given coordinates
	 * @param driver
	 * @param xCordinate
	 * @param yCordinate
	 */
	public void javascriptScrollByCoordinates(WebDriver driver,int xCordinate,int yCordinate)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("scrollBy("+xCordinate+","+yCordinate+");");
	}
	
	/**Author : Subham
	 * this method will highlight the webelement with 2px grey color
	 * @param driver
	 * @param ele
	 */
	public void javascriptHighlightWebElement(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.border='2px solid grey';",ele);
	}
	
	/**
	 * To perform mouse over operation on WebElement
	 * @param driver
	 * @param ele
	 */
	
	public void mouseOverAction(WebDriver driver,WebElement ele)
	{
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
	/**
	 * To perform click operation on WebElement
	 * @param driver
	 * @param ele
	 */
	
	public void doubleClickAction(WebDriver driver,WebElement ele)
	{
		Actions action = new Actions(driver);
		action.doubleClick(ele).perform();
	}
	
	/**
	 * To perform right click on WebElement
	 * @param driver
	 * @param ele
	 */
	
	public void rightClickAction(WebDriver driver,WebElement ele)
	{
		Actions action = new Actions(driver);
		action.contextClick(ele).perform();
	}
	
	/**
	 * To perform drag and drop operations between two WebElements
	 * @param driver
	 * @param draggingElement
	 * @param dropingElement
	 */
	public void dragAndDropAction(WebDriver driver,WebElement draggingElement,WebElement dropingElement)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(draggingElement, dropingElement).perform();
	}
	
	/**
	 * To perform click and hold operations between WebElement
	 * @param driver
	 * @param ele
	 */
	
	public void clickAndHoldAction(WebDriver driver, WebElement ele)
	{
		Actions action = new Actions(driver);
		action.clickAndHold(ele).perform();
	}
	
	/**
	 * To perform scrolling of WebPage till the WebElement
	 * @param driver
	 * @param ele
	 */
	public void scrollToWebElement(WebDriver driver,WebElement ele)
	{
		Actions action=new Actions(driver);
		action.scrollToElement(ele).perform();
	}
	/**
	 * This method will wait until given element reaches to clickable state
	 * @param locator
	 * @param driver
	 * @param ele
	 * @param timeDelay
	 */
	
	public void explicitlyWaitForElementClickable(By locator,WebDriver driver, WebElement ele,int timeDelay)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	/**
	 * This method will wait until given element is visible
	 * @param driver
	 * @param ele
	 * @param timeDelay
	 */
	
	public void explicitlyWaitForElementToBeVisible(WebDriver driver, WebElement ele,int timeDelay)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * This method will wait until alert is present
	 * @param driver
	 * @param ele
	 * @param timeDelay
	 */
	
	public void explicitlyWaitForAlertTobePresent(WebDriver driver, WebElement ele,int timeDelay)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * This method will wait until particular page or particular(given) url will appear
	 * @param driver
	 * @param ele
	 * @param timeDelay
	 * @param Completeurl
	 */
	public void explicitlyWaitForUrlTobePresent(WebDriver driver, WebElement ele,int timeDelay,String Completeurl)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.urlToBe(Completeurl));
	}
	
	/**
	 * This method will wait until particular page is displayed/appeared
	 * @param driver
	 * @param ele
	 * @param timeDelay
	 * @param Completeurl
	 */
	
	public void explicitlyWaitForTitle(WebDriver driver, WebElement ele,int timeDelay,String Completeurl)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.titleIs(Completeurl));
	}
}
