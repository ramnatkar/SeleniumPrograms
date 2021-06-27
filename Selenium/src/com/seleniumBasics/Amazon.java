package com.seleniumBasics;

import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// explicit wait
		WebDriverWait w = new WebDriverWait(driver, 5);
		driver.get("https://www.amazon.in/");
		// actions class
		Actions a = new Actions(driver);

		WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
		a.moveToElement(move).build().perform();
		WebElement rightclk = driver.findElement(By.xpath("//a[@id='nav-orders']"));
		a.moveToElement(rightclk).contextClick().build().perform();

		WebElement search = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("lenovo laptop").doubleClick().build().perform();

		WebElement mobiles = driver
				.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_mobiles_9292c6cb7b394d30b2467b8f631090a7']"));
		mobiles.click();
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		Set<String> s = driver.getWindowHandles();
		System.out.println(s);
		Iterator<String> itr = s.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);

				driver.findElement(By.xpath("//div[@id='nav-subnav']//a[2]")).click();
				Set<String> s3=driver.getWindowHandles();
				System.out.println(s3);
				Iterator<String> itr2=s3.iterator();
				while(itr2.hasNext()) {
					String grandchildWindow=itr2.next();
					driver.switchTo().window(grandchildWindow);
					Actions action=new Actions(driver);
					WebElement card=driver.findElement(By.xpath("//span[contains(text(),'SIM Cards')]"));
					System.out.println(card);
					Thread.sleep(2000);
					action.moveToElement(card).build().perform();
					driver.close();
				}
				driver.switchTo().window(childWindow);
				driver.close();

			}
		}

		driver.switchTo().window(mainWindow);

	}

}
