package WebDriverAPIAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ThucHanhKiemThuVoiAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // Bước 1: Thực hiện truy cập "https://demo.guru99.com/test/delete_customer.php"
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("Vincent");
        driver.findElement(By.name("submit")).click();
        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text1: " + alertText);
        Thread.sleep(2000);
        alert.dismiss();
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
        alert.accept();
        Alert alert2 = driver.switchTo().alert();
        String alertText2 = alert2.getText();
        System.out.println("Alert Text2: " + alertText2);
        driver.quit();
    }
}
