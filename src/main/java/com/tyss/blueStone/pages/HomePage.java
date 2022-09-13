package com.tyss.blueStone.pages;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//div[@class='modal-buttons']/descendant::span[@class='deny-btn']")
	private WebElement notNowBtn;
	
	@FindBy(xpath = "//a[@title='Rings' and text()='Rings ']")
	private WebElement ringsLink;
	
	@FindBy(xpath = "//a[@title='Earrings' and text()='Earrings ']")
	private WebElement earringsLink;
	
	@FindBy(xpath = "//span[text()='Studs']")
	private WebElement studsLink;
	
	@FindBy(xpath = "//span[text()='Jhumkas']")
	private WebElement jhumkasLink;
	
	@FindBy(xpath="//a[@title='Diamond Rings' and text()='Diamond']")
	private WebElement diamondLink;
	public Actions act;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
	}
	
	public void handleUpdate() {
		notNowBtn.click();
		
	}
	
	public void selectRings() {
		act.moveToElement(ringsLink).perform();
		act.moveToElement(diamondLink).click().build().perform();
	}
	
	public void selectearingswithstuds() {
		act.moveToElement(earringsLink).perform();
		act.moveToElement(studsLink).click().build().perform();
	}
	
	public void selectearingswithjhumkas() {
		act.moveToElement(earringsLink).perform();
		act.moveToElement(jhumkasLink).click().build().perform();
	}
	
}
