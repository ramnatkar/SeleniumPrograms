package com.seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CssSelector {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "E:\\Selenium\\drivers\\edgedriver\\msedgedriver91.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.demoqa.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// cssSelector=tagname#id
		WebElement firstName = driver.findElement(By.cssSelector("input#firstName"));

		firstName.sendKeys("Ram");
		// cssSelector=tagname.class[attribute=value]
		WebElement lastName = driver.findElement(By.cssSelector("input.mr-sm-2.form-control[id='lastName']"));

		lastName.sendKeys("Natkar");

		// cssSelector=.class[attribute='value']
		WebElement email = driver.findElement(By.cssSelector(".mr-sm-2.form-control[placeholder='name@example.com']"));
		email.sendKeys("ramnatkar@gmail.com");

		// xpath traversing
		// radion button
		WebElement genderMale = driver.findElement(By.xpath("//div[@id='genterWrapper']/div[2]/div[1]"));
		genderMale.click();

		// cssSelector=#id

		WebElement userMobNum = driver.findElement(By.cssSelector("#userNumber"));
		userMobNum.sendKeys("9860517084");

		// cssSelector for date=#dateOfBirthInput
		WebElement date = driver.findElement(By.cssSelector("#dateOfBirthInput"));
		date.click();

		// specific=//div[@class='react-datepicker__month-container']/div[2]/div[3]//div[text()='19']
		WebElement specificDate = driver.findElement(
				By.xpath("//div[@class='react-datepicker__month-container']/div[2]/div[3]//div[text()='19']"));

		specificDate.click();

		// css=div[class='subjects-auto-complete__value-container
		// subjects-auto-complete__value-container--is-multi css-1hwfws3']

		WebElement subject = driver.findElement(By.cssSelector("div[class^='subjects-auto-complete__va']"));

		Actions option = new Actions(driver);

		option.click(subject).build().perform();
		option.sendKeys(subject, "eng").build().perform();

		// english=div[class^='css-12jo7m5 subjects-auto-complete__multi-value__label']
		WebElement english = driver.findElement(By.xpath("//div[contains(text(),'English')]"));

		option.click(english).build().perform();

		// check button xpath=//div[@id='hobbiesWrapper']/div/div[1]

		WebElement checkbox = driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div/div[1]"));

		checkbox.click();

		// upload picture css=input#uploadPicture

		WebElement upload = driver.findElement(By.cssSelector("input#uploadPicture"));
		upload.sendKeys("C:\\Users\\ram\\Desktop\\Java programs.txt");

		// css=#currentAddress

		WebElement currAddress = driver.findElement(By.cssSelector("#currentAddress"));
		currAddress.sendKeys("Anandgoan");

		// state=//div[contains(text(),'Select State')]

		WebElement state = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
		state.click();
		// rajasthan=//div[contains(text(),'Rajasthan')]

		WebElement raj = driver.findElement(By.xpath("//div[contains(text(),'Rajasthan')]"));
		raj.click();

		// city=//div[contains(text(),'Select City')]
		WebElement city = driver.findElement(By.xpath("//div[contains(text(),'Select City')]"));
		city.click();

		// jai=//div[contains(text(),'Jaipur')]
		WebElement jaipur = driver.findElement(By.xpath("//div[contains(text(),'Jaipur')]"));
		jaipur.click();

		// submit button=button[id*='ubmi']
		WebElement submitBtn = driver.findElement(By.cssSelector("button[id*='ubmi']"));
		submitBtn.click();

	}

}
