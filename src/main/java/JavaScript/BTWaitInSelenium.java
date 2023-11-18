package JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BTWaitInSelenium {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rise.fairsketch.com/events");
        driver.manage().window().maximize();
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        login(driver, webDriverWait);
        driver.quit();
    }

    private static void login(WebDriver driver, WebDriverWait webDriverWait) {
        String email = "admin@demo.com";
        String password = "riseDemo";

        driver.findElement(By.name("email")).sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE, email);
        driver.findElement(By.name("password")).sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE, password);
        // Click nút đăng nhập
        WebElement loginButtonElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Sign in']")));
        loginButtonElement.click();
       // driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

        // Click vào event
        String eventXpath = "//span[text()='Events']";
        WebElement eventEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(eventXpath)));
        eventEle.click();

        // Wait for the title to show
        String eventLogo = "//h1[text()='Event calendar']";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eventLogo)));


    }
}
