package com.seleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles1 {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.demoqa.com/browser-windows");
		WebElement newTab=driver.findElement(By.xpath("//button[@id='tabButton']"));
		WebElement newWindow=driver.findElement(By.xpath("//button[@id='windowButton']"));
		WebElement newWindowMsg=driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
		newTab.click();
		newWindow.click();
		newWindowMsg.click();
		String mainW=driver.getWindowHandle();
		Set<String> windoes=driver.getWindowHandles();
		System.out.println(windoes);
		Iterator<String> itr=windoes.iterator();
		
		
		while(itr.hasNext()){
			String s=itr.next();
			System.out.println(s);
			driver.switchTo().window(s);
			//System.out.println(driver.getTitle());
			driver.close();
		}
		
			
			
			
			
			
		
		
	}

}
