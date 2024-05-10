package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium_16 {

    @Test(groups = "QA")
    @Description("Verify login functionality with valid test data")
    public void testKatalon16() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");



        WebElement btnMakeAppointment = driver.findElement(By.xpath("//a[@id=\"btn-make-appointment\"]"));
        btnMakeAppointment.click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        List<WebElement> userNameElemt = driver.findElements(By.xpath("//input[@placeholder=\"Username\"]"));
        userNameElemt.get(1).sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id=\"txt-password\"]"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        loginButton.click();

        driver.quit();
    }
}

