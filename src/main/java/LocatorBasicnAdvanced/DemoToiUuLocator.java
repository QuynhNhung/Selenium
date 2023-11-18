package LocatorBasicnAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoToiUuLocator {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");

        //define locator chung
        String DYNAMIC_INPUT_NAME = "//input[@id='%s']";
        //handle with first name
        String firstNameXpath = String.format(DYNAMIC_INPUT_NAME,"firstName");
        driver.findElement(By.xpath(firstNameXpath)).sendKeys("Nhung");

        //handle with Last Name

        String lastNameXpath = String.format(DYNAMIC_INPUT_NAME,"lastName");
        driver.findElement(By.xpath(lastNameXpath)).sendKeys("Nguyen");

        //handle with email

        String emailXpath = String.format(DYNAMIC_INPUT_NAME,"userEmail");
        driver.findElement(By.xpath(emailXpath)).sendKeys("Nhung@gmail.com");


        //1.Handle Gender radio button
        Thread.sleep(20);
        String DYNAMIC_INPUT_NAME_VALUE_FORM = "//input[@name='%s' and @value='%s']/following-sibling::label";
        String maleXPath = String.format(DYNAMIC_INPUT_NAME_VALUE_FORM, "gender","Male");
        Boolean isSelected = driver.findElement(By.xpath(maleXPath)).isSelected();
        if (isSelected == false) {
            driver.findElement(By.xpath(maleXPath)).click();
        }
        //2.Handle DatePicker
        WebElement datePicker=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        //Press Ctrl-A
        String s = Keys.chord(Keys.COMMAND, "a");
        datePicker.sendKeys(s);
        //Fill Date
        datePicker.sendKeys("10 Oct 1984");
        //Press Enter to exit DatePicker
        datePicker.sendKeys(Keys.ENTER);

        //3.Handle Subjects dropdown editable
        WebElement dropdown=driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        dropdown.click();
        WebElement dropdown1=driver.findElement(By.id("subjectsInput"));
        dropdown1.sendKeys("Chemistry");
        dropdown1.sendKeys(Keys.ENTER);
        //handle with Picture
        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(System.getProperty("user.dir") + "/src/main/resources/TestDataFile/Timo.jpg");
        //handle with current addres

        // driver.quit();



    }
}