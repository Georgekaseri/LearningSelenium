package GK.Selenium.Practice.shadowDom;

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

public class clickOnLinkShadowdom {
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
        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        driver.manage().window().maximize();

        JavascriptExecutor js =(JavascriptExecutor) driver;

        WebElement divScrolling = driver.findElement(By.xpath("//div[@id=\"userName\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", divScrolling);

        Thread.sleep(2000);

        WebElement clickOnLink = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"a.learningHub\")");
        clickOnLink.click();


    }


            @AfterTest
            public void closeBrowser () {
//                driver.quit();
            }
        }
