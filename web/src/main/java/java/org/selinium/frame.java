package org.selinium;

import java.time.Duration;

import org.commonutils.comman;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frame {
	WebDriverWait wait;
	WebDriver driver;
public static void main(String[] args) {
	frame obj = new frame();
	obj.launch();
	obj.frame();
	obj.close();
}
public void launch() {
	//WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	driver.manage().window().maximize();
	driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
}
public void frame() {
	WebElement a =driver.findElement(By.xpath("//iframe[@id='frm2']"));
	JavascriptExecutor obj = (JavascriptExecutor)driver;
	
	
	System.out.println("entred");
	obj.executeScript("arguments[0].scrollIntoView()", a);
	driver.switchTo().frame(a);
	
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("prakash");
	System.out.println("finish");
	driver.switchTo().defaultContent();
	
	
}
public void close() {
 	driver.quit();
 }

}
