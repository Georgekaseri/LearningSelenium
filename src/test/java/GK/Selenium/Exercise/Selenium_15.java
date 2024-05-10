package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium_15 {
    @Test(groups = "QA")
    @Description("Verify login functionality with valid test data")
    public void testKatalon15() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // <a


        // href="./profile.php#login"


        // Make Appointment

        // </a>
//        WebElement btnElement_ID = driver.findElement(By.id("btn-make-appointment"));
//        WebElement btnElement_CN = driver.findElement(By.className("btn.btn-dark.btn-lg"));
//        WebElement btnElement_PTEXT = driver.findElement(By.partialLinkText("Make"));
//        WebElement btnElement_LTEXT = driver.findElement(By.partialLinkText("Make Appointment"));
//        WebElement btnElement_AT = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
//       Not RECOM WebElement btnElement_TagName = driver.findElement(By.tagName("a")); // Multiple a tag  - not recommen

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
