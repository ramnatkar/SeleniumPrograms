package com.seleniumBasics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot1 {
	public static void main(String args[]) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		//driver.get("https://www.demoqa.com/select-menu");
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(source, new File("C:\\Users\\ram\\eclipse-workspace\\New workplace\\Selenium\\src\\abc.jpeg"));
		FileUtils.copyFile(source, new File("C:\\Users\\ram\\eclipse-workspace\\New workplace\\Selenium\\src" +timestamp()+".jpeg"));
	}
	
		
		
		public static String timestamp() {
			String timestamp = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss").format(new Date());
			return timestamp;
			
		}
	
}
