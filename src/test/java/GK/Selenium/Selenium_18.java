package GK.Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium_18 {



    ChromeDriver driver;
    @BeforeTest
    public void openBrowser(){
        driver = new ChromeDriver();

    }
    @Test(groups = "QA")
    @Description("Verify the Login functionality with valid userName and Password")
    public void testLogin_positiv() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
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
    }

    @AfterTest
    public void loseBrowser(){
        driver.quit();
    }
}
