import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorSubject {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("abc");
        WebElement dropdown=driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        dropdown.click();
        WebElement dropdown1=driver.findElement(By.id("subjectsInput"));
        dropdown1.sendKeys("Chemistry");
        dropdown1.sendKeys(Keys.ENTER);
        //2.Handle DatePicker
        WebElement datePicker=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        //Press Ctrl-A
        String s = Keys.chord(Keys.COMMAND, "a");
        datePicker.sendKeys(s);
        //Fill Date
        datePicker.sendKeys("10 Oct 1984");
        //Press Enter to exit DatePicker
        datePicker.sendKeys(Keys.ENTER);
    }
}
