package LocatorBasicnAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindLocatorUsingXpath {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang https://demoqa.com/text-box
        driver.get("https://demoqa.com/automation-practice-form");
        //driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("Nhung");
        driver.findElement(By.id("firstName")).sendKeys("Nhung");


    }
}
