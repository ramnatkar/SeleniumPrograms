package com.seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		WebElement parentframe=driver.findElement(By.xpath("//frameset[@frameborder='1']/frame[@name='frame-top']"));
		driver.switchTo().frame(parentframe);
		//after switching to parent then we have to switch the child frame
		
		WebElement middleframe=driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middleframe);
		WebElement text=driver.findElement(By.xpath("//div[@id='content']"));
		System.out.println(text.getText());
		
		driver.switchTo().defaultContent();
		
	}
}
