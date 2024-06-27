package GK.Selenium.Practice.Mixed;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

     WebElement dropdownOptions = driver.findElement(By.xpath("//*[@id=\"q1\"]"));

     Select select = new Select(dropdownOptions);
     select.selectByVisibleText("Common-Law");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"q2i\"]")));

     WebElement common = driver.findElement(By.xpath("//*[@id=\"q3\"]"));
     common.click();
     Select select1 = new Select(common);
     select1.selectByVisibleText("Yes");










    }

    @AfterTest
    public void closeBrowser(){
//        driver.quit();
    }
}
