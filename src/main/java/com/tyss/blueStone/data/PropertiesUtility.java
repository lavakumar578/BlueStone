package com.tyss.blueStone.data;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is to get the data from Property file
 * @author lava kumar
 *
 */
public class PropertiesUtility {
	 static Properties property;
	 /**
	  * this method is to open the Property file
	  * @throws IOException
	  */
	public static void openPropertyFile(String filepath) throws IOException
	{
		FileInputStream fis=new FileInputStream(filepath);
		 property=new Properties();
		property.load(fis);
	}
	/**
	 * This method is to get the data from Property file
	 * @throws Throwable
	 */
	public static String getDataFromProperty(String key) 
	{
		return property.getProperty(key);
	}
}
