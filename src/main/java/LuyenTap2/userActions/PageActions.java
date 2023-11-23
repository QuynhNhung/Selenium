package LuyenTap2.userActions;

import LuyenTap2.pageObject.AddTaskPage;
import LuyenTap2.pageObject.LoginPage;
import LuyenTap2.pageObject.SearchTaskPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActions {
    public static void Login(WebDriver driver , String username, String password) throws InterruptedException {
        LoginPage.loadPage(driver);
        // Clear username field
        WebElement usernameField = LoginPage.txtbx_UserName(driver);
        usernameField.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        usernameField.sendKeys(username);

        // Clear password field
        WebElement passwordField = LoginPage.txtbx_Password(driver);
        passwordField.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        passwordField.sendKeys(password);

        // Click Login button
        LoginPage.btn_Login(driver).click();

        // Wait for 5 seconds
        Thread.sleep(5000);
    }

    public static void addTaskAction(WebDriver driver ) {
        WebElement textTask = AddTaskPage.text_Task(driver);

        // Wait for the "Task" element to be clickable for a maximum of 20 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement taskElement = wait.until(ExpectedConditions.elementToBeClickable(textTask));

        // Perform the action (clicking on "Task" element) after waiting
        taskElement.click();

        // Click on the "Add Task" menu
        AddTaskPage.menu_AddTask(driver).click();
    }
    public static void addTask(WebDriver driver, String taskTitle , String taskDescription ){
        AddTaskPage.tile_Task(driver).sendKeys(taskTitle);
        AddTaskPage.description_Task(driver).sendKeys(taskDescription);

    }

    public static void detailTask(WebDriver driver, String label ,String elementType, String optionValue){

        By dropdownLocator = AddTaskPage.generateDropdownTask(label,elementType);
        driver.findElement(dropdownLocator).click();
        By optionLocator = AddTaskPage.generateOptionTask(optionValue);
        driver.findElement(optionLocator).click();

        //AddTaskPage.btnSave(driver).click()
    }
    public static void dealineTask(WebDriver driver, String label1 ,String elementType1, String senkeyValue){

        By dropdownLocator = AddTaskPage.generateDropdownTask(label1,elementType1);
        driver.findElement(dropdownLocator).click();
        driver.findElement(dropdownLocator).sendKeys(senkeyValue);
        //AddTaskPage.btnSave(driver).click()
    }

    public static void saveBtn(WebDriver driver){
        AddTaskPage.saveBtn(driver).click();
    }
    public static void searchTask(WebDriver driver, String searchText){

        //click vào ô search
        SearchTaskPage.searchInput(driver).click();
        // Nhập dữ liệu vào ô tìm kiếm
        SearchTaskPage.searchInput(driver).sendKeys(searchText);
        // Nhấn phím Enter để thực hiện tìm kiếm
        SearchTaskPage.searchInput(driver).sendKeys(Keys.RETURN);
    }

    public static void taskDetail(WebDriver driver) throws InterruptedException {
        //Thread.sleep(1000);
        SearchTaskPage.clickTaskInfor(driver).click();
    }
    public static void postComment1(WebDriver driver) throws InterruptedException {

        SearchTaskPage.postComment(driver).sendKeys("hihi");

    }

    public static void postComment2(WebDriver driver) throws InterruptedException {

        SearchTaskPage.postComment(driver).sendKeys("haha");

    }


    public static void postCommentBtn(WebDriver driver)  {
        SearchTaskPage.postCommentSave(driver).click();

    }
    public static void changeStatus(WebDriver driver){
        SearchTaskPage.changeStatus(driver).click();
    }

    public static void dropdownStatus(WebDriver driver){
        SearchTaskPage.DropdownStatus(driver).click();
    }
    public static void dropdownStatusChange(WebDriver driver){
        SearchTaskPage.selectStatusValue(driver).click();
    }


}


