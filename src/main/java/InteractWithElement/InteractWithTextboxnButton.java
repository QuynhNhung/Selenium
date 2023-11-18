package InteractWithElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWithTextboxnButton {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        // Tìm và nhập thông tin vào các trường văn bản
        WebElement nameField = driver.findElement(By.id("userName"));
        nameField.sendKeys("Nhung");

        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("email@example.com");

        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys("Abc");

        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        permanentAddressField.sendKeys("Def");

        // Lấy thông tin đã nhập và kiểm tra xem chúng có chính xác không
        String enteredName = nameField.getAttribute("value");
        String enteredEmail = emailField.getAttribute("value");
        String enteredCurrentAddress = currentAddressField.getAttribute("value");
        String enteredPermanentAddress = permanentAddressField.getAttribute("value");

        // In ra thông tin đã nhập
        System.out.println("Tên: " + enteredName);
        System.out.println("Email: " + enteredEmail);
        System.out.println("Địa chỉ hiện tại: " + enteredCurrentAddress);
        System.out.println("Địa chỉ thường trú: " + enteredPermanentAddress);



    }


}
