package WebDriverAPIAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InteractWithFrame {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Mở trang https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/alertsWindows");
        //Click "Frames" tại thanh menu bar
        // Click "Frames" tại thanh menu bar
        String frameXPath = "//span[text()='Frames']";
        WebElement frameEle = driver.findElement(By.xpath(frameXPath));
        frameEle.click();

        // Thuc hien tim kiem frame va verify
        String frameXPath1 = "//iframe[@id='frame1']";
        String frameID = "frame1";
        WebElement frameElement = driver.findElement(By.id(frameID));

        //region Frame verification
        String expFrameWidth= "500px";
        String actFrameWidth = frameElement.getAttribute("width");
        if(expFrameWidth.equals(actFrameWidth)){
            System.out.println(String.format("The width of frame: %s", actFrameWidth));
        } else {
            System.out.println(String.format("The width of frame is not same: actual: %s, expected: %s", actFrameWidth, expFrameWidth));
        }
//endregion

// Access to this frame
        driver.switchTo().frame(frameElement);
        String sampleHeadingID = "sampleHeading";
        WebElement sampleHeading = driver.findElement(By.id(sampleHeadingID));
        String actHeadingText = sampleHeading.getText();
        System.out.println("Current text: " + actHeadingText);

//region Frame verification
        String expHeadingText = "This is a sample page";
        if(actHeadingText.equals(expHeadingText)){
            System.out.println(String.format("The frame text:  %s", actHeadingText));
        } else {
            System.out.println(String.format("The frame text is not same: actual: %s, expected: %s", actHeadingText, expHeadingText));
        }
//endregion
    }
}
