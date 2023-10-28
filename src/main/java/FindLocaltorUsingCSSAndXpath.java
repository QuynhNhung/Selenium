import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindLocaltorUsingCSSAndXpath {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.cssSelector("input[id=\"firstName\"]")).sendKeys("QuynhNhung");
        driver.findElement(By.cssSelector("input[id=\"lastName\"]")).sendKeys("Nguyen");
        driver.findElement(By.cssSelector("input[id=\"userEmail\"]")).sendKeys("Nhung@gmail.com");
        driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]")).click();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys("0905111222");
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
        driver.findElement(By.cssSelector("div[aria-label='Choose Thursday, July 18th, 1996']']")).click();
        driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).sendKeys("1996");
        driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")).sendKeys("July");





    }
}
