package com.seleniumBasics;

import java.util.Iterator;
import java.util.Set;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipKart {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		WebElement username = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		username.sendKeys("9860517084");

		WebElement passwrd = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
		passwrd.sendKeys("deadpool");

		WebElement loginBtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
		loginBtn.click();
		Thread.sleep(3000);

		WebElement searchBx = driver.findElement(By.xpath("//div[@class='_3OO5Xc']/input"));
		Actions action = new Actions(driver);
		action.moveToElement(searchBx).click(searchBx).sendKeys(searchBx, "hp laptops").build().perform();
		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));
		action.click(btn).perform();
		Thread.sleep(3000);

		//WebElement secondItem = driver.findElement(By.xpath(
			//	"//div[@class='_1YokD2 _3Mn1Gg'][2]//div[@class='_1AtVbE col-12-12'][2]//div[@class='_13oc-S']/div/div/a/div[2]/div/div[1][@class='_4rR01T']"));
		WebElement secondItem = driver.findElement(By.xpath("//div[@data-id='COMGFHGFZ7HFZSBA']//following::div[@class='_4rR01T'][2]"));
		secondItem.click();
		//div[@data-id='COMGFHGFZ7HFZSBA']//following::div[@class='_4rR01T'][enter the laptop you want]
		
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!mainWindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				WebElement addtoCart = driver.findElement(By.xpath("//li[@class='col col-6-12']/button"));
				Thread.sleep(3000);
				action.click(addtoCart).perform();
				System.out.println("clicked on the button");
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);

	}

}
