package com.seleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindoHandles {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		WebElement link=driver.findElement(By.xpath("//a[@class='blinkingText']"));
		link.click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itr=windows.iterator();
		String parentW=itr.next();
		String childW=itr.next();
		driver.switchTo().window(childW);
		WebElement text=driver.findElement(By.xpath("//p[@class='im-para red']"));
		String email=text.getText().split("at")[1].trim().split(" ")[0];
		driver.close();
		driver.switchTo().window(parentW);
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys(email);
		WebElement passwrd=driver.findElement(By.xpath("//input[@id='password']"));
		passwrd.sendKeys("Password@123");
		
		
		WebElement radio=driver.findElement(By.xpath("//label[@class='customradio']//span[text()=' User']"));
		radio.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		//driver.switchTo().alert().accept();
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@class='form-control']"));
		Select option=new Select(dropdown);
		option.selectByIndex(0);
		
		WebElement checkBx=driver.findElement(By.cssSelector("#terms"));
		checkBx.click();
		
		WebElement signIn=driver.findElement(By.xpath("//input[@id='signInBtn']"));
		signIn.click();
		
		
		
		
	}

}
