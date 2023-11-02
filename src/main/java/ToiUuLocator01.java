import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ToiUuLocator01 {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/text-box
        driver.get("https://demoqa.com/text-box");
        String NAME_EMAIL = "//input[@placeholder='%s']";
        //handle name fiels
        String nameXpath = String.format(NAME_EMAIL,"Full Name");
        System.out.println("Xpath of name is: "+ nameXpath);
        driver.findElement(By.xpath(nameXpath)).sendKeys("Nhung");
        //handle email field
        String emailXpath = String.format(NAME_EMAIL,"name@example.com");
        System.out.println("Xpath of email is: "+ nameXpath);
        driver.findElement(By.xpath(emailXpath)).sendKeys("nhung@1996gmail.com");

        String ADDRESS_INPUT_VALUE_FORM = "//textarea[@id='%s']";
        //handle current address field
        String currentAddressXpath = String.format(ADDRESS_INPUT_VALUE_FORM,"currentAddress");
        System.out.println("Xpath of current address is: " + currentAddressXpath);
        driver.findElement(By.xpath(currentAddressXpath)).sendKeys("123");
        //handle permanent address field
        String permanentAddressXpath = String.format(ADDRESS_INPUT_VALUE_FORM,"permanentAddress");
        driver.findElement(By.xpath(permanentAddressXpath)).sendKeys("456");
        System.out.println("Xpath của current address is : " + permanentAddressXpath);
        //upload file
        //driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("D:\\Codegym\\Automation\\Course_Selenium_Java\\SeleniumMaven\\src\\test\\resource\\TestDataFile\\Timo.png");


    }
}
