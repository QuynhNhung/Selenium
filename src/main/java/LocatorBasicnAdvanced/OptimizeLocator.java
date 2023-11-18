package LocatorBasicnAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static java.lang.Thread.sleep;

public class OptimizeLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Login website
        String DYNAMIC_INPUT_VALUE_FORM = "//input[@placeholder='%s']";
        String userNameXpath = String.format(DYNAMIC_INPUT_VALUE_FORM, "Username");
        driver.findElement(By.xpath(userNameXpath)).sendKeys("Admin");
        String userPassword = String.format(DYNAMIC_INPUT_VALUE_FORM, "Password");
        driver.findElement(By.xpath(userPassword)).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();




       //Employee Firstname
        String firstNameXpath = String.format(DYNAMIC_INPUT_VALUE_FORM,"First Name");
        WebElement inputFirstName = driver.findElement(By.xpath(firstNameXpath));
        inputFirstName.click();
        inputFirstName.sendKeys(Keys.COMMAND, "a");
        inputFirstName.sendKeys(Keys.DELETE);
        inputFirstName.sendKeys("Nhung");

        //Employee Middlename
        String middleNameXpath = String.format(DYNAMIC_INPUT_VALUE_FORM,"Middle Name");
        WebElement inputMiddleName = driver.findElement(By.xpath(middleNameXpath));
        inputMiddleName.click();
        inputMiddleName.sendKeys(Keys.COMMAND, "a");
        inputMiddleName.sendKeys(Keys.DELETE);
        inputMiddleName.sendKeys("Thi");

        //Employee Lastname
        String lastNameXpath = String.format(DYNAMIC_INPUT_VALUE_FORM,"Last Name");
        WebElement inputLastName = driver.findElement(By.xpath(lastNameXpath));
        inputLastName.click();
        inputLastName.sendKeys(Keys.COMMAND, "a");
        inputLastName.sendKeys(Keys.DELETE);
        inputLastName.sendKeys("Nguyen");
//
//        //Employee nickname
//        WebElement inputNickName=  driver.findElement(By.xpath("//label[normalize-space()='Nickname']/following::input[@class=\"oxd-input oxd-input--active\"]"));
//        inputNickName.click();
//        inputNickName.sendKeys(Keys.COMMAND, "a");
//        inputNickName.sendKeys(Keys.DELETE);
//        inputNickName.sendKeys("123");

        String DYNAMIC_INPUT ="//label[text()='%s']/following::input[position()=1]";
        String DROPDOWN = "//label[text()='%s']/following::div[position()=1]";


        //handle with Employee ID
        String employeeIdXpath = String.format(DYNAMIC_INPUT,"Employee Id");
        WebElement inputEmployeeID = driver.findElement(By.xpath(employeeIdXpath));
        inputEmployeeID.click();
        inputEmployeeID.sendKeys(Keys.COMMAND, "a");
        inputEmployeeID.sendKeys(Keys.DELETE);
        inputEmployeeID.sendKeys("A123");

        //handle with Other ID
        String OtherIdIdXpath = String.format(DYNAMIC_INPUT,"Other Id");
        WebElement inputOtherId = driver.findElement(By.xpath(OtherIdIdXpath));
        inputOtherId.click();
        inputOtherId.sendKeys(Keys.COMMAND, "a");
        inputOtherId.sendKeys(Keys.DELETE);
        inputOtherId.sendKeys("B123123");

        //handle with Driver's License Number
//        String driverLicenseNumber = String.format(DYNAMIC_INPUT,"Driver's License Number");
//        WebElement inputDriverLicenseNumber = driver.findElement(By.xpath(driverLicenseNumber));
//        inputDriverLicenseNumber.click();
//        inputDriverLicenseNumber.sendKeys(Keys.COMMAND, "a");
//        inputDriverLicenseNumber.sendKeys(Keys.DELETE);
//        inputDriverLicenseNumber.sendKeys("A1");

          //handle with License Expiry Date
         String LicenseExpiryDate = String.format(DYNAMIC_INPUT,"License Expiry Date");
         WebElement inputLicenseExpiryDate = driver.findElement(By.xpath(LicenseExpiryDate));
         inputLicenseExpiryDate.click();
         inputLicenseExpiryDate.sendKeys(Keys.COMMAND, "a");
         inputLicenseExpiryDate.sendKeys(Keys.DELETE);
         inputLicenseExpiryDate.sendKeys("2023-11-02");

         //handle with SSN Number

        String sSNNumber = String.format(DYNAMIC_INPUT,"SSN Number");
        WebElement inputSSNNumber = driver.findElement(By.xpath(sSNNumber));
        inputSSNNumber.click();
        inputSSNNumber.sendKeys(Keys.COMMAND, "a");
        inputSSNNumber.sendKeys(Keys.DELETE);
        inputSSNNumber.sendKeys("11");

        //handle with SIN Number
        String sINNumberr = String.format(DYNAMIC_INPUT,"SIN Number");
        WebElement inputsINNumberr = driver.findElement(By.xpath(sINNumberr));
        inputsINNumberr.click();
        inputsINNumberr.sendKeys(Keys.COMMAND, "a");
        inputsINNumberr.sendKeys(Keys.DELETE);
        inputsINNumberr.sendKeys("22");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");


        //handle with Nationality
        String NationalityXPath = String.format(DROPDOWN, "Nationality");
        System.out.println("XPath of Nationality: " + NationalityXPath);
        //String DROPDOWN = "//label[text()='%s']/following::div[position()=1]";

        // Mở dropdown
        WebElement NationalityField = driver.findElement(By.xpath(NationalityXPath));
        NationalityField.click();

        // Tìm và chọn tùy chọn trong dropdown bằng văn bản
        String OPTION = "//div[@role='option' and .='%s']";

        String optionXPath = String.format(OPTION, "Vietnamese");
        WebElement optionElement = driver.findElement(By.xpath(optionXPath));
        optionElement.click();

        //handle with Date of birth
        String DateOfBirth = String.format(DYNAMIC_INPUT,"Date of Birth");
        WebElement inputDateOfBirth = driver.findElement(By.xpath(DateOfBirth));
        inputDateOfBirth.click();
        inputDateOfBirth.sendKeys(Keys.COMMAND, "a");
        inputDateOfBirth.sendKeys(Keys.DELETE);
        inputDateOfBirth.sendKeys("1996-06-06");

        //handle with gender
        Thread.sleep(20);
        String DYNAMIC_INPUT_NAME_VALUE_FORM = "//input[@type='%s' and @value='%s']/following-sibling::span";
        String maleXPath = String.format(DYNAMIC_INPUT_NAME_VALUE_FORM, "radio","2");
        Boolean isSelected = driver.findElement(By.xpath(maleXPath)).isSelected();
        if (isSelected == false) {
            driver.findElement(By.xpath(maleXPath)).click();
        }
// String OPTION = "//div[@role='option' and .='%s']";
        // Handle with Marital Status
        String MaritalXPath = String.format(DROPDOWN, "Marital Status");
        System.out.println("XPath of Marital Status: " + MaritalXPath);
        WebElement MaritalField = driver.findElement(By.xpath(MaritalXPath));
        MaritalField.click();
        String option1XPath = String.format(OPTION, "Single");
        WebElement option1Element = driver.findElement(By.xpath(option1XPath));
        option1Element.click();

        //handle with Military Service
        String militaryService = String.format(DYNAMIC_INPUT,"Military Service");
        WebElement  inputMilitaryService = driver.findElement(By.xpath(militaryService));
        inputMilitaryService.click();
        inputMilitaryService.sendKeys(Keys.COMMAND, "a");
        inputMilitaryService.sendKeys(Keys.DELETE);
        inputMilitaryService.sendKeys("112233");



        //Smoker
        driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();

        driver.findElement(By.xpath("//button[@type=\"submit\"] [position() =1]")).click();

        //Blood Type

        String bloodTypeXPath = String.format(DROPDOWN, "Blood Type");
        System.out.println("XPath of blood TypeX Status: " + bloodTypeXPath);
        WebElement inputBloodType = driver.findElement(By.xpath(bloodTypeXPath));
        inputBloodType.click();
        String option2XPath = String.format(OPTION, "A-");
        WebElement option2Element = driver.findElement(By.xpath(option2XPath));
        option2Element.click();
        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[2]")).click();
        // driver.close();

        //Attachments
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        driver.findElement(By.xpath("//input[@type=\"file\" and @class=\"oxd-file-input\"]")).sendKeys(System.getProperty("user.dir") + "/src/main/resources/TestDataFile/Timo.jpg");
        driver.findElement(By.xpath("//div[@class='orangehrm-attachment']//button[@type='submit'][normalize-space()='Save']")).click();




    }
}

