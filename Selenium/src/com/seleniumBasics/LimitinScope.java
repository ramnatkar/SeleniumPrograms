package com.seleniumBasics;


//import java.util.ArrayList;
import java.util.Iterator;
//import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitinScope {
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.location='https://www.amazon.in/'");
		 int count=driver.findElements(By.tagName("a")).size()	;
		 
		 System.out.println("The number of links on webpage are"+count);
		 //now we will count the number of links in the menu section
		 WebElement header=driver.findElement(By.xpath("//div[@id='nav-main']"));
		 int menuLinks=header.findElements(By.tagName("a")).size();
		 System.out.println("The number of links in the menu section are = "+menuLinks);
		 
		 WebElement footerdriver=driver.findElement(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']"));
		 WebElement firstColdriver=footerdriver.findElement(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']/div[@class='navFooterLinkCol navAccessibility'][1]"));
		 System.out.println("The number of links are = "+firstColdriver.findElements(By.tagName("a")).size());
		 
		 for(int i=0;i<firstColdriver.findElements(By.tagName("a")).size();i++) {
			 String controlclick=Keys.chord(Keys.CONTROL,Keys.ENTER);
			 firstColdriver.findElements(By.tagName("a")).get(i).sendKeys(controlclick);
		 }
		 
		 Set<String> windowes=driver.getWindowHandles();
		// List<String> windowes=(List<String>) driver.getWindowHandles();
		 Iterator<String> itr=windowes.iterator();
		 while(itr.hasNext()) {
			 String window=itr.next();
			 driver.switchTo().window(window);
			 System.out.println(driver.getTitle());
		 }
		 
		 
		 
		 
		 
		
	
		
		
	}
}
