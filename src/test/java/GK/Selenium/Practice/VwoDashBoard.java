package GK.Selenium.Practice;

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

public class VwoDashBoard {
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
       driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.xpath("//input[@id='login-username']"));
        email.sendKeys("georgekaseri22@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
        password.sendKeys("Leeds85@");
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"js-login-btn\"]"));
        submitBtn.click();



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));

        WebElement logged_in_username = driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));
        System.out.println("Logged in User details -> " + logged_in_username.getText());



        List<WebElement> dashBoardLinks = driver.findElements(By.xpath("//*[@data-qa=\"nav-group\"]"));
        int i = 0;
        for (WebElement linksList : dashBoardLinks){
            System.out.println(linksList.getText());
            if (i == 5){
                linksList.click();
            }
            i++;


        }







    }

    @AfterTest
    public void closeBrowser(){
//        driver.quit();
    }
}
