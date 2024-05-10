package GK.Selenium.Exercise;

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

public class Selenium_19 {
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
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        driver.manage().window().maximize();

        WebElement searchInputBox = driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));
        searchInputBox.sendKeys("macmini");

        WebElement searchbtn = driver.findElement(By.cssSelector("input[value=\"Search\"]"));
        searchbtn.click();

        Thread.sleep(3000);

        List<WebElement> searchTitle = driver.findElements(By.xpath("//*[@class=\"s-item__title\"]"));

        int  i = 0;
        for (WebElement title : searchTitle){
            System.out.println(i + "  --  " + title.getText());
            if (i == 5){
                title.click();
            }
            i++;

            /*
            for(WebElement title : searchTitle){
            System.out.println(title.getText());
             }
             */
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
