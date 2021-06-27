package com.seleniumBasics;

import java.io.File;
import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TakesScreenshot2 {
	public static void main(String args[]) throws IOException {
		System.setProperty("webdriver.chrome.driver","E:\\\\Selenium\\\\drivers\\\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.demoqa.com/select-menu");
		driver.manage().window().maximize();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("C:\\Users\\ram\\eclipse-workspace\\New workplace\\Selenium\\src\\S.jpeg"));
	}

}
