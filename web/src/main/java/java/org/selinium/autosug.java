package org.selinium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autosug {
	WebDriver driver;
	WebDriverWait wait;
public static void main(String[] args) throws InterruptedException {
	autosug obj = new autosug();
	obj.launch();
	obj.autosuggestions("pradeep");
	obj.close();
	
}
public void launch() {
	
	driver=getFirefoxDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
}
public void autosuggestions(String message) throws InterruptedException {
	WebElement e =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@class='gLFyf']")));
	e.sendKeys(message);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wM6W7d']")));
	//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='wM6W7d']")));
	// Wait for the dropdown to appear
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));// drop down area box o load its single element
    // to make ensure its fullly loaded 
	List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='wM6W7d']"));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));
	//List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='wM6W7d']")));
	 for (WebElement web : list1) {
		String s = web.getText();
		System.out.println("the element tring was "+s);
	}

}
public void close() {
	driver.quit();
}
public  WebDriver getChromeDriver() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver();
}

// Get Firefox WebDriver
public  WebDriver getFirefoxDriver() {
    WebDriverManager.firefoxdriver().setup(); //path set environmental
    return new FirefoxDriver();
}

// Get Edge WebDriver
public  WebDriver getEdgeDriver() {
    WebDriverManager.edgedriver().setup();
    return new EdgeDriver();
}

}
