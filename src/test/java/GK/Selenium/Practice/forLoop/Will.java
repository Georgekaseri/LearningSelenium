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

//

        Thread.sleep(3000);
//
        List<WebElement> clickOnMill = driver.findElements(By.xpath("//*[@class=\"more_verticals_item\"]"));

        int i = 0;
        for (WebElement el : clickOnMill){
            System.out.println(el.getText());
            if (i == 2){
                el.click();
            }
            i++;
        }

        Thread.sleep(3000);


    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
