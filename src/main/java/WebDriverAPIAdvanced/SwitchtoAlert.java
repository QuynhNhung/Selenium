package WebDriverAPIAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;


public class SwitchtoAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Mở trang https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/alerts");
        // Click the "Click me" button to trigger an alert
        WebElement clickMeButton = driver.findElement(By.id("alertButton"));
        clickMeButton.click();
        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        // Get the text of the alert and print it
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        // Perform actions on the alert, e.g., accept or dismiss
        alert.accept(); // Click OK button on the alert

        //click alert after 5 seconds
        WebElement clickAlertButton2 = driver.findElement(By.id("timerAlertButton"));
        clickAlertButton2.click();
        Thread.sleep(10000);
        // Switch to the alert
        Alert alert2 = driver.switchTo().alert();
        // Get the text of the alert and print it
        String alertText2 = alert2.getText();
        System.out.println("Alert Text 2: " + alertText2);
        alert2.accept();

        //On button click, confirm box will appear
        WebElement clickAlertButton3 = driver.findElement(By.id("confirmButton"));
        clickAlertButton3.click();
        // Switch to the alert
        Alert alert3 = driver.switchTo().alert();
        // Get the text of the alert and print it
        String alertText3 = alert3.getText();
        System.out.println("Alert Text 3: " + alertText3);
        Thread.sleep(3000);
        alert3.dismiss();

        //On button click, prompt box will appear
        WebElement promptAlertBox = driver.findElement(By.id("promtButton"));
        promptAlertBox.click();
        // Switch to the alert
        Alert promptAlert = driver.switchTo().alert();
        // Get the text of the alert and print it
        String promptAlertText = promptAlert.getText();
        System.out.println("Prompt Text: " + promptAlertText);
        Thread.sleep(3000);
        // Nhập dữ liệu vào prompt box
        promptAlert.sendKeys("Nhung");
        // Chấp nhận prompt box (bấm OK)
        promptAlert.accept();

        // Close the browser
        //driver.quit();

    }
}
