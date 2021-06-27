
	
	package com.seleniumBasics;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	public class Exercise2 {
		public static void main(String args[]) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
			WebElement checkBx=driver.findElement(By.xpath("//div[@id='checkbox-example']//label[@for='benz']"));
			driver.findElement(By.xpath("//div[@id='checkbox-example']//label[@for='benz']//input[@id='checkBoxOption2']")).click();
			String checkBxText=checkBx.getText();
			
				
				
			
			System.out.println(checkBxText);
			WebElement selectOptions=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
			Select option=new Select(selectOptions);
			option.selectByVisibleText(checkBxText);
			Actions a=new Actions(driver);
			WebElement inputBx=driver.findElement(By.xpath("//input[@id='name']"));
			a.moveToElement(inputBx).click().sendKeys(inputBx, checkBxText).build().perform();
			Thread.sleep(2000);
			WebElement alertBtn=driver.findElement(By.xpath("//input[@id='alertbtn']"));
			alertBtn.click();
			String alertText=driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			if(alertText.contains(checkBxText)) {
				System.out.println("Test is successful");
			}
			else {
				System.out.println("Test is not successful");
			}
			
		}

	}



