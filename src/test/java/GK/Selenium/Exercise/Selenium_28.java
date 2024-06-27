package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium_28 {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Webtable")
    public void testWebTable() throws InterruptedException {
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        driver.manage().window().maximize();


        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        List<WebElement> row_in_table = table.findElements(By.tagName("tr"));
        System.out.println(row_in_table.size());

        for (int i = 0; i < row_in_table.size() ; i++) {

            List<WebElement> col = row_in_table.get(i).findElements(By.tagName("td"));
            for (WebElement e: col){
                System.out.println(e.getText());
            }
            
        }













    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
