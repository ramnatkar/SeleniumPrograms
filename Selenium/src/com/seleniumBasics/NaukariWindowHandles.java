package com.seleniumBasics;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class NaukariWindowHandles {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.naukri.com/");
		String mainW=driver.getWindowHandle();
		
		Set<String> s=driver.getWindowHandles()	;
		System.out.println(s);
		Iterator<String> itr=s.iterator();
		while(itr.hasNext()) {
			String childW=itr.next();
			if(!mainW.equalsIgnoreCase(childW)) {
				driver.switchTo().window(childW);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		Wait<WebDriver> w=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		driver.switchTo().window(mainW);
		System.out.println(driver.getTitle());
	}
}
