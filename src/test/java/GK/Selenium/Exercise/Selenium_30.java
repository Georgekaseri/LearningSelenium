package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium_30 {
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
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);
        driver.manage().window().maximize();

        ////*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path'] -> 36 States
        // Click on THE Tripura?

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        for (WebElement state : states) {
            System.out.println(state.getAttribute("aria-label"));
            if (state.getAttribute("aria-label").contains("Tripura ")) {
                state.click();

            }
        }
    }

            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
