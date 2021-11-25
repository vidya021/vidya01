package com.crm.comcast.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility
{

	public  String getPropertykey(String key) throws IOException 
	{
	   FileInputStream fis =new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\SDET_24\\Data\\CommonData2.property");
	   Properties p=new Properties();
	   p.load(fis);
	   String value=p.getProperty(key);
	   return value;

	}

}
