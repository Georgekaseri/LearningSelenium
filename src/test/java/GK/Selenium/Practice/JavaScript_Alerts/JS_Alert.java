package GK.Selenium.Practice.JavaScript_Alerts;

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

public class JS_Alert {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("JS Alert")
    public void tesJsConfim() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebElement jsAlert = driver.findElement(By.xpath("//*[@onclick=\"jsAlert()\"]"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String displayMessage = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        Assert.assertEquals(displayMessage,"You successfully clicked an alert");








    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
