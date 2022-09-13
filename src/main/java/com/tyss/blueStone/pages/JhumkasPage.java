package com.tyss.blueStone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.blueStone.data.XlsxUtility;

public class JhumkasPage {
	/* This locator is used to get the title of the product*/
		@FindBy(xpath = "//h1[contains(@class,'page-title')]")
		private WebElement titleTxt;
		/* This locator is used to select the 1st product*/
		@FindBy(xpath = "//li[@data-position=\"1\"]/descendant::img[@class='hc img-responsive center-block']")
		private WebElement productImg;
		public WebDriverWait wait;
		public JhumkasPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			wait=new WebDriverWait(driver, 50);
		}
		
		public void validateJhumkasPage(String text) {
			 wait.until(ExpectedConditions.visibilityOf(titleTxt));
			 if(titleTxt.getText().contains(text))
			 {
				 System.out.println(titleTxt.getText()+XlsxUtility.getDataFromExcelSheet("sheet1", 1, 3));
			 }
			 else {
				 System.out.println(titleTxt.getText()+XlsxUtility.getDataFromExcelSheet("sheet1", 1, 4));
			 }
		}
		public void selectFirstJhumka() {
			productImg.click();
		}

}
