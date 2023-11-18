package Luyentap1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
public class Luyentap2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        // Locate the form element
        WebElement formElement = driver.findElement(By.id("userForm"));


        // Fill in the form fields with the required data
        WebElement firstNameInput = formElement.findElement(By.id("firstName"));
        firstNameInput.sendKeys("John");


        WebElement lastNameInput = formElement.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Doe");


        WebElement emailInput = formElement.findElement(By.id("userEmail"));
        emailInput.sendKeys("johndoe@example.com");


        // ... Fill in other form fields ...


        // Submit the form using the submit() method
        formElement.submit();



        //driver.quit();
    }



}

