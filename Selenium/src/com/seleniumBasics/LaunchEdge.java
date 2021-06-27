package com.seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchEdge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "E:\\Selenium\\drivers\\edgedriver\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.google.co.in/");
		
		driver.close();

	}

}
