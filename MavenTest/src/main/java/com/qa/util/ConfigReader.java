package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
private Properties	prop;
/**
 * This is used to read the properties file from config.properties
 * @return Properties
 */

public Properties init_prop() {
	prop= new Properties();
	
	try {
		FileInputStream ip= new  FileInputStream("src/test/resources/config/config.properties");
		prop.load(ip);
		System.out.println("Set The Property file");
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	return prop;
}
	
	
	

}
