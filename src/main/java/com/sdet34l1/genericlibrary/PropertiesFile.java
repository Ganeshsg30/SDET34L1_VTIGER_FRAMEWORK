package com.sdet34l1.genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only property files specific common methods
 * @author Ganesh
 * 
 */
public class PropertiesFile 
{
		static Properties property;
		
		/**
		 * this method is used to open the property file
		 * @throws IOExeception
		 */
		public static void openPropertyFile(String filePath) throws IOException
		{
			FileInputStream fis = new FileInputStream(filePath);
			property = new Properties();
			property.load(fis);
		}
		
		/**
		 * This method is used to get the data from the property file
		 * @param key
		 * @return
		 */
		public static String getDataFromPropertyFile(String key)
		{
			String value = property.getProperty(key);
			return value;
		}
}
