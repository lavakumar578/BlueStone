package com.tyss.blueStone.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DiamondRingsPage {
	/* This locator is used to get the title of the product*/
	@FindBy(xpath = "//h1[contains(@class,'page-title')]")
	private WebElement titleTxt;
	/* This locator is used to select price filter*/
	@FindBy(xpath = "//span[text()='Price']")
	private WebElement priceLink;
	/* This locator is used to select the price as 10k to 20k*/
	@FindBy(xpath = "//span[@class='prcs-dlh' and text()=' 10,000 - ']")
	private WebElement selectPriceLink;
	/* This locator is used to select gender*/
	@FindBy(xpath = "//span[text()='Gender']")
	private WebElement genderLink;
	/* This locator is used to select women as gender*/
	@FindBy(xpath = "//span[text()=' Women ']")
	private WebElement selectGenderLink;
	/* This locator is used to select the gold purity*/
	@FindBy(xpath = "//span[text()='Gold Purity']")
	private WebElement goldpurityLink;
	/* This locator is used to select the 18k as gold purity*/
	@FindBy(xpath = "//span[text()=' 18k ']")
	private WebElement selectGoldpurityLink;
	/* This locator is used to validate the gold purity as 18k*/
	@FindBy(xpath = "//div[@class=\"filtered-data\"]/descendant::span[@onclick]/span[text()='18k']")
	private WebElement validgoldpurity;
	/* This locator is used to validate the gender as women*/
	@FindBy(xpath = "//div[@class=\"filtered-data\"]/descendant::span[text()]/span[text()='Women']")
	private WebElement validateGender;
	/* This locator is used to validate the price as 10k-20k*/
	@FindBy(xpath = "//div[@class=\"filtered-data\"]/descendant::span[text()]/span[text()=' 10,000 - ']")
	private WebElement validatePrice;
	/* This locator is used to validate the get all filters*/
	@FindBy(xpath = "//div[@class='filtered-data']/descendant::span[@class='filterDisplayName']")
	private List<WebElement> filters;
	/* This locator is used to validate the get all prices of filter with offer 10% off*/
	@FindBy(xpath="//div[@id='grid-view-result']/descendant::span[text()=' 10% off on diamond price ']/ancestor::span[@class='offers-wrapper']/ancestor::div[@class='inner pd-gray-bg']/descendant::span[@class='new-price']/parent::span")
	private   List<WebElement> getallprices;
	/*offer first product image*/
	@FindBy(xpath = "(//div[@id=\"grid-view-result\"]/descendant::span[text()=' 10% off on diamond price ']/ancestor::span[@class=\"offers-wrapper\"]/ancestor::div[@class='inner pd-gray-bg'])[1]")
	private WebElement offerproductImg;
	
	public Actions act;
	public WebDriverWait wait;
	public WebDriver driver;
	public DiamondRingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
		wait=new WebDriverWait(driver, 50);
	}
	
	public void selectprice() {
		act.moveToElement(priceLink).perform();
		String expprice=selectPriceLink.getText().replace(" (126)", "");
		
		act.moveToElement(selectPriceLink).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(validatePrice));
		String price=validatePrice.getText();
	
//		Assert.assertEquals(expprice, price);

	}
	
	public void getAllPrices() {
		wait.until(ExpectedConditions.visibilityOfAllElements(getallprices));
		for(int i=0;i<getallprices.size();i++)
		{
			System.out.println(getallprices.get(i).getText());
		}
	}
	public void selectGender() {
		act.moveToElement(genderLink).perform();
		String expgender=selectGenderLink.getText().replace(" (126)","");
		act.moveToElement(selectGenderLink).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(validateGender));
//		Assert.assertEquals(expgender, validateGender.getText());

		}
	
	public void selectGoldPurity() {
		act.moveToElement(goldpurityLink).perform();
		String expGold=selectGoldpurityLink.getText().replace(" (1274)", "");
		act.moveToElement(selectGoldpurityLink).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(validgoldpurity));
//		Assert.assertEquals(expGold, validgoldpurity.getText());

	}
	public void selectOffer() {
		
		offerproductImg.click();
	}
	 public void validateDiamondPage(String text) {
		 wait.until(ExpectedConditions.visibilityOf(titleTxt));
		 if(titleTxt.getText().contains(text))
		 {
			 System.out.println(titleTxt.getText()+" page is validated");
		 }
		 else {
			 System.out.println(titleTxt.getText()+" page is not validated");
		 }
	 }
	 

}
