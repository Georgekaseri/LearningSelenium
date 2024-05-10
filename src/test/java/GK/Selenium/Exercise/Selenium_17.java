package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium_17 {
    // Atomic Test Cases
    // TC who don't have any dep.
    // They serve single purpose 0

    ChromeDriver driver;
    @BeforeTest
    public void openBrowser(){
        driver = new ChromeDriver();

    }
    @Test(groups = "QA")
    @Description("Verify the Login functionality with valid userName and Password")
    public void testVWOLogin_positiv() throws InterruptedException {
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
    @Test(groups = "QA")
    @Description("Verify the Login functionality with valid userName and invalid Password")
    public void testVWOLogin_negative() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement btnMakeAppointment = driver.findElement(By.xpath("//a[@id=\"btn-make-appointment\"]"));
        btnMakeAppointment.click();
        Thread.sleep(2000);

        WebElement userNameElemt = driver.findElement(By.xpath("//input[@id=\"txt-username\"]"));
        userNameElemt.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id=\"txt-password\"]"));
        password.sendKeys("ThisIsNotAPasswo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Login failed')]"));
        String errorMsgTxt = errorMsg.getText();
        System.out.println(errorMsgTxt);

        Assert.assertEquals(errorMsgTxt,"Login failed! Please ensure the username and password are valid.");





}
@AfterTest
    public void loseBrowser(){
        driver.quit();
}
}
