
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Luyentap1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rise.fairsketch.com/dashboard/index/1");
        login(driver);
        updateGeneralInfo(driver);
        updateCompanyInfo(driver);
        updateSocialLink(driver);
        updateAccountSetting(driver);
        updateMypreferences(driver);

    }


    private static void login(WebDriver driver) {
        String email = "client@demo.com";
        String password = "riseDemo";

        driver.findElement(By.name("email")).sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE, email);
        driver.findElement(By.name("password")).sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE, password);
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        //Click vào profile
        driver.findElement(By.xpath("//span[@class='user-name ml10']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
    }

    private static void updateGeneralInfo(WebDriver driver) {

        String[] fieldNames = {"first_name", "last_name", "phone", "skype", "job_title"};
        String[] fieldValues = {"ê mi li", "Sờ mít", "0905111222", "11223344", "Nhân diên quèn"};

        for (int i = 0; i < fieldNames.length; i++) {
            String xpath = String.format("//input[@id='%s']", fieldNames[i]);
            WebElement inputField = driver.findElement(By.xpath(xpath));
            inputField.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE, fieldValues[i]);
        }

        driver.findElement(By.cssSelector("input#gender_female")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//button[normalize-space()='Save']"))));
    }

    private static void updateCompanyInfo(WebDriver driver) {
        driver.findElement(By.xpath("//a[normalize-space()='Company']")).click();
        driver.findElement(By.cssSelector("input#type_organization")).click();

        String[] fieldNames = {"company_name", "city", "state", "zip", "country", "website", "vat_number", "gst_number"};
        String[] fieldValues = {"CTS", "không có nhà", "California", "55000000", "VietNam", "//http:Abc.com", "112233", "999999"};
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("Da Nang");

        for (int i = 0; i < fieldNames.length; i++) {
            String xpath = String.format("//input[@id='%s']", fieldNames[i]);
            WebElement inputField = driver.findElement(By.xpath(xpath));
            inputField.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE, fieldValues[i]);
        }
        driver.findElement(By.xpath("//div[@class='card-footer rounded-bottom']//button[@type='submit'][normalize-space()='Save']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        // driver.findElement(By.xpath("//a[normalize-space()='Social Links']")).click();

    }

    private static void updateSocialLink(WebDriver driver)  {
        driver.findElement(By.xpath("//a[normalize-space()='Social Links']")).click();
        String[] fieldNames = {"facebook", "twitter", "linkedin", "whatsapp", "digg", "youtube", "pinterest", "instagram", "github", "tumblr", "vine"};
        String[] fieldValues = {"facebook", "twitter", "Nhung.linkedin", "whatsapp.Nhung", "VietNam", "Abccom", "112233", "999999", "1", "2", "3"};
        //driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("Da Nang");

        for (int i = 0; i < fieldNames.length; i++) {
            String xpath = String.format("//input[@id='%s']", fieldNames[i]);
            WebElement inputField = driver.findElement(By.xpath(xpath));
            inputField.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE, fieldValues[i]);
        }
        driver.findElement(By.xpath("//div[@class='card-footer rounded-0']//button[@type='submit'][normalize-space()='Save']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        driver.findElement(By.xpath("//a[normalize-space()='Account settings']")).click();

    }

    private static void updateAccountSetting(WebDriver driver)  {
        driver.findElement(By.xpath("//a[normalize-space()='Account settings']")).click();
        String[] fieldNames = {"email", "password", "retype_password"};
        String[] fieldValues = {"client@demo.com", "riseDemo", "riseDemo"};
        for (int i = 0; i < fieldNames.length; i++) {
            String xpath = String.format("//input[@id='%s']", fieldNames[i]);
            WebElement inputField = driver.findElement(By.xpath(xpath));
            inputField.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE, fieldValues[i]);
        }

        WebElement saveButton = driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[2]"));
        saveButton.click();
    }
    private static void updateMypreferences(WebDriver driver)  {

        //Click vào preferences
        driver.findElement(By.xpath("//a[@role='presentation'][normalize-space()='My preferences']")).click();

        //Define dropdown và option chung
        String DROPDOWN = "//label[text()='%s']/following::span";
        String OPTION = "//li[@role='presentation' and .='%s']";
        //1.Drop down Notification sound volume
        driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
        driver.findElement(By.xpath("//div[@id='select2-result-label-20']")).click();

        //2.Enable web notification

        //truyền value vào locator cha
        String EnableWebNotification = String.format(DROPDOWN, "Enable web notification");
        driver.findElement(By.xpath(EnableWebNotification)).click();
        //Truyền value vào
        String EnableWebNotification_CON = String.format(OPTION,"No");
        WebElement optionEnableWebNotification = driver.findElement(By.xpath(EnableWebNotification_CON));
        optionEnableWebNotification.click();

        //3.Enable email notification
        //truyền value vào locator cha
        String EnableMailNotification = String.format(DROPDOWN, "Enable email notification");
        driver.findElement(By.xpath(EnableMailNotification)).click();
        //Truyền value No vào
        String EnableMailNotification_Con = String.format(OPTION,"No");
        WebElement optionEnableMailNotification = driver.findElement(By.xpath(EnableMailNotification_Con));
        optionEnableMailNotification.click();

        //4.Language
        String Language = String.format(DROPDOWN, "Language");
        driver.findElement(By.xpath(Language)).click();
        //Truyền value language vào
        String Language_Con = String.format(OPTION,"Spanish");
        WebElement optionLanguage = driver.findElement(By.xpath(Language_Con));
        optionLanguage.click();

        //5.Hide menus from topbar
        String DROPDOWN1 = "//label[text()='%s']/following::div";
        String hideMenu = String.format(DROPDOWN1, "Hide menus from topbar");
        WebElement hideMenuField = driver.findElement(By.xpath(hideMenu));
        hideMenuField.click();
        //option language
        String hideMenuCon = String.format(OPTION,"Language");
        WebElement optionHideMenu = driver.findElement(By.xpath(hideMenuCon));
        optionHideMenu.click();
        //option Dashboard customization
        hideMenuField.click();
        String hideMenuCon1 = String.format(OPTION,"Dashboard customization");
        WebElement optionHideMenu1 = driver.findElement(By.xpath(hideMenuCon1));
        optionHideMenu1.click();


        //6 Disable keyboard
        String disableKeyboard = String.format(DROPDOWN, "Disable keyboard shortcuts");
        WebElement disableKeyboardField = driver.findElement(By.xpath(disableKeyboard));
        disableKeyboardField.click();
        //Truyền value vào
        String disableKeyboard_Con = String.format(OPTION,"No");
        WebElement optiondisableKeyboard = driver.findElement(By.xpath(disableKeyboard_Con));
        optiondisableKeyboard.click();

        //7. Recently meaning
        String RecentlyMeaning = String.format(DROPDOWN, "Recently meaning");
        WebElement RecentlyMeaningField = driver.findElement(By.xpath(RecentlyMeaning));
        RecentlyMeaningField.click();
        //Truyền value vào
        String RecentlyMeaning_Con = String.format(OPTION,"In 7 days");
        WebElement optionRecentlyMeaning = driver.findElement(By.xpath(RecentlyMeaning_Con));
        optionRecentlyMeaning.click();

        //8. Snooze length
        String snoozeLength = String.format(DROPDOWN, "Snooze length");
        WebElement snoozeLengthField = driver.findElement(By.xpath(snoozeLength));
        snoozeLengthField.click();
        //Truyền value vào
        String snoozeLength_Con = String.format(OPTION,"20 Minutes");
        WebElement optionsnoozeLength = driver.findElement(By.xpath(snoozeLength_Con));
        optionsnoozeLength.click();
        //Lưu
        driver.findElement(By.xpath("//form[@id='my-preferences-form']//button[@type='submit'][normalize-space()='Save']")).click();

    }
    }




