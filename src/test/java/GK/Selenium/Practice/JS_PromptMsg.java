package GK.Selenium.Practice;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JS_PromptMsg {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("JS Confim Button")
    public void tesJsConfim() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebElement jsConfimbtn = driver.findElement(By.xpath("//*[@onclick=\"jsConfirm()\"]"));
        jsConfimbtn.click();

       WebElement confirmPromptAlert = driver.findElement(By.xpath("//*[@onclick=\"jsPrompt()\"]"));
       confirmPromptAlert.click();

       Alert alert = driver.switchTo().alert();
       alert.sendKeys("Hi there, I am learning Selenium");
       String string = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
       Assert.assertEquals(string,"You entered: Hi there, I am learning Selenium");







    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
