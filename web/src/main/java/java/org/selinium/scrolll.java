package org.selinium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scrolll {
	WebDriverWait wait;
	WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	scrolll obj1 = new scrolll();
	obj1.launch();
	obj1.scroll();
	obj1.close();
}
public void launch() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	driver.manage().window().maximize();
	driver.get("https://en.wikipedia.org/wiki/Goat");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
}
public void close() {
 	driver.quit();
 }
public void scroll () throws InterruptedException {
	JavascriptExecutor obj = (JavascriptExecutor) driver;
	//obj.executeScript("window.scrollBy(0,100000)");
	//obj.executeScript("window.scrollTo(0,100000)");
	WebElement e11 = driver.findElement(By.xpath("//h3[@id='Description']"));
	obj.executeScript("arguments[0].scrollIntoView()",e11);
	Thread.sleep(10000);
}
}
