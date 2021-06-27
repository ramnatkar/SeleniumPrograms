package com.seleniumBasics;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionAndActionsClass {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement searchBx = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));

	
		actions.keyDown(searchBx, Keys.SHIFT).sendKeys("lenovo").keyUp(Keys.SHIFT);

		Action action = actions.build();// build() is the action class method
		action.perform();

		driver.navigate().to("https://demoqa.com/text-box");
		WebElement fullname = driver.findElement(By.cssSelector("input[id='userName']"));
		WebElement email = driver.findElement(By.cssSelector("input[id='userEmail']"));
		WebElement curadrs = driver.findElement(By.cssSelector("textarea[id='currentAddress']"));
		WebElement peradrs = driver.findElement(By.cssSelector("textarea[id='permanentAddress']"));
		WebElement submit = driver.findElement(By.id("submit"));
		actions.keyDown(fullname, Keys.SHIFT).sendKeys("ram natkar").keyUp(Keys.SHIFT).build().perform();
		actions.sendKeys(email, "ramnatkar@gmail.com").perform();
		actions.sendKeys(curadrs, "Anandgaon Tq Majalagoan Dist Beed-431131").keyDown(Keys.CONTROL).sendKeys("a")
				.sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		actions.sendKeys(Keys.TAB).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		actions.sendKeys(Keys.TAB).click(submit).build().perform();
		
		
		//clicks by mouse
		
		driver.navigate().to("https://demoqa.com/buttons");
		WebElement doubleClick=driver.findElement(By.cssSelector("button[id='doubleClickBtn']"));
		WebElement contextClick=driver.findElement(By.cssSelector("button[id='rightClickBtn']"));
		WebElement dynamicClick=driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		actions.doubleClick(doubleClick).perform();
		actions.contextClick(contextClick).perform();
		actions.click(dynamicClick).perform();
		
		//droppable
		
		driver.navigate().to("https://demoqa.com/droppable");
		
		WebElement source1=driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement target1=driver.findElement(By.cssSelector("div[class='simple-drop-container']>div[id='droppable']"));
		actions.dragAndDrop(source1, target1).build().perform();
		
		//Accept
		WebElement accept=driver.findElement(By.xpath("//a[text()='Accept']"));
		accept.click();
		
		WebElement sourceAc1=driver.findElement(By.cssSelector("#acceptable"));
		WebElement sourceAc2=driver.findElement(By.cssSelector("#notAcceptable"));
		WebElement targetAc1=driver.findElement(By.cssSelector(".accept-drop-container>#droppable"));
		actions.dragAndDrop(sourceAc1, targetAc1).build().perform();
		actions.dragAndDrop(sourceAc2, targetAc1).build().perform();
		
		//prevent Propogation
		
		//tool tips
		
		driver.navigate().to("https://demoqa.com/tool-tips");
		
		WebElement textBx=driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
		actions.moveToElement(textBx).build().perform();
		Thread.sleep(1000);
		WebElement tooltip=driver.findElement(By.xpath("//div[@id='textFieldToolTip']//div[@class='tooltip-inner']"));
		
		String tooltiptext=tooltip.getText();
		System.out.println(tooltiptext);
		
		Thread.sleep(3000);
		
		
		WebElement contrary=driver.findElement(By.xpath("//a[@href='javascript:void(0)'][1]"));
		actions.moveToElement(contrary).build().perform();
		Thread.sleep(1000);
		WebElement contraryTooltip=driver.findElement(By.xpath("//div[@id='contraryTexToolTip']//div[@class='tooltip-inner']"));
		String tl=contraryTooltip.getText();
		System.out.println(tl);
		
		
		
		
		
		

	}
}
