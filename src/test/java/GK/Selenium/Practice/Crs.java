package GK.Selenium.Practice;

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

public class Crs {
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
       driver.get("https://ircc.canada.ca/english/immigrate/skilled/crs-tool.asp");
        driver.manage().window().maximize();

        WebElement marriageStatus = driver.findElement(By.xpath("//*[@class=\"form-control mrgn-bttm-md valid\"]"));
        marriageStatus.isSelected();








    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
