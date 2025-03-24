package org.selinium;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Boostrap {
	WebDriver driver;
	WebDriverWait Wait;
	
	public static void main(String[] args) {
		Boostrap obj = new Boostrap();
		obj.launch();
		
		/*Scanner in = new Scanner(System.in); 
		 * obj.Boostrapdrop(in.nextLine());
		 * // eppadidam panna kodathu all are pre defined daset pannidanum or excel la
		 * eruntha tharanum no dynamic input data lam testing la thara mudiyahu we can
		 * use excel .
		 */
		obj.Boostrapdrop("contact us");
		obj.close();
		
	}
    public void launch () {
    	driver = new ChromeDriver();
    	Wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	driver.manage().window().maximize();
    	driver.get("https://www.automationtestinginsider.com/2019/12/bootstrap-dropdown-example_12.html");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }
    public void Boostrapdrop(String arg) {
    	WebElement e=Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bootstrapmenu")));
    	// inpect la atha etha click anna than enable aguthu remain code safly we have to use wai
    	e.click();
    	
    	List<WebElement> options = Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='dropdown-menu']/li")));
    	for(WebElement a:options) {
    		String text=a.getText();
    		if(text.equalsIgnoreCase(arg)) {
    			WebElement hh=Wait.until(ExpectedConditions.elementToBeClickable(a));
    			System.out.println("the element has been selected "+a.getText());
    			hh.click(); // click panna vidana next page ku poiduchu but enga ni antha element vachi gettext kodukuran next page la antha 
    			//element erukathu so its throwng org.openqa.selenium.StaleElementReferenceException exception so click panna munnadi kodukalam 
    			//System.out.println("the element has been selected "+a.getText());
    			break;
    		}
    	}
    }
    public void close() {
    	driver.quit();
    }
    	
    }
