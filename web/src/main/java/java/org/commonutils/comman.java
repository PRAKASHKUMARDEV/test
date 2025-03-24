package org.commonutils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class comman {
	
	private static WebDriver driver;
	public static comman obj = null;
	
	private  comman () {
		
	}
	
	public static  comman getinstance() {
		// TODO auto-generated method stub
     if(obj==null) {
    	 obj=new comman();
     }
	return obj;
      
	}
	
	public static WebDriver  getdriver () {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		System.out.println("hi");
		System.out.println("ye");
		return driver;
	}
	
	public void quite() {
		comman.getdriver().quit();
	}
	public void launch() {
		
		comman.getdriver().manage().window().maximize();
		comman.getdriver().get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
		comman.getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		
	}
	public void upload(String filepath) {
		
	}
	
}