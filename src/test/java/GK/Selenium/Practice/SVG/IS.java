package GK.Selenium.Practice.SVG;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class IS {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Static Dropdown")
    public void testSearchItem() throws InterruptedException {
        String URL = "https://www.interactsoftware.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement btn = driver.findElement(By.xpath("//*[@class=\"btn btn-primary btn-lg\"]"));
btn.click();

Thread.sleep(4000);

WebElement firstName = (WebElement) js.executeScript("return document.querySelector(\"input.text\")");
firstName.sendKeys("Hello");














    }

    @AfterTest
    public void closeBrowser() {
//        driver.quit();
    }
}
