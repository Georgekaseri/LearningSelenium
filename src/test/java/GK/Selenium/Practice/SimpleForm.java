package GK.Selenium.Practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SimpleForm {
    @Test
    @Description("Simple Form")
    public void testFillForm(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=800,600");
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        System.out.println("This is current URL  : "  + driver.getCurrentUrl());


        WebElement firstNameInputBox = driver.findElement(By.id("firstName"));
        firstNameInputBox.sendKeys("Hasan Ali ");

        WebElement lastNameInputBox = driver.findElement(By.id("lastName"));
        lastNameInputBox.sendKeys("Mohammed");

//
//        driver.quit();



    }

}
