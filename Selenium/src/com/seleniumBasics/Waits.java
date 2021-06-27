package com.seleniumBasics;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.function.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// This is implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, 10);
		driver.get("https://www.facebook.com/login.php");

		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='loginbutton']"));

		username.sendKeys("9860517084");
		pass.sendKeys("aryan123");
		loginBtn.click();
		WebElement error = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		// This is explicit WebDriverWait
		WebDriverWait wait1 = new WebDriverWait(driver, 3);
		wait1.until(ExpectedConditions.visibilityOf(error));
		System.out.println(error.getText());
		driver.navigate().back();

		WebElement newsignup = driver.findElement(By.xpath("//div[@id='login_link']//child::a[2]"));
		newsignup.click();

		WebElement firstname = driver
				.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @name='firstname']"));
		// This is fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		WebElement firstname1 = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return firstname;
			}
		});
		firstname1.sendKeys("Ram");

		WebElement lastname = driver
				.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @name='lastname']"));
		lastname.sendKeys("Natkar");

		WebElement mobOrEmail = driver
				.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @name='reg_email__']"));
		mobOrEmail.sendKeys("8208375235");

		WebElement newpass = driver
				.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @name='reg_passwd__']"));
		newpass.sendKeys("Aryan@123");

		WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select elementday = new Select(day);
		elementday.selectByVisibleText("4");

		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));

		Select elementmonth = new Select(month);
		elementmonth.selectByIndex(1);

		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));

		Select elementyear = new Select(year);
		elementyear.selectByVisibleText("1990");

		WebElement radioBtn = driver.findElement(By.xpath("//span[@class='_5k_2 _5dba'][2]/input"));
		radioBtn.click();

		WebElement submitBtn = driver.findElement(By.xpath("//button[@name='websubmit']"));
		Actions action = new Actions(driver);
		action.moveToElement(submitBtn).build().perform();

		// submitBtn.click();
		System.out.println("Please enter the pin");

	}

}
