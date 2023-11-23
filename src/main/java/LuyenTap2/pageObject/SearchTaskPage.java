package LuyenTap2.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchTaskPage {
    private static WebElement element ;

    public static WebElement searchInput(WebDriver driver) {
        return element = driver.findElement(By.xpath("//input[@type='search']"));
    }

    public static WebElement clickTaskInfor(WebDriver driver) {
        return element = driver.findElement(By.xpath("(//td//a[contains(@title, 'Task info')])[1]"));
    }


    public static WebElement postComment(WebDriver driver) throws InterruptedException {
        return element = driver.findElement(By.xpath("//textarea[@id=\"comment_description\"]"));

    }
    public static WebElement postCommentSave(WebDriver driver) {
        return element = driver.findElement(By.xpath("//button[text()=\" Post Comment\"]"));

    }

    public static WebElement changeStatus(WebDriver driver) {
        return element = driver.findElement(By.xpath("//a[@data-act-type=\"status_id\"]"));
    }
    public static WebElement DropdownStatus(WebDriver driver) {
        return element = driver.findElement(By.xpath("//span[text()=\"To do\"]"));
    }
    public static WebElement selectStatusValue(WebDriver driver) {
        return element = driver.findElement(By.xpath("//li[@role=\"presentation\" and .=\"In progress\"]"));
    }



}