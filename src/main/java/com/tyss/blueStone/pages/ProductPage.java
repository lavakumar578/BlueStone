package com.tyss.blueStone.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	/* This locator is used send the pincode*/
	@FindBy(id="getNearestStore")
	private WebElement nearstore;
	/* This locator is used check the pincode*/
	@FindBy(xpath="//div[@class='pin-btn fns-btn']")
	private WebElement updatePincode;
	/* This locator is used get the delivery date to pincode*/
	@FindBy(xpath="//div[@class='store-delivery']")
	private WebElement getTheDeliveryDate;
	/* This locator is used to get the size of ring*/
	@FindBy(xpath = "//span[@class='ring-size-box']")
	private WebElement selectRingSize;
	/* This locator is used select customize order*/
	@FindBy(id="customizeOptionForEventLogger")
	private WebElement customizeOrder;
	/* This locator is used select the VVS EF radio button*/
	@FindBy(xpath = "//label[text()=' VVS EF']/input[@type='radio']")
	private WebElement diamondQuality;
	/* This locator is used get the description of product*/
	@FindBy(xpath="//input[@id='ringselect']/following-sibling::span[contains(@class,'size-box-overlay')]")
	private WebElement description;
	/* This locator is used select the size of product*/
	@FindBy(xpath = "//li[@data-key='09']")
	private WebElement selectSize;
	/* This locator is used click on buy now*/
	@FindBy(id="buy-now")
	private WebElement buyNow;
	/* This locator is used get the product name*/
	@FindBy(xpath = "//h1[contains(@class,'title-')]")
	private WebElement productName;
	/* This locator is used get the product price*/
	@FindBy(xpath = "//span[@class=\"final-pd-price\"]")
	private WebElement poductPrice;
	/* This locator is used get the weigth of product*/
	@FindBy(xpath = "//span[@id=\"short_desc_goldWt\"]")
	private WebElement grams;
	/* This locator is used get the carat of product*/
	@FindBy(xpath = "//span[@class='Yellow-purities metal-purities']/descendant::label[text()=' 18Kt']")
	private WebElement carat;
	public JavascriptExecutor jse;
	public Actions act;
	public WebDriverWait wait;
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		jse =(JavascriptExecutor)driver;
		act=new Actions(driver);
		wait=new WebDriverWait(driver, 50);
	}
	
	public void enterPinCode(String pincode) {
		nearstore.clear();
		nearstore.sendKeys(pincode);
		updatePincode.click();
	}
	public void getDeliveryDate() {
		System.out.println(getTheDeliveryDate.getText());
		
	}
	public String customizeTheOder() {
		customizeOrder.click();
		System.out.println("diamondQuality is Enabled "+diamondQuality.isEnabled());
		diamondQuality.click();
		System.out.println("diamondQuality is Selected "+ diamondQuality.isSelected());
		selectRingSize.click();
		selectSize.click();
		String desc=description.getText();
		return desc;
	}
	public void clickBuyNow() {
		jse.executeScript("window.scrollBy(0,20)");
		wait.until(ExpectedConditions.visibilityOf(buyNow));
		act.moveToElement(buyNow).click().perform();
	}
	
	public String getsizeofthering() {
		String getmetaldetails=description.getText();
		return getmetaldetails;
	}
	public String getExpPrice() {
		String getPrice=poductPrice.getText();
		return getPrice;
	}

	public String getGrams() {
		String getgoldgrams=grams.getText();
		return getgoldgrams;
	}
	
	public String getCarat() {
		return carat.getText();
	}
}
