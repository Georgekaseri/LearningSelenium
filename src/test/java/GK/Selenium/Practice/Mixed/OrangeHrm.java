package GK.Selenium.Practice.Mixed;

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

import java.util.List;

public class OrangeHrm {
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
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebElement useName = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        useName.sendKeys("Admin");

        WebElement passwordInput = driver.findElement(By.xpath("//*[@type=\"password\"]"));
        passwordInput.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        loginBtn.click();

        Thread.sleep(3000);


        String dashBoard = driver.findElement(By.xpath("//*[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")).getText();
        System.out.println("This is test : - "  + dashBoard);




    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
