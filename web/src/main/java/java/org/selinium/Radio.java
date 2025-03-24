package org.selinium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Radio {
	public static WebDriver driver;
	public static WebDriverWait wait; // eppavum driver intialize anan praguthan remain ellam aganum so always intlize
										// launch methods ok dont intillize in starting
	// otherwise throwing null pointer exception

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Radio obj = new Radio();

		launch();
		List<WebElement> elements1 = driver.findElements(By.xpath("//input[@name='Hobby' and @type ='checkbox']"));
		WebElement radiobutton = driver.findElement(By.xpath("//input[@name='Gender' and @value ='Male']"));

		obj.select(radiobutton);
		obj.checkbox(elements1, "dancing");
		Thread.sleep(100);
		obj.close();

	}

	public static void launch() throws InterruptedException {

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		driver.manage().window().maximize();
		driver.get("https://www.automationtestinginsider.com/2019/08/student-registration-form.html");
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		// resolve all issue elements to be load ElementClickInterceptedException
		 //Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	}

	public void select(WebElement e) {

		boolean isenable = e.isEnabled();
		if (isenable) {

			WebElement a = wait.until(ExpectedConditions.elementToBeClickable(e));
			a.click();
			System.out.println("the " + String.valueOf(e.getText()) + " has been selected");
		} else {
			System.out.println("the element its not enabled ");
		}
	}

	public void checkbox(List<WebElement> elements, String arg) {

		for (WebElement e : elements) {
			String s = e.getAttribute("value");
			if (s.equalsIgnoreCase(arg)) {
				WebElement a = wait.until(ExpectedConditions.elementToBeClickable(e));
				a.click();
				System.out.println("the " + a.getText() + "box has been seleceted");
				break;
			}
		}

	}

	public void close() {
		System.out.println("closed");
		driver.quit();
	}

}
