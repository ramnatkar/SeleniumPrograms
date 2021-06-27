package com.seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Exercise {
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkBx=driver.findElement(By.xpath("//fieldset/label/input[@id='checkBoxOption2']"));
		checkBx.click();
		String checkBxText=null;
		driver.findElements(By.xpath("//label/input[@type='checkbox']"));
		for(int i=0;i<driver.findElements(By.xpath("//label/input[@type='checkbox']")).size();i++) {
				if(driver.findElements(By.xpath("//label/input[@type='checkbox']")).get(i).isSelected()) {
					checkBxText=checkBx.getText();
					System.out.println(checkBxText);
				}
			
			
		}
		System.out.println(checkBxText);
		WebElement selectOptions=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select option=new Select(selectOptions);
		for(int i=0;i<option.getOptions().size();i++) {
			if(option.equals(checkBxText)) {
				option.selectByIndex(i);
			}
		}
		Actions a=new Actions(driver);
		WebElement inputBx=driver.findElement(By.xpath("//input[@id='name']"));
		a.moveToElement(inputBx).click().sendKeys(inputBx, checkBxText).build().perform();
		
		WebElement alertBtn=driver.findElement(By.xpath("//input[@id='alertbtn']"));
		alertBtn.click();
		String alertText=driver.switchTo().alert().getText();
		if(alertText.contains(checkBxText)) {
			System.out.println("Test is successful");
		}
		else {
			System.out.println("Test is not successful");
		}
		
	}

}
