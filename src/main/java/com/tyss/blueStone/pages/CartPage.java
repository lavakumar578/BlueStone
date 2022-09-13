package com.tyss.blueStone.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

	/* This locator is used to get the size of the product*/
	@FindBy(xpath = "//span[@class=\"icon-ion-android-arrow-dropdown\"]/following-sibling::span")
	private WebElement sizeTxt;
	/* This locator is used to select bluestone logo*/
	
	@FindBy(xpath = "//img[@onclick='bluestoneLogoClicked()']")
	private WebElement bluestonesImg;
	/* This locator is used to get all the prices of products*/
	@FindBy(xpath = "//div[@class='new-price']/descendant::span[@id and text()]")
	private List<WebElement> getAllPrices;
	/* This locator is used to get the total price to payable*/
	@FindBy(xpath = "//div[@class=\"new-price pull-right\" and text()]")
	private WebElement totalPrice;
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getSize() {
		String size=sizeTxt.getText();
		return size;
	}
	public void selectHomePage() {
		bluestonesImg.click();
	}
	
	public void validatePrice() {
		int sum=0;
			String []array=new String[getAllPrices.size()];
			for(int i=0;i<getAllPrices.size();i++) {
				array[i]=getAllPrices.get(i).getText();
				
			}
			int []array2=new int[getAllPrices.size()];
			for(int j=0;j<array.length;j++) {
				array2[j]=Integer.parseInt(array[j].replace(",", ""));
			}
			for(int i=0;i<array2.length;i++)
			{
				sum=sum+array2[i];
			}
			String sumOfProducts=String.valueOf(sum);
			String tp=totalPrice.getText().replace("Rs. ", "");
			String totalPriceToPay=tp.replace(",", "");
			System.out.println(sumOfProducts+" "+totalPriceToPay);
			Assert.assertEquals(sumOfProducts, totalPriceToPay);
			
			
	}
}
