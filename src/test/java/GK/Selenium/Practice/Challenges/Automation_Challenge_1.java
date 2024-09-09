package GK.Selenium.Practice.Challenges;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Automation_Challenge_1 {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Calculate the Total Amount of Money Spent")
    public void testSearchItem() throws InterruptedException {
        String URL = ("https://demo.applitools.com/");
        driver.get(URL);
        driver.manage().window().maximize();

        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.applitools.com/");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Password@123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log-in"))).click();


    }
    @Test(dependsOnMethods = {"test"})
            public void spentAmount(){
        double  totalSpent = 0;
        double totalEarned = 0;


        List<WebElement> rows = driver.findElements(By.xpath("//*[@class=\"table table-padded\"]/tbody/tr"));

        for(WebElement row : rows){
            List<WebElement> col = row.findElements(By.tagName("td"));
            int col_size = col.size();
                if (col_size > 1){
                    String amountInString = col.get(4).getText();
                    Double amountInDouble=Double.parseDouble(amountInString.replace(",", "").replace("USD", "").replace("+", "").replace("-", "").trim());

                    if (amountInString.contains("-")){
                        totalSpent +=amountInDouble;

                    }else {
                        totalEarned += amountInDouble;
                    }
                }
            System.out.println("Total amount spent : " + totalSpent + " USD");
            System.out.println("Total amount earned : " + totalEarned + " USD");
        }



    }















            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
