package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;


import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium_41 {
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
        String URL = ("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.get(URL);
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"search_city\"]"));
        searchElement.sendKeys("India" + Keys.ENTER);

        List<WebElement> list_Of_States = driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr/td[2]"));

        for (WebElement l : list_Of_States){
            String s1 = driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
            String s2 = driver.findElement(with(By.tagName("P")).toLeftOf(l)).getText();
            String s3 = driver.findElement(with(By.tagName("P")).below(l)).getText();
            String s4 = driver.findElement(with(By.tagName("P")).above(l)).getText();
            System.out.println(l.getText()  + " | " + s1 + " | " + s2 );
            System.out.println(l.getText()  + " | " + s3 + " | " + s4 );


        }



Thread.sleep(5000);

    }





            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
