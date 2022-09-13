package com.tyss.blueStone.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.openqa.selenium.WebElement;

/**
 * This class is used to Convert String value to long datatype
 * @author lava kumar
 *
 */
public class JavaLangUtility {

/**
 * This method to convert String to long datatype
 * @param value
 * @return
 */
	public long stringToLong(String value)
	{
		return Long.parseLong(value);
	}
/**
 * This method is used to get Random numbers
 * @param limit
 * @return
 */
	public int getRandomNumber(int limit)
	{
		Random r=new Random();
		return r.nextInt(limit);
	}
	/**
	 * This method will print the message in console
	 * @param msg
	 */
	public void printStatement(String msg)
	{
		System.out.println(msg);
		
	}
	/**
	 * This method will condition whether it is true or false
	 * @param actualResult
	 * @param expectedResult
	 * @param testCaseName
	 */
	public void assetionThroughIfCondition(String actualResult,String expectedResult,String testCaseName)
	{
		if(actualResult.equals(expectedResult))
		{
			System.out.println(testCaseName+" created successfully ");
			System.out.println("Test case is passed");
			
		}
	}
	/**
	 * This method is used to handle customized wait
	 * @param element
	 * @param pollingTime
	 * @param duration
	 * @throws InterruptedException
	 */
	public void customizeWait(WebElement element,long pollingTime,int duration) throws InterruptedException
	{
		int count=0;
		while(count<=duration)
		{
			try {
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(pollingTime);
				count++;
			}
		}
	}
	/**
	 * This method is used to stop the execution of script for a particular seconds
	 * @throws InterruptedException
	 */
	public void threadsleep() throws InterruptedException
	{
		Thread.sleep(1000);
	}
	/**
	 * This method will return date and time in a format
	 * @return
	 */
	public String dateTimeInFormat() 
	{
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ssss").format(new Date());
	}
	/**
	 * This method is used to provide date & time for Vtiger
	 * @return
	 */
	public String dateTimeInFormatForVtiger() 
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	}
