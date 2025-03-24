package org.selinium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdown {
	WebDriver driver;
	WebDriverWait wait;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dropdown obj = new dropdown();
		obj.launch();
		obj.Dob("21", "November", "1998");
		obj.close();

	}

	public void launch() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://www.automationtestinginsider.com/2019/08/student-registration-form.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	public  void Dob(String day,String month ,String year) {
		/*
		 * WebElement
		 * Day=wait.until(ExpectedConditions.visibilityOf(By.id("Birthday_Day"))); error cde syntx wrong its accept direct elemet 
		 * WebElement
		 * Month=wait.until(ExpectedConditions.visibilityOf(By.id("Birthday_Month")));
		 * WebElement
		 * Year=wait.until(ExpectedConditions.visibilityOf(By.id("Birthday_Year")));
		 */
		WebElement Day = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Birthday_Day")));
        WebElement Month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Birthday_Month")));
        WebElement Year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Birthday_Year")));
	
	
	Select Dayo =new Select(Day);
	Select Montho =new Select(Month);
	Select yearo =new Select(Year);
	
	Dayo.selectByValue(day);
	Montho.selectByValue(month);
	yearo.selectByValue(year);
	
	System.out.println("your dob has been updated"+Dayo.getFirstSelectedOption().getText()+"'\'"+Montho.getFirstSelectedOption().getText()+"'\'"+yearo.getFirstSelectedOption().getText());
	/*
	 * for(WebElement e:Montho) { System.out.println(e.getText()); } error beause select clause not ietrater child so we cannot extract 
	 * so we have to use getoptions  returns list so list we can ietratble .
	 */
	/*for (int i = 0; i < Montho.; i++) {
		ehukulam array usepanna mudiyathu no length methods we can use for each loop
	}*/
	for(WebElement el:Montho.getOptions())  {
		System.out.println(el.getText());
	}
	}

	public void close() {
		driver.quit();
	}

}
