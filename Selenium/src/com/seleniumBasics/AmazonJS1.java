package com.seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import com.sun.java.swing.plaf.windows.resources.windows;

public class AmazonJS1 {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Sysntax of the Javascript Interface ,driver is typecasted to this interface;
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//first method of JS which is alternative for driver.get() and driver.navigate().to();
		js.executeScript("window.location='https://www.amazon.in/'");
		
		
		//2)method:this method is for finding the WebElement by using the Id;
		WebElement signInSection=null;
		
		signInSection=(WebElement)js.executeScript("return document.getElementById('nav-link-accountList');");
		
		//Action class to move on that element
		Actions action=new Actions(driver);
		action.moveToElement(signInSection).build().perform();
		
		WebElement signIn=driver.findElement(By.xpath("//div[@id='nav-al-signin']//a[@class='nav-action-button']//span[contains(text(),'Sign in')]"));
		
		//js method 3:to click on the webelement
		
		js.executeScript("arguments[0].click();",signIn);
		
		WebElement username=driver.findElement(By.xpath("//input[@id='ap_email']"));
		//this is the method for sendKeys.
		
		js.executeScript("document.getElementById('ap_email').value='9860517084'");
		//this is the method to change the background or border color ets
		
		js.executeScript("document.getElementById('ap_email').style.backgroundColor='green'");
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		js.executeScript("arguments[0].click();", continueBtn);
		
		WebElement passwrd=driver.findElement(By.xpath("//input[@id='ap_password']"));
		
		js.executeScript("document.getElementById('ap_password').value='deadpool@143'");
		js.executeScript("document.getElementById('ap_password').style.borderColor='red'");
		
		//WebElement signIn1=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		WebElement signIn1=null;
		signIn1=(WebElement)js.executeScript("return document.getElementById('signInSubmit');");
		js.executeScript("arguments[0].click();", signIn1);
		//this is the method to get the attribute of he webelement
		String s=js.executeScript("return document.getElementById('signInSubmit').getAttribute('id');").toString();
		System.out.println(s);
		
		//method to find inner text of the webpage
		String s1=js.executeScript("return document.title").toString();
		System.out.println(s1);
		
		//method to generate the alerts
		
		js.executeScript("alert('Hellow amazon')");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//following methods are for scrolling the webpage
		
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		//or
		WebElement webelement=driver.findElement(By.xpath("//a[text()='Instagram']"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",webelement);
		
		
		//this method is used for the refreshing the browser
		
		js.executeScript("history.go(0);");
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
