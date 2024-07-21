package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_33 {
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
        String URL = "https://www.spicejet.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement originalFlight = driver.findElement(By.xpath("//*[@data-testid=\"to-testID-origin\"]/div/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(originalFlight).click().build().perform();
        actions.moveToElement(originalFlight).sendKeys("HYD").build().perform();

        WebElement destinationFlight = driver.findElement(By.xpath("//*[@data-testid=\"to-testID-destination\"]/div/div/input"));

        actions.moveToElement(destinationFlight).click().build().perform();
        actions.moveToElement(destinationFlight).sendKeys("DEL").build().perform();

//        Thread.sleep(4000);
//
//      WebElement searchFlight = driver.findElement(By.id("fromCity"));
//      Actions actions = new Actions(driver);
//      actions.moveToElement(searchFlight).click().sendKeys("New Delhi").build().perform();







    }


            @AfterTest
            public void closeBrowser () {
//                driver.quit();
            }
        }
