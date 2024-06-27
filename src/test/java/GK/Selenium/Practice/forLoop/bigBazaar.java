package GK.Selenium.Practice.forLoop;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class bigBazaar {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("JS Alert")
    public void tesJsConfim() throws InterruptedException {
        driver.get("https://bigbazaar.uk/");
        driver.manage().window().maximize();



        WebElement serachitem = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        serachitem.sendKeys("dall");

        WebElement searchBtn = driver.findElement(By.xpath("//*[@data-ng-click=\"SearchProductItems()\"]"));
        searchBtn.click();

        Thread.sleep(3000);

        List<WebElement> searchItem = driver.findElements(By.xpath("//*[@class=\"slider-product-box ng-scope\"]"));

        int i = 0;
       for (WebElement searchDall : searchItem){
           System.out.println(i + " ---- " + searchDall.getText());
           if (i == 2){
               searchDall.click();
           }
           i++;
       }










    }

    @AfterTest
    public void closeBrowser() {
//        driver.quit();
    }
}
