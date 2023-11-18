package JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create a WebDriverWait instance with a timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use WebDriverWait and ExpectedConditions to wait for an element to be clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Forms']")));
        element.click();

    }
}
