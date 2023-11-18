package InteractWithElement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ExampleMethodInSelenium {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //14
        //driver.get("https://demoqa.com/select-menu");
        //15
        driver.get("https://demoqa.com/");
        //driver.get("https://demoqa.com/automation-practice-form");

        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //selectMethod(driver);
        //deselectByIndex(driver);
        //DemoDeselectByVisibleText(driver);
        //DemoDeSelectByValue(driver);
        //getAllSelectedOptions11(driver);
        // DemoIsMultiple13(driver);
        // DemoEqualMethod14(driver);
        //getAttribute15(driver);
        //getClass16(driver);
        //DemoGetCssValue17(driver);
        //DemoGetLocation18(driver);
        DemoTakeScreenshot(driver);



    }
        private static void selectMethod(WebDriver driver){

            WebElement dropdownElement = driver.findElement(By.id("oldSelectMenu"));
            // Create a Select object
            Select select = new Select(dropdownElement);
            // Select an option by its index (e.g., index 2, which is the third option)
            select.selectByIndex(2);
            // Close the browser
            driver.quit();

        }

    private static void deselectByIndex(WebDriver driver) throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("cars"));
        // Create a Select object
        Select select1 = new Select(dropdownElement);
        // Select an option by its index (e.g., index 2, which is the third option)
        select1.selectByIndex(2);
        Thread.sleep(2000);
        select1.deselectByIndex(2);

        driver.close();

    }
    private static void DemoDeselectByVisibleText(WebDriver driver) throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("cars"));
        // Create a Select object
        Select select = new Select(dropdownElement);
        // Select an option by its index (e.g., index 2, which is the third option)
        select.selectByIndex(0);
        Thread.sleep(3000);
        select.deselectByVisibleText("Volvo");

    }
    private static void deselectByValue (WebDriver driver){
        WebElement dropdownElement = driver.findElement(By.id("cars"));
        // Create a Select object
        Select select = new Select(dropdownElement);
        // Select an option by its index (e.g., index 2, which is the third option)
        select.selectByValue("volvo");
        select.deselectByValue("volvo");

    }
    private static void selectByValue (WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("cars"));
        // Create a Select object
        Select select = new Select(dropdownElement);
        // Select an option by its index (e.g., index 2, which is the third option)
        select.selectByValue("saab");

    }
    private static void getAllSelectedOptions11 (WebDriver driver){
        WebElement dropdownElement = driver.findElement(By.id("cars"));
        // Create a Select object
        Select select = new Select(dropdownElement);
        // Select multiple options in the dropdown (assuming it's a multi-select)
        select.selectByValue("volvo");
        select.selectByValue("audi");

        // Retrieve all selected options
        List<WebElement> selectedOptions = select.getAllSelectedOptions();



        // Print the selected options
        for (WebElement option : selectedOptions) {
            System.out.println("Selected Option: " + option.getText());
        }
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println("First Selected Option: " + firstSelectedOption.getText());

    }

    private static void getFirstSelectedOption12 (WebDriver driver){
        WebElement dropdownElement = driver.findElement(By.id("oldSelectMenu"));
        // Create a Select object
        Select select = new Select(dropdownElement);
        // Select an option from the dropdown (e.g., by visible text)
        select.selectByVisibleText("Red");
        // Retrieve the first selected option
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        // Print the text of the first selected option
        System.out.println("First Selected Option: " + firstSelectedOption.getText());


    }
    private static void DemoIsMultiple13  (WebDriver driver){
        WebElement dropdownElement = driver.findElement(By.id("cars"));
        // Create a Select object
        Select select = new Select(dropdownElement);
        // Check if the dropdown is multi-select or single-select
        boolean isMultiSelect = select.isMultiple();
        if (isMultiSelect) {
            System.out.println("Dropdown is multi-select.");
        } else {
            System.out.println("Dropdown is single-select.");
        }
    }
    private static void DemoEqualMethod14(WebDriver driver){

        // Locate two elements you want to compare
        WebElement element1 = driver.findElement(By.xpath("//h5[text()='Forms']"));
        WebElement element2 = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));


        // Check if the elements are equal
        boolean areEqual = element1.equals(element2);
        System.out.println("The elements ofelement1 is "+element1);
        System.out.println("The elements ofelement2 is "+element2);
        if (areEqual) {
            System.out.println("The elements are equal.");
        } else {
            System.out.println("The elements are not equal.");
        }


        driver.quit();
    }
    private static void getAttribute15(WebDriver driver){
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        // Get the "placeholder" attribute value
        String placeholderValue = firstNameInput.getAttribute("placeholder");
        // Print the attribute value
        System.out.println("Placeholder attribute value: " + placeholderValue);
        driver.quit();


    }

    private static void getClass16(WebDriver driver){
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        // Get the "class" attribute value
        String classValue = firstNameInput.getAttribute("class");
        // Print the attribute value
        System.out.println("Class value: " + classValue);
        // Get the "class" attribute value
        String typeValue = firstNameInput.getAttribute("type");
        // Print the attribute value
        System.out.println("Type value: " + typeValue);
        //Returns the object of type Class that represents the runtime class of the object
        String classValue1 = firstNameInput.getClass().toString();
        System.out.println("Class value: " + classValue1);
        driver.quit();

    }
    private static void DemoGetCssValue17(WebDriver driver){
        WebElement element = driver.findElement(By.cssSelector("div[class='home-body'] div:nth-child(2) div:nth-child(1) div:nth-child(3) h5:nth-child(1)"));
        // Use the getCssValue method to retrieve the value of a specific CSS property
        String color = element.getCssValue("color");
        // Print the retrieved CSS property value
        System.out.println("Text color: " + color);
        // Use the getCssValue method to retrieve the value of a specific CSS property
        String backgroundColor = element.getCssValue("background-color");
        // Print the retrieved CSS property value
        System.out.println("Background Color color: " + backgroundColor);
    }
    private static void DemoGetLocation18(WebDriver driver){
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        // Use the getLocation() method to get the location
        Point elementLocation = firstNameInput.getLocation();
        // Retrieve the x and y coordinates
        int x = elementLocation.getX();
        int y = elementLocation.getY();
        // Print the coordinates to the console
        System.out.println("X Coordinate: " + x);
        System.out.println("Y Coordinate: " + y);
        driver.quit();

    }
    private static void DemoTakeScreenshot(WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//h5[text()='Forms']"));
        // Take a screenshot of the element
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Use FileUtils to save the screenshot to a file
            FileUtils.copyFile(screenshot, new File("screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Close the browser
        driver.quit();


    }
}










