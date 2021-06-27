package com.seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazoneAllconcepts {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium\\\\drivers\\\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		
		WebElement signInSection=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		//Actions class uses (without Action interface which has the build() method)
		Actions a=new Actions(driver);
		
		a.moveToElement(signInSection).build().perform();
		
		WebElement signIn=driver.findElement(By.xpath("//a[@class='nav-action-button']//span[contains(text(),'Sign in')]"));
		a.click().build().perform();
		
		WebElement emailBx=driver.findElement(By.xpath("//input[@name='email']"));
		emailBx.sendKeys("9860517084");
		
		WebElement continueBtn=driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();
		
		WebElement passwrd=driver.findElement(By.xpath("//input[@id='ap_password']"));
		passwrd.sendKeys("deadpool@143");
		
		WebElement signInBtn=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		signInBtn.click();
		
		
		
		
		
		
		
		
		
		
		//logout
		//a.moveToElement(signInSection).build().perform();
		WebElement singoutSection=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		a.moveToElement(singoutSection).build().perform();
		//driver.findElement(By.xpath("//a[@id='nav-item-signout']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
