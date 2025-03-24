package org.selinium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker {
	WebDriverWait wait;
	WebDriver driver;
public static void main(String[] args) {
	Datepicker obj = new Datepicker();
	obj.launch();
	obj.datepicker("june","2027","1");
}
public void launch() {
	//WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	driver.manage().window().maximize();
	driver.get("https://demo.automationtesting.in/Datepicker.html");
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
}
public void datepicker (String month,String year,String day) {
	driver.findElement(By.xpath("//img[@class='imgdp']")).click();
	WebElement data;
	String month1 = month ;
	String year1 =year;
	/*
	 * WebElement data=
	 * driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")); // etha
	 * loop ullla kodukanum ellana old value override agathu so dom scale expression
	 */
	
	 String date, dateandyear,day1=day;
	 while (true) {
	    dateandyear= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		// month = driver.findElement(By.xpath("//div/child::span[1][@class='ui-datepicker-month']")).getText();
		// year = driver.findElement(By.xpath("//div/child::span[2][@class='ui-datepicker-year']")).getText();
		 
		 date = month+" "+year;
				 
		
		 if(date.equalsIgnoreCase(dateandyear)) {
			WebElement e= driver.findElement(By.xpath("//tbody/tr/td[string(.)="+day+"]"));
			e.click();
			System.out.println("the month was "+month+"the day was "+e.getText()+"selected");
			 break;
		 }
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[string(.)='Next']"))).click();
		 
	 }
	 
	
}
public void close() {
 	driver.quit();
 }

}
