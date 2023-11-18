package JavaScript;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static JavaScript.DemoFluentWait.driver;

public class WaitInSelenium {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the logo shown
        String logoXPath = "//img[@src='/images/Toolsqa.jpg']";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoXPath)));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        String formXPath  ="//h5[text()='Forms']";
        WebElement formEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(formXPath)));
        formEle.click();

        String practiceFormXPath ="//span[text()='Practice Form']";
        WebElement practiceEle = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(practiceFormXPath)));
        practiceEle.click();

        driver.quit();

    }
}
