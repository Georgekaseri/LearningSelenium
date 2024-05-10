package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium_23 {
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
        password.sendKeys("Leeds85@");
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"js-login-btn\"]"));
        submitBtn.click();


        // Fluent Wait
        Wait<ChromeDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);


        WebElement logged_in_username = wait.until(driver -> driver.findElement(By.cssSelector("[data-qa='lufexuloga']")));
        System.out.println("Logged in User details -> " + logged_in_username.getText());






    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
