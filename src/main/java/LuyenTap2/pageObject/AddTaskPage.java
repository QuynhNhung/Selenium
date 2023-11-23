package LuyenTap2.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTaskPage {
    private static WebElement element = null;

    public static WebElement text_Task(WebDriver driver) throws NoSuchElementException {
        return element = driver.findElement(By.xpath("//span[text()='Tasks']"));

    }

    public static WebElement menu_AddTask(WebDriver driver) throws NoSuchElementException {
        return element = driver.findElement(By.xpath("(//a[@title=\"Add task\"])[2]"));

    }

    //Enter task information
    public static WebElement tile_Task(WebDriver driver) throws NoSuchElementException {
        return element = driver.findElement(By.xpath("//input[@name='title']"));
    }

    public static WebElement description_Task(WebDriver driver) throws NoSuchElementException {
        return element = driver.findElement(By.xpath("//textarea[@name='description']"));
    }

    public static By generateDropdownTask(String label, String elementType) {
        return By.xpath(String.format("(//label[text()='%s']/following::%s)[1]", label, elementType));
    }

    public static By generateOptionTask(String optionValue) {
        return By.xpath(String.format("//li[@role='presentation' and .='%s']", optionValue));
    }

    public static WebElement saveBtn(WebDriver driver) {
        return element = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
    }
}