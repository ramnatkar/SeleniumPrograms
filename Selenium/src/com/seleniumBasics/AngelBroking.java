package com.seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class AngelBroking {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://trade.angelbroking.com/Login");
		
		//userName=  cssSelector(using * middle with)=   input[id*='xtUserI']
		WebElement username=driver.findElement(By.cssSelector("input[id*='xtUserI']"));
		username.sendKeys("R413194");
		
		//passWord=  cssSelector(using $ ending with)=   input[id$='tTradingPassword']
		WebElement password=driver.findElement(By.cssSelector("input[id$='tTradingPassword']"));
		password.sendKeys("shital@143");
		
		//loginBtn= cssSelector(using ^ start with)=    a[id^='loginBt']
		WebElement loginBtn=driver.findElement(By.cssSelector("a[id^='loginBt']"));
		loginBtn.click();
		//markets = cssSelector(parent>child[attribute='value'])
		WebElement markets=driver.findElement(By.cssSelector("li>a[id='mnMarkets']"));
		
		//Actions call is for mouse handling ...syntax Actions ob=new Actions(driver); and methods ob.
		Actions option=new Actions(driver);
		option.moveToElement(markets).build().perform();
		markets.click();
		
		//searchingBox == cssSelector(tagname[attribute='value'])
		WebElement searchBox=driver.findElement(By.cssSelector("input[id='project']"));
		searchBox.sendKeys("TCS");
		
		// add button of TCS bse xpath(with axes following-sibling)==//div[@class='ui-menu-item-wrapper']//span[text()='TCS']//following-sibling::span[text()='BSE']//following-sibling::span
		WebElement addBtn=driver.findElement(By.xpath("//div[@class='ui-menu-item-wrapper']//span[text()='TCS']//following-sibling::span[text()='BSE']//following-sibling::span"));
		option.moveToElement(addBtn).build().perform();
		addBtn.click();
		
		//tcs ltp xpath(with child)===//tr[@class='selected ui-sortable-handle']//child::td[2]/span
		WebElement tcs_LTP=driver.findElement(By.xpath("//td/span[@class='header']//following::td/span[contains(@id,'ltp_532540')]"));
		System.out.println("Rs = "+tcs_LTP.getText());
		
		//tcs bse buy xpath=//tr[@class='selected ui-sortable-handle']/td/span[@class='header']
		WebElement tcs=driver.findElement(By.xpath("//tr[@class='ui-sortable-handle selected' or @id='532540']"));
		tcs.click();
		
		//buy tcs xpath==//a[@id='watchlistBuy']
		WebElement buy=driver.findElement(By.xpath("//a[@id='watchlistBuy']"));
		buy.click();
		
		//day...xpath==//button[@class='btn dropdown-toggle btn-default' and @data-id='ddlBuySellPopValidity']
		WebElement buyType=driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-default' and @data-id='ddlBuySellPopValidity']"));
		buyType.click();
		//select...xpath==//select[@class='form-control selectpicker' and @id='ddlBuySellPopValidity']
		WebElement dayt=driver.findElement(By.xpath("//select[@class='form-control selectpicker' and @id='ddlBuySellPopValidity']"));
		Select option1=new Select(dayt);
		option1.selectByVisibleText("IOC");
		
		//submit 
		WebElement submit=driver.findElement(By.xpath("//button[@id='btnOrderPadSubmit']"));
		submit.click();
		
		
		driver.close();
	}
}
