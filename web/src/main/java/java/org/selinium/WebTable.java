package org.selinium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	WebDriver driver;
	WebDriverWait wait;
public static void main(String[] args) {
	WebTable obj = new WebTable();
	obj.launch();
	obj.webtable("kierra@example.com");
	//obj.close();
			
}
// find a rows and columns 
//tbody/tr//tbody/tr returns list size
//tbody/tr[1]/td returns col size 
//tbody/tr[1]/td[2] mind la ethu i vachi iterate pannum ethu constant ta erukanumnu remain panniko


public void launch() {
	//WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	driver.manage().window().maximize();
	driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
}
public void webtable (String name) {
 String Newwindow =null;
 String parentwindow;
 parentwindow = driver.getWindowHandle();
 List<WebElement> column =driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/thead/tr/th"));
 List<WebElement> Rownumber =driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr"));
 System.out.println(column.size());
 System.out.println(Rownumber.size());
 for (int i = 1; i <=Rownumber.size(); i++) {
String email=driver.findElement(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr["+String.valueOf(i)+"]/child::td[4]")).getText();
System.out.println(email);
	if(email.equalsIgnoreCase(name)) {
	WebElement e=driver.findElement(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr["+String.valueOf(i)+"]/td[7]/child::a[1]"));
	//wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	WebElement e11= driver.findElement(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr[\"+String.valueOf(i)+\"]/td[7]/child::a[1]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();",e11);
	
	Newwindow = driver.getWindowHandle();
	//System.out.println(Newwindow+"   and  "+parentwindow); // appo new tab and window ku than close pann mudyium popup infield box we are not considered
	//as a window.
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstname' and @placeholder='Alden']"))).sendKeys("pk");
	//driver.findElement(By.xpath("//input[@id='firstname' and @placeholder='Alden']")).sendKeys("prakash");
	driver.close();
	Newwindow = driver.getWindowHandle();
	if (!Newwindow.equalsIgnoreCase(parentwindow)) {
	driver.switchTo().window(Newwindow);
	//driver.findElement(By.xpath("//input[@id='firstname' and @placeholder='Alden']")).sendKeys(Keys.ENTER,"prakash");
	System.out.println("hi");
	driver.findElement(By.xpath("//input[@id='firstname' and @placeholder='Alden']")).sendKeys("prakash");
	driver.close();//its work only window its popup 
	//driver.switchTo().window(parentwindow);
	}
	
	System.out.println(parentwindow+"and the "+Newwindow);
}
	}
	
}
public void close() {
 	driver.quit();
 }

// pop up 
public void handlePopUpInfieldBox() {
    // Example: Wait for the pop-up/modal box to be visible
    WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("staticEdit")));  // Change the locator as per your modal's ID or class

    // Interact with fields in the pop-up/modal
    WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstname']"));
    firstNameField.sendKeys("Prakash");

    WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']")); // Adjust according to your page
    submitButton.click();

    // Close the modal dialog
    WebElement closeButton = driver.findElement(By.xpath("//button[@class='close']"));  // Adjust the close button's locator
    closeButton.click();  // This closes the modal
}
public WebTable() {
	
}
}
