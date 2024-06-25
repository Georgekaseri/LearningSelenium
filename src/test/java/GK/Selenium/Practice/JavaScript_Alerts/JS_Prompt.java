package GK.Selenium.Practice.JavaScript_Alerts;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class JS_Prompt {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("JS Prompt")
    public void tesJsConfim() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebElement promptClick = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        promptClick.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());



        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hyderabad");
        alert.accept();
        String result = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        Assert.assertEquals(result, "You entered: Hyderabad");









    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
