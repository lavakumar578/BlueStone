package com.tyss.blueStone.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class is used to retry the testScript for particular interations
 * @author LAVA KUMAR
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{
	
	int count=0;
	int maxRetry=4;
	@Override
	public boolean retry(ITestResult result)
	{
	if(count<maxRetry)
	{
		count++;
		return true;
	}
		return false;
}
}