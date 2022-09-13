package com.tyss.blueStone.data;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is to get the data from Excel file
 * @author LAVA KUMAR
 *
 */
public class XlsxUtility {
	static Workbook book;
	static DataFormatter format;
	/**
	 * This method is used to open the excel
	 * @param filePath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static void openExcel(String filePath) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1=new FileInputStream(filePath);
		book = WorkbookFactory.create(fis1);	
	}
	/**
	 * This method is to get the data from Excel file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String getDataFromExcelSheet(String sheetName,int rowNum,int cellNum)
	{
	String data=format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	return data;
	}
	/**
	 * This method is used to intialize the Dataformatter
	 */
	public static void openDataFormtter()
	{
		format=new DataFormatter();
	}
	/**
	 * This method is used to send the data to excel
	 * @param filepath
	 * @throws IOException
	 */
	public static void setDataToExcel(String filepath) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(filepath);
		book.write(fos);
	}
	/**
	 * This method will set the data to excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param setvalue
	 */
	public static void setDataFromExcelSheet(String sheetName,int rowNum,int cellNum,String setvalue)
	{
	 book.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(setvalue);	 
	}
	/**
	 * This method is used to close the Excel
	 * @throws IOException
	 */
	public static void closeExcel() throws IOException
	{
		book.close();
	}
	/**
	 * This method is used to fetch multipleData from Excel
	 * @param sheetName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static String[][] getMutlipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException 
	{
		Sheet sh = book.getSheet(sheetName);
		String[][] arr=new String[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for(int i=0;i<sh.getLastRowNum();i++)
		
		{
			for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
			{
				arr[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		
		}
		return arr;
	}
	
}