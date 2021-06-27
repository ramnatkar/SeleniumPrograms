package com.seleniumBasics;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Calender {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		WebElement click = driver.findElement(By.xpath("//label[@for='toCity']"));
		js.executeScript("arguments[0].click();", click);
		WebElement departureDate = driver.findElement(By.xpath("//label[@for='departure']"));
		departureDate.click();
		WebElement month = driver
				.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[@class='DayPicker-Caption']/div"));
		while (!month.getText().contains("September 2021")) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}

		List<WebElement> list = driver.findElements(By.xpath(
				"//div[@class='DayPicker-Months']/div[2]//div[@class='DayPicker-Body']/div/div[@class='DayPicker-Day']/div[@class='dateInnerCell']/p[1]"));
		int count = list.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String text=list.get(i).getText();
			if(text.equalsIgnoreCase("13")) {
				list.get(i).click();
				break;
			}
			System.out.println("this is that"+text);
		}
			
		
		

	}

}
