package org.selinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Set;

public class MultipleWin {
    WebDriver driver;
    WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        MultipleWin obj = new MultipleWin();
        obj.launch();
        obj.windows();
        // obj.close(); // Uncomment if you want to close the browser at the end
    }

    public void launch() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get("https://www.automationtestinginsider.com/p/selenium-vi.html");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void close() {
        driver.quit();
    }

    public void windows() throws InterruptedException {
        String parentwindow = driver.getWindowHandle();
        Actions actions = new Actions(driver);

        // Wait for the element to be clickable, then click it
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b/span[text()='Selenium and it’s History']")));
            actions.moveToElement(element).click().perform();
            System.out.println("Clicked on the element");
        } catch (Exception e) {
            System.out.println("Error: Element not clickable or not found.");
            e.printStackTrace();
        }

        // Wait for new windows/tabs to open
        Thread.sleep(5000); // You can adjust this time as needed, or use WebDriverWait

        // Get all the window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Loop through all window handles
        for (String windowHandle : allWindows) {
            // Switch to the new window if it's not the parent window
            if (!parentwindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to child window: " + windowHandle);
                // Perform actions in the child window if needed
                driver.close();
                System.out.println("Closed the child window: " + windowHandle);
            }
        }

        // Switch back to the parent window after closing child windows
        driver.switchTo().window(parentwindow);
        System.out.println("Switched back to the parent window: " + parentwindow);
    }
}
