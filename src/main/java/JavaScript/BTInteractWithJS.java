package JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BTInteractWithJS {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Khởi tạo JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Chờ để đảm bảo rằng trang đã được tải hoàn toàn
        // waitForPageLoad(driver);

        // Tìm và lưu trữ phần tử "Drag me"
        WebElement dragMeElement = driver.findElement(By.id("draggable"));

        // Tìm và lưu trữ phần tử "Drop here"
        WebElement dropHereElement = driver.findElement(By.id("droppable"));

        // Thực hiện drag and drop sử dụng Actions
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElement, dropHereElement).build().perform();

        // Chờ một lát để xem kết quả
        sleep(2000);
        // Thực hiện alert bằng cách gọi executeScript với method alert()
        jsExecutor.executeScript("alert('This is test alert!');");

        Thread.sleep(3000);

        // Đóng alert bằng cách chấp nhận nó
        driver.switchTo().alert().accept();

    }
}
