package GK.Selenium.Practice;

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

public class Check_Box {
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
    public void testdropDown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

                                    // Check Box
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));







    }

    @AfterTest
    public void closeBrowser() {
//        driver.quit();
    }
}
