package com.tyss.blueStone.testScript;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.blueStone.baseutil.BaseClass;
import com.tyss.blueStone.data.XlsxUtility;
import com.tyss.blueStone.pages.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlueStoneTest extends BaseClass{
	
@Test
public void blueStoneTest() {

	HomePage homePage=new HomePage(driver);
	DiamondRingsPage diamondRingsPage=new DiamondRingsPage(driver);
	ProductPage productPage=new ProductPage(driver);
	CartPage cartPage=new CartPage(driver);
	homePage.handleUpdate();
	homePage.selectRings();
	diamondRingsPage.validateDiamondPage(XlsxUtility.getDataFromExcelSheet("sheet1", 0, 0));
	diamondRingsPage.selectprice();
	
	diamondRingsPage.selectGender();
	
	diamondRingsPage.selectGoldPurity();
	
	diamondRingsPage.getAllPrices();
	
	
	diamondRingsPage.selectOffer();
	Set<String> allid=driver.getWindowHandles();
	for(String id:allid) {
	driver.switchTo().window(id);
	}
	productPage.enterPinCode(XlsxUtility.getDataFromExcelSheet("sheet1", 0, 1));
	productPage.getDeliveryDate();
	productPage.customizeTheOder();
	String grams=productPage.getGrams();
	String carat=productPage.getCarat();
	productPage.clickBuyNow();
	
	String expsize=productPage.getsizeofthering();
	String actSize=cartPage.getSize();	

	Assert.assertEquals(expsize, actSize);
	if(expsize.contains(actSize))
	{
		logger.info(XlsxUtility.getDataFromExcelSheet("sheet1", 0, 2)+expsize+XlsxUtility.getDataFromExcelSheet("sheet1", 0, 3));
	}
	else {
		logger.error(expsize+XlsxUtility.getDataFromExcelSheet("sheet1", 0, 4));
	}
	
	logger.info(XlsxUtility.getDataFromExcelSheet("sheet1", 0, 5));
	
	
}
}