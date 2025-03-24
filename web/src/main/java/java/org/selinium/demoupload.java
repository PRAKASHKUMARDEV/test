package org.selinium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demoupload {

 public static void main(String[] args) throws InterruptedException, AWTException {
  
  WebDriver driver;
  WebDriverWait wait;
  driver = new ChromeDriver();
  wait = new WebDriverWait(driver, Duration.ofSeconds(50));
  driver.manage().window().maximize();
  driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
  Thread.sleep(2000);
  Actions act= new Actions(driver);
  WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("fileupload1")));
  uploadElement.click();
  //act.moveToElement(chooseFile).click().perform();
  Thread.sleep(2000);
  //uploadFile("C:\\Users\\praka\\OneDrive\\Desktop\\name.txt");
  System.out.println("file upload ");
	/*
	 * Why .sendKeys() Instead of .click()? File inputs (<input type="file">) do not
	 * open the file picker dialog when clicked via Selenium due to security
	 * restrictions. Instead, you must directly provide the file path using
	 * .sendKeys("absolute_file_path").
	 */
 }
 
 public static void setClipBoard(String file) {
  StringSelection obj= new StringSelection(file);
  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
 }
 
 public static void uploadFile(String filePath) throws AWTException {
  setClipBoard(filePath);
  Robot rb= new Robot();
  rb.keyPress(KeyEvent.VK_CONTROL);
  rb.keyPress(KeyEvent.VK_V);
  rb.keyRelease(KeyEvent.VK_CONTROL);
  rb.keyRelease(KeyEvent.VK_V);
  rb.keyPress(KeyEvent.VK_ENTER);
  rb.keyRelease(KeyEvent.VK_ENTER);
 }
}

