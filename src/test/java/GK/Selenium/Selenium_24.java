package GK.Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium_24 {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Static Dropdown")
    public void testdropDown() throws InterruptedException {
       driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

       WebElement element_select = driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));
        Select select = new Select(element_select);
        select.selectByIndex(1);
        select.selectByVisibleText("Option 2");


        Thread.sleep(1000);






    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
