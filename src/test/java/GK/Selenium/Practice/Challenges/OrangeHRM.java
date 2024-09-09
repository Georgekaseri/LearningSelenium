package GK.Selenium.Practice.Challenges;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class OrangeHRM {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("OrganHRM")
    public void testSearchItem() throws InterruptedException {
        String URL = ("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.get(URL);
        driver.manage().window().maximize();


        WebElement userName = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        userName.sendKeys("Admin");


        WebElement inputPassword = driver.findElement(By.xpath("//*[@name=\"password\"]"));
        inputPassword.sendKeys("admin123");

        WebElement submitBtn = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        submitBtn.click();
        Thread.sleep(5000);


        String dashBoard = driver.findElement(By.xpath("//*[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")).getText();
        System.out.println("This is  : - " + dashBoard);

        Assert.assertEquals(dashBoard, "Dashboard");

        String loginUserName = driver.findElement(By.xpath("//*[@class=\"oxd-userdropdown-name\"]")).getText();
        System.out.println("Login User Name is : - " + loginUserName);
        Assert.assertEquals(loginUserName, "manda user");

        List<WebElement> liElement = driver.findElements(By.xpath("//*[@class=\"oxd-main-menu\"]/li"));
        WebElement pim = liElement.get(1);
        pim.click();
    }

        @Test(dependsOnMethods = {"Test"})
                public void addNewEmployee(){
            WebElement addNewEmployeeBtn = driver.findElement(By.xpath("//*[@type=\"button\"]"));
            addNewEmployeeBtn.click();
        }















            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
