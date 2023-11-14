package WebDriverAPIAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaiTapKiemThuWindowsActionAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        // Sử dụng WebDriverManager để tự động quản lý phiên bản ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Khởi tạo trình duyệt
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Bước 1: Truy cập https://test.warface.codegym.vn
        driver.get("https://test.warface.codegym.vn");

        // Mở tab mới và chuyển đến trang đăng nhập
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://test.warface.codegym.vn/login");

        // Đăng nhập
        newTab.findElement(By.id("inputEmail")).sendKeys("Nhung@gmail.com");
        newTab.findElement(By.id("inputPassword")).sendKeys("Admin123");
        newTab.findElement(By.cssSelector("button[type='submit']")).click();
        // Quay lại tab đầu tiên và làm mới trang
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        driver.navigate().refresh();

        // Chuyển qua tab thứ hai
        String secondTabHandle = newTab.getWindowHandle();

        // Chuyển lại tab thứ hai
        newTab.switchTo().window(secondTabHandle);

        // Đóng tab thứ hai
        newTab.close();

        // Quay lại tab đầu tiên
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        // Click vào điện thoại và mua hàng
        driver.findElement(By.xpath("(//a[text()='Điện thoại'])[1]")).click();
        driver.findElement(By.xpath("(//a[text()='Mua hàng'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[text()='Mua hàng'])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='btn border']")).click();
        // Đóng trình duyệt
        driver.quit();
    }
}
