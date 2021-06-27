package com.seleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitinScope2 {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium\\\\drivers\\\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[contains(@class,'_2QfC02')]//button[contains(@class,'_2KpZ6l _2doB4z')]"))
				.click();

		WebElement footerSection1 = driver
				.findElement(By.xpath("//div[@class='_2WErco row']//div[@class='_2Brcj4'][1]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", footerSection1);
		// footerSection1 act as the limited scope driver;
		int links = footerSection1.findElements(By.tagName("a")).size();
		System.out.println(links);
		for (int i = 0; i < links; i++) {
			String controlClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerSection1.findElements(By.tagName("a")).get(i).sendKeys(controlClick);
		}
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!mainWindow.equals(window)) {

				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				driver.close();
			}

		}
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());

	}
}
