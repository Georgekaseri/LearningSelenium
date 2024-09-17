package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_44 {
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
        String URL = ("https://www.google.co.uk/");
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(4000);

       try {
           WebElement ele1 = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));

           driver.navigate().refresh();

           WebElement ele2 = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
           ele2.sendKeys("Hello ");
       }catch (StaleElementReferenceException | NoSuchElementException e){
           e.printStackTrace();
       }catch (Exception e){
           e.printStackTrace();
       }








    }





            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
