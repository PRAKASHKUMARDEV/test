package org.selinium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Launch{
	public static void main (String[] args) {
		//C:\Users\praka\OneDrive\Desktop\Drivers
		//System.setProperty("webdriver.chrome.driver", "C:/Users/praka/OneDrive/Desktop/Drivers/chromedriver.exe");
		
		   // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.google.com");

        // Print the page title
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
	}
	
	
}

