package GK.Selenium.Practice.Iframe;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Iframe_01 {
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
        String URL = ("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.get(URL);
        driver.manage().window().maximize();

        Thread.sleep(5000);

        driver.switchTo().frame("result");

        WebElement clickOnSubmitBtn = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));
        clickOnSubmitBtn.click();

        WebElement element= driver.findElement(By.xpath("//input[@id=\"username\"]"));
        WebElement errorElement = driver.findElement(with(By.tagName("small")).below(element));
        String errorText = errorElement.getText();
        Assert.assertTrue(errorElement.isDisplayed());
        Assert.assertEquals(errorText,"Username must be at least 3 characters");
        System.out.println(errorText);

        Thread.sleep(5000);





    }





            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
