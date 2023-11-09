package getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InteractWithBasicElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/elements");
        //click vào checkbox
        WebElement checkBoxTab = driver.findElement(By.xpath("//span[.='Check Box']"));
        checkBoxTab.click();
        //click vào button mở rộng
        WebElement expandButton = driver.findElement(By.xpath("//button[@aria-label=\"Expand all\"]"));
        expandButton.click();
        //define locator chung
        // String SELECTBOX = "//span[text()='%s']";
       String[] checkBoxNames = {"Commands", "Angular", "Private", "Excel File.doc"};
        for (int i = 0; i < checkBoxNames.length; i++) {
            String xpath = String.format("//span[text()='%s']", checkBoxNames[i]);
            WebElement checkBoxField = driver.findElement(By.xpath(xpath));
            checkBoxField.click();
        }

        // Tìm button [+] để đóng toàn bộ các check box options và nhấp vào nó
        Thread.sleep(2000);
        expandButton = driver.findElement(By.xpath("//button[@aria-label=\"Collapse all\"]"));
        expandButton.click();

        // Đóng trình duyệt
        driver.quit();


    }


}
