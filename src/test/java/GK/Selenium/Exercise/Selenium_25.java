package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_25 {
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
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

                                 //Click for JS Alert
//        WebElement jsAlertbtn = driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
//        jsAlertbtn.click();
        /*
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss(); // for dismiss
        String result = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        Assert.assertEquals(result, "You entered: Hyderabad ");
         */

                                   //Click for JS Confirm button
//        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
//        jsConfirmBtn.click();

//                              // AWS, Machine, Docker, ALert will be loaded very slow - limited RAM
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.alertIsPresent());
        /*
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String result = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        Assert.assertEquals(result, "You entered: Hyderabad ");
         */

                                    // JS Prompt Click
        WebElement promptClick = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        promptClick.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hyderabad");
        alert.accept();
        String result = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        Assert.assertEquals(result, "You entered: Hyderabad ");


        Thread.sleep(1500);


    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
