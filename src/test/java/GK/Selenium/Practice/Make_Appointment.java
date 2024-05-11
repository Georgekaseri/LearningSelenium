package GK.Selenium.Practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
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

public class Make_Appointment {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Make An Appointment")
    public void testBookingAppointment() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement makeAppointmentBtn = driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]"));
        makeAppointmentBtn.click();

        WebElement userName = driver.findElement(By.xpath("//*[@id=\"txt-username\"]"));
        userName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"txt-password\"]"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"btn-login\"]"));
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"appointment\"]/div/div/div/h2"))));


        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"combo_facility\"]"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Seoul CURA Healthcare Center");

        WebElement readmission = driver.findElement(By.xpath("//*[@id=\"chk_hospotal_readmission\"]"));
        readmission.click();

        List<WebElement>  healthProgram = driver.findElements(By.xpath("//*[@class=\"radio-inline\"]"));
        WebElement medical = healthProgram.get(1);
        medical.click();

        WebElement visitDate = driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]"));
        visitDate.sendKeys("10/06.2024");

        WebElement comments = driver.findElement(By.xpath("//*[@id=\"txt_comment\"]"));
        comments.sendKeys("Hello Automation");

        WebElement bookappointmentBtn = driver.findElement(By.xpath("//*[@class=\"btn btn-default\"]"));
        bookappointmentBtn.click();


        String common = driver.findElement(By.xpath("//*[@id=\"comment\"]")).getText();
        Assert.assertEquals(common,"Hello Automation");


        System.out.println(common);








    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
