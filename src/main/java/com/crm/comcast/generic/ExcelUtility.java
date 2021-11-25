package com.crm.comcast.generic;



import java.io.FileInputStream;
import java.io.IOException;

import javax.crypto.EncryptedPrivateKeyInfo;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{

	


	public String getExcelData(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./Data/ExcelFile2.xlsx");

		String data = WorkbookFactory.create(fis).getSheet(sheet).getRow(1).getCell(0).getStringCellValue();
		return data;

	}

}
