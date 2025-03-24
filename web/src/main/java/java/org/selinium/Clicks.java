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

public class Clicks {
WebDriver driver;
WebDriverWait wait;
Actions ction ;
public static void main(String[] args) throws InterruptedException {
	Clicks obj = new Clicks();
	obj.lanch();
	obj.dowbleclicks();
	obj.rightclick();
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
	driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
}
public void close() {
	driver.quit();
}
public void dowbleclicks() throws InterruptedException {
	
	try {
		WebElement  ab1 =wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
		ction.doubleClick(ab1).perform();
		//Alert a =driver.switchTo().alert(); we have to use alert excepted witch to ku pathila athuva alert object return pannum 
		System.out.println("double click performed"); //ethukku appram 10 seconds kalichi  varala so website waste 
		Alert a=wait.until(ExpectedConditions.alertIsPresent()); // website issue
		//Alert a = driver.switchTo().alert();
		Thread.sleep(Duration.ofSeconds(50));
		a.accept();
		System.out.println("alaert accept and the dowble click done");
		
		
	}
	catch (NoAlertPresentException e){
		
		System.out.println(e.getMessage());
		
	}
}
public void rightclick() {
	WebElement ri = wait.until(ExpectedConditions.elementToBeClickable(By.id("rightClickBtn")));
	ction.contextClick(ri).perform();
	System.out.println("double click performed ");
}
}
