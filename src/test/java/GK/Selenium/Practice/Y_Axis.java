package GK.Selenium.Practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Y_Axis {
    @Test(groups = "Hyderabad")
    @Description("Verify login functionality ")
    public void testStudentInquire(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("This page Title : -  "  +  driver.getTitle());

        WebElement userNameInputeBox = driver.findElement(By.id("username"));
        userNameInputeBox.sendKeys("student");

        WebElement passwordInputeBox = driver.findElement(By.name("password"));
        passwordInputeBox.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


        driver.quit();




    }


}
