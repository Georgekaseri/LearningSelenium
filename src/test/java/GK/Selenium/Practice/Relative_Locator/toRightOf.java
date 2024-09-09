package GK.Selenium.Practice.Relative_Locator;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class toRightOf {
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
        String URL = ("https://awesomeqa.com/practice.html");
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement span_element = driver.findElement(By.xpath("//*[contains(text(),'Years of Experience')]"));
        driver.findElement(with(By.id("exp-0")).toRightOf(span_element)).click();

        Thread.sleep(3000);




    }





            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
