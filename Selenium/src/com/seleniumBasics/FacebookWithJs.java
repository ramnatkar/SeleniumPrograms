package com.seleniumBasics;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FacebookWithJs {
	public static void main(String args[]) {

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/login.php");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement username = null;
		// js method for the finding the element
		username = (WebElement) js.executeScript("return document.getElementById('email');", username);
		username.clear();
		// js method for the sendkeys

		js.executeScript("document.getElementById('email').value='9860517084'");

		// js method for the background color change
		js.executeScript("document.getElementById('email').style.backgroundColor='Red'");
		// username.sendKeys("9860517084");
		WebElement password = null;
		password = (WebElement) js.executeScript("return document.getElementById('pass');", password);
		// password.sendKeys("deadpool");

		js.executeScript("document.getElementById('pass').value='deadpool'");

		// js method for the getAttribute
		String name = (String) js.executeScript("return document.getElementById('pass').getAttribute('class');");
		System.out.println(name);

		WebElement loginBtn = null;
		loginBtn = (WebElement) js.executeScript("return document.getElementById('loginbutton');", loginBtn);
		// js method for the creating the alert
		js.executeScript("alert('hello word');");
		driver.switchTo().alert().accept();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		WebElement loginBtn1 = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.id("loginbutton")).isDisplayed()) {
					return driver.findElement(By.id("loginbutton"));
				}
				return null;
			}
		});
		// js method for the click();
		js.executeScript("arguments[0].click();", loginBtn);
		// loginBtn.click();
		String s=(String)js.executeScript("return document.getElementById('email').innerText;");
		//System.out.println(s);
	}

}
