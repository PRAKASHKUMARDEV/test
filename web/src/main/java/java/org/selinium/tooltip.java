package org.selinium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tooltip {
	WebDriver driver;
	WebDriverWait wait;
	Actions ction ;
	public static void main(String[] args) {
		tooltip obj = new tooltip();
		obj.lanch();
		obj.tooltip();
		obj.close();
	}
	public void lanch() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking"); // Disables pop-up blocking
		options.addArguments("--disable-extensions");    // Disables extensions, including ad blockers
		options.addArguments("blink-settings=imagesEnabled=false");
		driver = new ChromeDriver(options);
		wait =new WebDriverWait(driver, Duration.ofSeconds(50));
		ction = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/tooltips");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
public void tooltip() {
	WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn3")));
	
	ction.moveToElement(tooltip).perform();
	
	WebElement tooltips  =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn3' and contains(@aria-describedby,'tool')]")));
	
	if(tooltips!=null) {
		System.out.println(tooltips.getText());
	}
	else {
		System.out.println("object not created");
	}
}
	public void close() {
		driver.quit();
	}
	
	

}
