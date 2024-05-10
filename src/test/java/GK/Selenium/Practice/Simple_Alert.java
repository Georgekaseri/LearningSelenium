package GK.Selenium.Practice;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Simple_Alert {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Simple Alert")
    public void testJsAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebElement simpleJsAlert = driver.findElement(By.xpath("//*[@onclick=\"jsAlert()\"]"));
        simpleJsAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");

        System.out.println("This is message : " + result);









    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
