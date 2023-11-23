package LuyenTap2.testcases;

import LuyenTap2.commons.TestListener;
import LuyenTap2.userActions.PageActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class UserAccessTest {
    private static WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }

    @Test(priority = 0)
    public void testLogin() throws InterruptedException {
        //LoginPage.loadPage(driver);
        //driver.manage().window().maximize();
        PageActions.Login(driver, "admin@demo.com", "riseDemo");
    }


    @Test(priority = 1)
    public void addTask(){
        PageActions.addTaskAction(driver);
        PageActions.addTask(driver,"BDE","123");

    }

    @Test (priority = 2)
    public void detailTask() throws InterruptedException {

        //Select value for Related to field
        PageActions.detailTask(driver, "Related to", "span", "Client");
        Thread.sleep(1000);
        //Select value for Client  field
        PageActions.detailTask(driver, "Client","span", "Zoila Hauck");
        //Select point
        PageActions.detailTask(driver,"Points                        ","span","3 Points");
        //Select status
        PageActions.detailTask(driver, "Status","span",  "To do");
        //Select priority
        PageActions.detailTask(driver, "Priority","span", "Major");
        //Select assign to
        PageActions.detailTask(driver, "Assign to","span",  "John Doe");
        //Select Collaborators
        PageActions.detailTask(driver,"Collaborators","input","John Doe");
        //Select label
        PageActions.detailTask(driver,"Labels","input","Bug");
        //Enter Start date
        PageActions.dealineTask(driver,"Start date","input","20-11-2023");
        //Enter deadline
        PageActions.dealineTask(driver,"Deadline","input","21-11-2023");
        //Save button
        PageActions.saveBtn(driver);

        Thread.sleep(1000);

    }
    @Test(priority = 3)
    public void searchTask(){
        //Search task
        PageActions.searchTask(driver,"BDE");

    }
    @Test(priority = 4)
    public void clickDetailTask() throws InterruptedException {
        //Search task
        PageActions.taskDetail(driver);
    }


    @Test (priority = 5)
    public void postCmt() throws InterruptedException {
        PageActions.postComment1(driver);
        PageActions.postCommentBtn(driver);
        PageActions.postComment2(driver);
        PageActions.postCommentBtn(driver);
        PageActions.changeStatus(driver);
        PageActions.dropdownStatus(driver);
        PageActions.dropdownStatusChange(driver);

    }

    @Test(priority =  6)
    public void changeStatusTask() throws InterruptedException {
        PageActions.changeStatus(driver);
        PageActions.dropdownStatus(driver);
        PageActions.dropdownStatusChange(driver);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}

