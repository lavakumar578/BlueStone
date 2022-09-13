package com.tyss.blueStone.testScript;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tyss.blueStone.baseutil.BaseClass;
import com.tyss.blueStone.data.XlsxUtility;
import com.tyss.blueStone.pages.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BlueStoneSecondTask extends BaseClass{
	@Test
	public void blueStoneSecondTask() {
	HomePage homePage=new HomePage(driver);
	StudsPage studsPage=new StudsPage(driver);
	JhumkasPage jhumkasPage=new JhumkasPage(driver);
	ProductPage productPage=new ProductPage(driver);
	CartPage cartPage=new CartPage(driver);
	homePage.handleUpdate();
	homePage.selectearingswithstuds();
	studsPage.validateStudsPage(XlsxUtility.getDataFromExcelSheet("sheet1", 1, 0));
	studsPage.selectFirstStud();
	Set<String> allid=driver.getWindowHandles();
	for(String id:allid) {
	driver.switchTo().window(id);
	}
	productPage.clickBuyNow();
	cartPage.selectHomePage();
	homePage.selectearingswithjhumkas();
	jhumkasPage.validateJhumkasPage(XlsxUtility.getDataFromExcelSheet("sheet1", 2, 0));
	jhumkasPage.selectFirstJhumka();
	Set<String> allids=driver.getWindowHandles();
	for(String id:allids) {
	driver.switchTo().window(id);
	}
	productPage.clickBuyNow();
	cartPage.validatePrice();
	logger.info(XlsxUtility.getDataFromExcelSheet("sheet1", 0, 5));
	}
}
