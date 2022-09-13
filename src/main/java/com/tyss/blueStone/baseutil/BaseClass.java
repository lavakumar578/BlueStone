package com.tyss.blueStone.baseutil;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.tyss.blueStone.data.ILocation;
import com.tyss.blueStone.data.PropertiesUtility;
import com.tyss.blueStone.data.XlsxUtility;
import com.tyss.blueStone.pages.*;
import com.tyss.blueStone.util.DriverUtility;
import com.tyss.blueStone.util.JavaLangUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class  is  used to get the common annotations
 * @author LAVA KUMAR

 * created by lavakumar

 */
public class BaseClass {
	public HomePage homePage;
	public WebDriver driver;
	public JavaLangUtility javaLangUtility;
	public long longTimeOut;
	public int randomNum;
	public String username;
	public String password;
	public String url;
	public String browser;
	public String bankerLogin;
	public DriverUtility driverUtility; 
	public static WebDriver staticdriver;
	public Logger logger=LogManager.getLogger(BaseClass.class);
	
	/**
	 * This annotation is used to open Excel and Property file
	 * @throws IOException
	 */
	@BeforeSuite(groups="baseclass")
	public void beforeSuite()
	{
		try {
			PropertiesUtility.openPropertyFile(ILocation.PROPERTYPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Exception happened", e);
			e.printStackTrace();
		
		}
		try {
			XlsxUtility.openExcel(ILocation.EXCELPATH);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			logger.error("Exception happened", e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Exception happened", e);
			e.printStackTrace();
		}
		logger.info( " excel is opened ");
	}
	/**
	 * This annotation is used to close the excel file
	 * @throws IOException

	 * hi this is lavakumar

	 */
	@AfterSuite(groups="baseclass")
	public void afterSuiteTest() 
	{
		try {
			XlsxUtility.setDataToExcel(ILocation.EXCELPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Exception happened", e);
			e.printStackTrace();
		}
		try {
			XlsxUtility.closeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Exception happened", e);
			e.printStackTrace();
		}
		logger.info( " excel closed ");
		try {
			Desktop.getDesktop().browse(new File("src\\main\\java\\com\\tyss\\blueStone\\reports\\extentReport.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This annotation is used to perform loginAction
	 */
	@BeforeMethod(groups="baseclass")
	public void beforeMethodTest()
	{
		
		
	}
	/**
	 * This annotation is used to perform logout
	 */
	@AfterMethod(groups="baseclass")
	public void afterMethodTest()
	{
		
		
	}
	/**
	 * This annotation is used to get common data from propertyfile
	 * create instance for all generic utilities
	 */
	@Parameters("browser")
	@BeforeClass(groups="baseclass")
	public void beforeClassTest(/*String browser*/)
	{
		javaLangUtility=new JavaLangUtility();
		XlsxUtility.openDataFormtter();
		String timeout=PropertiesUtility.getDataFromProperty("timeOut");
		longTimeOut=javaLangUtility.stringToLong(timeout);
		randomNum=javaLangUtility.getRandomNumber(1000);
		url=PropertiesUtility.getDataFromProperty("url");
		browser=PropertiesUtility.getDataFromProperty("browser");
		switch(browser)
		{
		case "chrome":
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			}
		case "edge":
			{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			}
		case "firefox":
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		}
		}
		logger.info( " browser launched ");
		staticdriver=driver;
		homePage=new HomePage(driver);
		driverUtility = new DriverUtility(driver);
		DriverUtility.navigateApp(url, driver);
		driverUtility.browserSetting(driver, longTimeOut);
		driverUtility.intiallizeAction(driver);

	}
	/**
	 *This annotation is used to logout
	 * @throws IOException 
	 */
	@AfterClass(groups="baseclass")
	public void afterClassTest()
	{
		DriverUtility.quitBrowser(driver);
		logger.info( " browser is closed ");
	}
	
	
	
	
}
