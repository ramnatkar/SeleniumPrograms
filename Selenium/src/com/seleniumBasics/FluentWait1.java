package com.seleniumBasics;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWait1 {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		
		String url="https://the-internet.herokuapp.com/dynamic_loading/1";
		driver.get(url);
		WebElement startBtn=driver.findElement(By.cssSelector("div[id='start'] button"));
		startBtn.click();
		//defining the FluentWait class
		Wait<WebDriver> w=new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(30))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);
		
		WebElement hellowrd=driver.findElement(By.cssSelector("div[id='finish'] h4"));
		
		WebElement hello=w.until(new Function<WebDriver,WebElement>(){
			
			
			public WebElement apply( WebDriver driver) {
				if(hellowrd.isDisplayed()) {
					return hellowrd;
				}
				else {
					return null;
				}
			}
			
			
		});
		System.out.println(hello);
		System.out.println(hellowrd.isDisplayed());
		System.out.println(hellowrd.getText());
	}

}
