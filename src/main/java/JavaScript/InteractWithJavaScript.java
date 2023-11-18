package JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InteractWithJavaScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Init Java Script
        JavascriptExecutor javaScripts = (JavascriptExecutor) driver;

        String DYNAMIC_INPUT_PLACEHOLDER_FORM = "//input[@placeholder='%s']";
        // Send Key Full Name
        String fullNameXPath = String.format(DYNAMIC_INPUT_PLACEHOLDER_FORM, "Full Name");
        WebElement fullNameEle = driver.findElement(By.xpath(fullNameXPath));
        javaScripts.executeScript("arguments[0].value = 'Vincent';", fullNameEle);
        String text = (String) javaScripts.executeScript("return arguments[0].value;", fullNameEle);
        System.out.println("Full Name: " + text);


        // Send Key Full Name
        String emailXPath = String.format(DYNAMIC_INPUT_PLACEHOLDER_FORM, "name@example.com");
        WebElement emailEle = driver.findElement(By.xpath(emailXPath));
        javaScripts.executeScript("arguments[0].value = 'vincent@gmail.com';", emailEle);
        String email = (String) javaScripts.executeScript("return arguments[0].value;", emailEle);
        System.out.println("Email : " + email);


        String DYNAMIC_TEXTAREA_ID_FORM = "//textarea[@id='%s']";
        // Input current address
        String currentXPath = String.format(DYNAMIC_TEXTAREA_ID_FORM, "currentAddress");
        WebElement currentEle = driver.findElement(By.xpath(currentXPath));
        javaScripts.executeScript("arguments[0].value = 'KĐT Nam Trung Yên, P. Yên Hòa, Q. Cầu Giấy, TP Hà Nội';", currentEle);
        String currentAdd = (String) javaScripts.executeScript("return arguments[0].value;", currentEle);
        System.out.println("Current Address : " + currentAdd);

        // Input Permanent address
        String permanentXPath = String.format(DYNAMIC_TEXTAREA_ID_FORM, "permanentAddress");
        WebElement permanentEle = driver.findElement(By.xpath(permanentXPath));
        javaScripts.executeScript("arguments[0].value = 'Q. Cầu Giấy, TP Hà Nội';", permanentEle);
        String permanent = (String) javaScripts.executeScript("return arguments[0].value;", permanentEle);
        System.out.println("Permanent Address : " + permanent);

        // Click to Submit
        String buttonXPath = "//button[@id='submit']";
        WebElement submitEle = driver.findElement(By.xpath(buttonXPath));
        javaScripts.executeScript("arguments[0].click()", submitEle);

        driver.quit();
    }
}
