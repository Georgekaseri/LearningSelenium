package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Selenium_38 {
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
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();

        String mainWindowHanding = driver.getWindowHandle();
        System.out.println("Before CLick " + mainWindowHanding);

        WebElement elementHabding = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        elementHabding.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles){
            driver.switchTo().window(handle);
            System.out.println(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed");
            }
        }

        driver.switchTo().window(mainWindowHanding);
        Thread.sleep(3000);















    }


            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
