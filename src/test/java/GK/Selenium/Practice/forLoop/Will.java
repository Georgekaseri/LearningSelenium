package GK.Selenium.Practice.forLoop;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Will {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify Serach functionality on Ebay")
    public void testSerachItem() throws InterruptedException {
        driver.get("https://www.williamhill.com/");
        driver.manage().window().maximize();

//      WebElement kingMill = driver.findElements(By.xpath("//*[@class=\"more_verticals_list\"]/li[1]"));
//      kingMill.click();

        Thread.sleep(3000);
        WebElement joint = driver.findElement(By.xpath("//*[@class=\"more_verticals_list\"]/li[1]"));
        joint.click();


    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
