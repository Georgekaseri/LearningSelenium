package GK.Selenium.Practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Retry {
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
    public void testdropDown() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com");
        driver.manage().window().maximize();

        WebElement checkOnMakeAppointment = driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]"));
        checkOnMakeAppointment.click();

        WebElement userName = driver.findElement(By.xpath("//*[@id=\"txt-username\"]"));
        userName.sendKeys("John Doe");

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"txt-password\"]"));
        passwordInput.sendKeys("ThisIsNotAPassword");

        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"btn-login\"]"));
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"appointment\"]/div/div/div/h2")));

        WebElement facility = driver.findElement(By.xpath("//*[@id=\"combo_facility\"]"));
        Select selectLocation = new Select(facility);
        selectLocation.selectByVisibleText("Seoul CURA Healthcare Center");

        WebElement checkBox = driver.findElement(By.xpath("//*[@type=\"checkbox\"]"));
        checkBox.click();

        List<WebElement> CheckBoxes = driver.findElements(By.xpath("//*[@class=\"radio-inline\"]"));
        WebElement none = CheckBoxes.get(2);
        none.click();

        WebElement selectDate = driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]"));
        selectDate.sendKeys("10/12/2024");

        WebElement commands = driver.findElement(By.xpath("//*[@id=\"txt_comment\"]"));
        commands.sendKeys("I am looking a life");

        WebElement bookAppointmentBtn = driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]"));
        bookAppointmentBtn.click();

        String messageCon = driver.findElement(By.xpath("//*[@id=\"comment\"]")).getText();

        Assert.assertEquals(messageCon,"I am looking a life");


        String dateVer = driver.findElement(By.xpath("//*[@id=\"visit_date\"]")).getText();
        Assert.assertEquals(dateVer,"10/12/2024");


        System.out.println(messageCon  +   " "  + dateVer);


    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
