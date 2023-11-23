package LuyenTap2.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private static WebElement element = null;

    //webdriver loads the page
    public static WebDriver loadPage(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rise.fairsketch.com/signin");
        return driver;
    }

    //Text fields
    public static WebElement txtbx_UserName(WebDriver driver) throws NoSuchElementException {
        return element = driver.findElement(By.xpath("//input[@id='email']"));

    }


    public static WebElement txtbx_Password(WebDriver driver) throws NoSuchElementException {
        return element = driver.findElement(By.xpath("//input[@id='password']"));
    }

    // Buttons
    public static WebElement btn_Login(WebDriver driver) throws NoSuchElementException {
        return element = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));

    }

}
