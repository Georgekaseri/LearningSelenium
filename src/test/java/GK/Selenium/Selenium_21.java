package GK.Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_21 {
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
       driver.get("https://wf-ecomm-pwa-git-feat-enhanced-search-wellness-forever.vercel.app/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Use Current Location')]"));
        element.click();




















    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
