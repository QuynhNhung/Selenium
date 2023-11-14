package WebDriverAPIAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class InteractWithWindow {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        // Get the handle of the main window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + mainWindowHandle);
        // Perform actions that open new browser windows on click "New Tab" button
        driver.findElement(By.id("tabButton")).click();
        // Get all current window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("Get All Window " + allWindowHandles);
        // Switch to the new window (after clicking the button)
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Perform actions on the new window, if needed
        System.out.println("Title of the new window: " + driver.getTitle());
        Boolean isTextDisplay=driver.findElement(By.xpath("//h1[text()=\"This is a sample page\"]")).isDisplayed();
        System.out.println("This is a sample page text displays? "+isTextDisplay);
        // Close the new window
        driver.close();
        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);
        // Perform actions on the main window, if needed
        System.out.println("Title of the main window: " + driver.getTitle());
        // Lưu handle của tab đầu tiên
        String firstTabHandle = driver.getWindowHandle();
        // Quay lại tab đầu tiên
        driver.switchTo().window(firstTabHandle);


        // Close the browser
       // driver.quit();

    }
}