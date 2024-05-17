package GK.Selenium.Exercise.SVG;

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

public class Selenium_29 {
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
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement searchItem = driver.findElement(By.xpath("//*[@name=\"q\"]"));
        searchItem.sendKeys("macmini");


                            // SVG Element Tag
                           //*[local-name()='svg']
                           //*[local-name()='svg'][0]
        List<WebElement> svgElement = driver.findElements(By.xpath("//*[local-name()='svg']"));
        WebElement search = svgElement.get(0);
        search.click();









    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
