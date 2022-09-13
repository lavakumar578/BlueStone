package com.tyss.blueStone.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to maintain all the webdriver common actions
 * @author LAVA KUMAR

 */
public class DriverUtility {
	static JavaLangUtility jlu=new JavaLangUtility();
	 WebDriverWait wait;
	static JavascriptExecutor jse;
	static Alert alt;
	static Select s;
	public static Actions act;
	public static WebDriver driver;

	public DriverUtility(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method is used to navigate the app
	 * @param url
	 * @param driver
	 */
	public static void navigateApp(String url,WebDriver driver)
	{
		driver.get(url);
	}
	/**
	 * This method is used to intialize Actions class
	 * @param driver
	 */
	public static   void intiallizeAction(WebDriver driver)
	{
		
		act=new Actions(driver);
	}
	/**
	 * This method is to maximize the application
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is to provide implicitlyWait 
	 * @param driver
	 * @param longTimeOut
	 */
	public  void waitTillPageLoad(WebDriver driver,long longTimeOut)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
	}
	/**
	 * This method is to provide maximize and impliciltyWait
	 * @param driver
	 * @param longTimeOut
	 */
	public void browserSetting(WebDriver driver,long longTimeOut)
	{
		maximizeBrowser(driver);
		waitTillPageLoad(driver, longTimeOut);
	}
	/**
	 * This method is used to handle explicitlyWait
	 * @param driver
	 * @param longTimeOut
	 */
	public  void explicitWait(WebDriver driver,long longTimeOut) 
	{
		wait=new WebDriverWait(driver,longTimeOut);
	}
	/**
	 * This method will return to current window session
	 * @param driver
	 * @param currentid
	 */
		public static void switchToCurrentWindow(WebDriver driver,String currentid)
	{
		driver.switchTo().window(currentid);
	}
	/**
	 * This method is used to handle explicitly with ClickableOfElement
	 * @param by
	 */
	public  void waitUntilElementToBeClickable(WebElement element)
	{	
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to handle explicitly with visibilityOfElement
	 * @param by
	 */
	public  void waitUntilElementVisibilityOf(WebElement elem)
	{	
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	/**
	 * This method is used to handle mouseHover actions
	 * @param driver
	 * @param link
	 * @param driver 
	 */
	public static void mouseHoverOnTheElement(WebElement element)
	{
		
		act.moveToElement(element).click().perform();
	}
	/**
	 * This method is used to handle mouseHover actions by double click
	 * @param link
	 */
	public  void contentClick(WebElement link,WebDriver driver)
	{
		
		act.moveToElement(link).contextClick(link).perform();
	}
	/**
	 * This method is used to switch to window based on title
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver,String partialText)
	{
		Set<String> sessionsIDs=driver.getWindowHandles();
		for(String allId:sessionsIDs)
		{
			driver.switchTo().window(allId);
			if(driver.getTitle().contains(partialText))
			{
				break;	
			}
		}
	}
	/**
	 * This method is used to validate based on Text
	 * @param driver
	 * @param partialText
	 */
	public static void validateBasedOnText(WebDriver driver,String partialText,List<WebElement> elems,String msg)
	{
		for(WebElement elem:elems)
		{
			if(elem.getText().contains(partialText))
			{
				System.out.print(msg);
			}
		}
	}
	/**
	 * This method is to close browser
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	/**
	 * This method is used to intialize drop down list by using index 
	 * @param index
	 */
	public static void selectDropDown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to intialize drop down list by using value 
	 * @param value
	 */
	public static void selectDropDown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to intialize drop down list by using visibletext
	 * @param text
	 */
	public static void selectDropDown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used to switch to frame by using index
	 * @param driver
	 * @param index
	 */
	public static void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame by using nameOrId
	 * @param driver
	 * @param nameOrId
	 */
	public static void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method is used to switch to frame by using element
	 * @param driver
	 * @param element
	 */
	public static void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to switch to home page
	 * @param driver
	 */
	public static void switchBackToHomePage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to click through javascript
	 * @param element
	 */
	public static void clickThroughJavaScript(WebElement element) 
	{
		jse.executeScript("arguments[0].click()",element);
	}
	/**
	 * This method is used to find element by using to find element by using javascript
	 * @param element
	 */
	public static void findElementThroughJavaScript(WebElement element,String value) 
	{
		jse.executeScript("arguments[0].value=arguments[1]",element,value);
	}
	/**
	 * This method is used to scroll by using height
	 * @param height
	 */
	public static void scrollSpecificHeight(String height)
	{
		jse.executeScript("window.scrollBy(0,"+height+")");
	}
	/**
	 * This method is used to scroll to bottom 
	 * @param height
	 */
	public static void scrollToBottom(String height)
	{
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * This method is used to scroll by using element
	 * @param element
	 */
	public static void scrollTillElement(WebElement element)
	{
		jse.executeScript("arguments[0].scrollIntoView()",element);
	}

	/**
	 * This method is used to initialize javaScriptExecutor
	 * @param driver
	 */
	public static void intializeJavaScriptExecutor(WebDriver driver)
	{
		jse=(JavascriptExecutor)driver;
	}
	/**
	 * This method is used to take screenshot
	 * @param string
	 * @param driver2
	 * @return 
	 * @throws IOException 
	 */
	public static String takeScreenShot(String filepath, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File("./screenshot/"+filepath+"_"+jlu.dateTimeInFormat()+".png");
		FileUtils.copyFile(src, des);
		return des.getAbsolutePath();
	}
	/**
	 * This method is used to lauch url by using javascript
	 * @param url
	 */
	public static void navigateThroughApplicationByJavaScript(String url)
	{
		jse.executeScript("window.location=arguments[0]",url);
	}
	/**
	 * This method is used to initialize switch to alert
	 * @param driver
	 */
	public static void initializeSwitchToAlert(WebDriver driver)
	{
		alt=driver.switchTo().alert();
	}
	/**
	 * This method is used to handle alert by acceptting
	 * @param driver
	 */
	public static void handleAlertByAccept(WebDriver driver)
	{
		alt.accept();
	}
	/**
	 * This method is used to handle alert by dismiss
	 */
	public static void handleAlertByDismiss()
	{
		alt.dismiss();
	}
	/**
	 * This method is used to get the  alert msg 
	 */
	public static void handleAlertByGetText()
	{
		alt.getText();
	}
	/**
	 * This method is used to send the msg to alert 
	 * @param value
	 */
	public static void handleAlertBySendKeys(String value)
	{
		alt.sendKeys(value);
	}
	/**
	 * This method is used to initialize select class
	 * @param element
	 */
	public static void initializeselect(WebElement element)
	{
		s=new Select(element);
	}
	/**
	 * This method is used to select by index
	 * @param index
	 */
	public static void selectByDropDown(int index,WebElement element)
	{
		s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select by value
	 * @param value
	 */
	public static void selectByDropDown(String value,WebElement element)
	{
		s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select by visibletext
	 * @param text
	 */
	public static void selectByDropDown(WebElement element,String text)
	{
		s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	
	
	
	

}
