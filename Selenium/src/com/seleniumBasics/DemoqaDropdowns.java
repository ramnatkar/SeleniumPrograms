package com.seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoqaDropdowns {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions option=new Actions(driver);
		driver.get("https://www.demoqa.com/select-menu");
		
		//select value .....xpath=//div[@class=' css-1hwfws3']/div[contains(text(),'Select Option')]
		
		WebElement selectValue=driver.findElement(By.xpath("//div[@class=' css-1hwfws3']/div[contains(text(),'Select Option')]"));
		//option.click(selectValue).build().perform();
		selectValue.click();
		WebElement groupOpt=driver.findElement(By.xpath("//div[contains(text(),'Group 2, option 2')]"));
		groupOpt.click();
		//option.moveToElement(groupOpt).click().build().perform();
		//js.executeAsyncScript("arguments[0].click();", groupOpt);
		
		
		WebElement selectTitle=driver.findElement(By.xpath("//div[@class=' css-1hwfws3']/div[contains(text(),'Select Title')]"));
		selectTitle.click();
		driver.findElement(By.xpath("//div[contains(text(),'Mr.')]")).click();
		
		//old style menu
		WebElement oldstyle=driver.findElement(By.cssSelector("select#oldSelectMenu"));
		Select s=new Select(oldstyle);
		s.selectByVisibleText("Magenta");
		//multi select drop down
		WebElement multiSelect=driver.findElement(By.xpath("//div[contains(text(),'Select...')]"));
		WebElement standardSelect=driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-12']/p/b[contains(text(),'Standard multi select')]//parent::p//following-sibling::select[@id='cars']"));
		Select s1=new Select(standardSelect);
		s1.selectByVisibleText("Volvo");
		multiSelect.click();
		WebElement color=driver.findElement(By.xpath("//div[contains(text(),'Blue')]"));
		color.click();
		
		
		System.out.println("Select menu of the demoqa done");
		driver.quit();
		
	}

}
