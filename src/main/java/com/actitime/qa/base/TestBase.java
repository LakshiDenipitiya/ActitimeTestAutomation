package com.actitime.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.actitime.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	
		
	public TestBase() {
		
		try {
			properties = new Properties();
			FileInputStream iprop = new FileInputStream(System.getProperty("Users/Lakshi/eclipse-workspace/UCSCActitimeTest/src/main/java/com/actitime/qa/config/config.properties"));
			properties.load(iprop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
		public static void initialization(){
		
String browserName = properties.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/Lakshi/Downloads/chromedriver_win32");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("Firefox")){
			//System.setProperty("webdriver.gecko.driver", "//Users//methuliakithma//Documents//Trainings//UCSC//");	
			driver = new FirefoxDriver(); 
		}
		else if (browserName.equals("IE")){
			
			//code for IE Driver
		}
		
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
		
		}

}
