package org.selinium;

import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mutipluewin {
	WebDriver driver;
	WebDriverWait wait;
public static void main(String[] args) throws InterruptedException {
	mutipluewin  obj = new mutipluewin();
	obj.launch();
	obj.windows();
	//obj.close();
}
public void launch() {
	//WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	driver.manage().window().maximize();
	driver.get("https://www.automationtestinginsider.com/p/selenium-vi.html");
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
}
public void close() {
 	driver.quit();
 }
public void windows() throws InterruptedException {
	
	String parentwindow = driver.getWindowHandle();
	//Actions obj = new Actions(driver);
	WebElement button = driver.findElement(By.xpath
			("//b/span[text()='Selenium and it’s History']"));
	//obj.moveToElement(button).click().build().perform();
	//button.click();//org.openqa.selenium.ElementClickInterceptedException: Element <button id="newTabBtn" class="whButtons"> is not clickable at point (350,724) because another element <div id="aswift_7_host"> obscures it
	//Build info: version: '4.10.0', revision: 'c14d967899' when u use this 
	
	//no error when u use actions no click but no error skipeed 
	
	
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	//overlay ethuna panna we can use this element incerption
	//driver.switchTo().frame("aswift_6_host");
	System.out.println("hi");
	
	//js more powerful its worked 
	
	Set<String> a = driver.getWindowHandles();
	java.util.List<String> windowList= a.stream().toList();
	for (String string : windowList) {
		if(!parentwindow.equals(string)) {
			driver.switchTo().window(string);
			System.out.println("the child widow"+string);
			driver.close();
			System.out.println("the cild closed "+string);
		}
	
		driver.switchTo().window(parentwindow);
	}
	
	
	
}

}
