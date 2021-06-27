package com.seleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon3 {
	public static void main(String args[]) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream file=new FileInputStream("C:\\Users\\ram\\eclipse-workspace\\New workplace\\Selenium\\src\\com\\seleniumBasics\\data.properties");
		Properties pro=new Properties();
		pro.load(file);
		driver.get(pro.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(pro.getProperty("implicitTime")), TimeUnit.SECONDS);
		
		WebElement signSection=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions action=new Actions(driver);
		action.moveToElement(signSection).build().perform();
		WebElement signIn=driver.findElement(By.xpath("//div[@id='nav-al-signin']//a[@class='nav-action-button']//span[contains(text(),'Sign in')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signIn);
		WebElement username=driver.findElement(By.xpath("//input[@id='ap_email']"));
		username.sendKeys(pro.getProperty("userName"));
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();
		WebElement passwrd=driver.findElement(By.xpath("//input[@id='ap_password']"));
		passwrd.sendKeys(pro.getProperty("pass"));
		WebElement signIn1=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		signIn1.click();
		
		
	}

}
