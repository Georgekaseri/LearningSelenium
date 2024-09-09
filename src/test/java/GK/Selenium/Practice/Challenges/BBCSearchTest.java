package GK.Selenium.Practice.Challenges;

import io.qameta.allure.Description;
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
import java.util.List;

public class BBCSearchTest {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Calculate the Total Amount of Money Spent")
    public void testSearchItem() throws InterruptedException {
        String URL = ("https://www.bbc.com");
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.cssSelector("input[aria-label='Search']"));
        searchBox.sendKeys("Climate Change");
        searchBox.submit();

        WebElement firstArticle = driver.findElement(By.cssSelector("[data-entityid='container-top-stories#1'] a"));
        String articleText = firstArticle.getText();
        Assert.assertTrue(articleText.contains("Climate"));






    }















            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
