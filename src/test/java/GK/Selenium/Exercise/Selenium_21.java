package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium_21 {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify Serach functionality on Ebay")
    public void testSerachItem() throws InterruptedException {
       driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.xpath("//input[@id='login-username']"));
        email.sendKeys("georgekaseri22@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
        password.sendKeys("Hyderabad");
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"js-login-btn\"]"));
        submitBtn.click();

        WebElement error_msg = driver.findElement(By.xpath("//*[@id=\"js-notification-box-msg\"]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));

        wait.until(ExpectedConditions.textToBePresentInElement(error_msg,"Your email, password, IP address or location did not match"));

        System.out.println("Error Message -> " + error_msg.getText());

























    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
