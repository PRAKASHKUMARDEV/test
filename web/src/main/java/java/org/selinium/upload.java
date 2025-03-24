package org.selinium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upload {
 public static WebDriver driver;
 public static WebDriverWait wait;
	
 public void launch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
 
 public void close() {
 	driver.quit();
 }
 public void uploadbytext() {
	 Actions obj = new Actions(driver);
	 WebElement el = driver.findElement(By.xpath("//input[@id='fileupload1']"));
	 obj.moveToElement(el);
	 el.sendKeys("C:\\Users\\praka\\OneDrive\\Desktop\\name.txt"); 
 }
 @SuppressWarnings("deprecation")
public static void uploadbyexeautoit() throws IOException, InterruptedException {
	 Actions obj = new Actions(driver);
	 WebElement el = driver.findElement(By.xpath("//input[@id='fileupload1']"));
	 obj.moveToElement(el).click().perform();
	 //Runtime.getRuntime().exec("C:\\Users\\praka\\OneDrive\\Desktop\\selinium notes\\hi.exe"); depricated
	 ProcessBuilder processBuilder = new ProcessBuilder();
     processBuilder.command("C:\\Users\\praka\\OneDrive\\Desktop\\selinium notes\\hi.exe");
     try {
         // Start the process
         Process process = processBuilder.start();
         // Wait for the process to complete
         process.waitFor();
     } catch (InterruptedException e) {
         e.printStackTrace();
         System.out.println("file upload");
     }
	
	
 }
 public static void uploadbyrobot() throws AWTException, InterruptedException {
	 
	 Actions obj2 = new Actions(driver);
	 WebElement el = driver.findElement(By.xpath("//input[@id='fileupload1']"));
	 obj2.moveToElement(el).click().perform();
	 StringSelection obj = new StringSelection("C:\\Users\\praka\\OneDrive\\Desktop\\name.txt");
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
	 Robot obj1 = new Robot();
	 obj1.delay(500);
	 obj1.keyPress(KeyEvent.VK_CONTROL);
	 obj1.keyPress(KeyEvent.VK_V);
	 obj1.keyRelease(KeyEvent.VK_CONTROL);
	 obj1.keyRelease(KeyEvent.VK_V);
	 obj1.keyPress(KeyEvent.VK_ENTER);
	 obj1.keyRelease(KeyEvent.VK_ENTER);
	 Thread.sleep(1000);
	 
	 System.out.println("file uploaded");
	 
	 Why .sendKeys() Instead of .click()?
			 File inputs (<input type="file">) do not open the file picker dialog when clicked via Selenium due to security restrictions.
			 Instead, you must directly provide the file path using .sendKeys("absolute_file_path").
	 
	 

	 
 }
 public static void main(String[] args) throws InterruptedException, IOException, AWTException {
	 upload object = new upload();
	 object.launch();
	// object.uploadbytext();
	// uploadbyexeautoit();
	 uploadbyrobot();
	 //Thread.sleep(10000);
	 
	 //object.close();
	
}
}
