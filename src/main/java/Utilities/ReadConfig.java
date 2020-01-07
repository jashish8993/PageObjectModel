package Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
Properties pro;
public ReadConfig() 
{
	File src =new File("./config.properties");
	try {
		FileInputStream file=new FileInputStream(src);
		pro=new Properties();
		pro.load(file);
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
}
public String getApplicationUrl()
{
	String url=pro.getProperty("url");
	return url;
	}
public String getUsername()
{
	String username=pro.getProperty("username");
	return username;
	}
public String Password()
{
	String password=pro.getProperty("password");
	return password;
	}
}
