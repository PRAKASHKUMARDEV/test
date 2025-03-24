package org.selinium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drag {
WebDriver driver;
WebDriverWait wait ;
public static void main(String[] args) {
	Drag obj = new Drag();
	obj.lanuch();
	obj.DragandDrop();
	obj.close();
}
public void lanuch() {
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/droppable/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
	
}
public void DragandDrop() {
	
	WebElement drag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='draggable']")));
	WebElement drop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='droppable']")));
	Actions action = new Actions(driver);
	
	action.clickAndHold(drag).moveToElement(drop).release().build().perform();
	//div[@id='droppable']/child::p[text()='Dropped!'] i mean ethukku munnadi entha element 
	//div[@id='droppable']/child::p[text()='Dropple'] erunthrukkum but one drage x path will be changed so dom will update so succesfully dropped
	WebElement verify =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='droppable']/child::p[text()='Dropped!']")));
	
	if (verify.getText().equalsIgnoreCase("Dropped!")) {
		System.out.println("succuessfully dropped");
	}
	else {
		System.out.println("drop cancelled");
	}
	
	
	
}
public void close() {
	driver.close();
}
}
