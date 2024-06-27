package GK.Selenium.Practice.CheckBox;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
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

public class Check_Box_Practice {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Check Boxes")
    public void testselectCheckBox() throws InterruptedException {
        driver.get("https://artoftesting.com/samplesiteforselenium");
        driver.manage().window().maximize();

        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
        textBox.sendKeys("George");

        WebElement subBtn = driver.findElement(By.xpath("//*[@id=\"idOfButton\"]"));
        subBtn.click();



                                    // Select Male Radio Button
        List<WebElement> radioBtn = driver.findElements(By.xpath("//*[@name=\"gender\"]"));
        WebElement maleBtn = radioBtn.get(0);
        maleBtn.click();

                                    // Select Check Box for Automation Testing
        List<WebElement> checkAtmPft = driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
        WebElement automationTesting = checkAtmPft.get(0);
        automationTesting.click();

                                     // Select Check Box for Performance Testing
        WebElement performanceTesting = checkAtmPft.get(1);
        performanceTesting.click();

                                    // Select Dropdown menu

        WebElement selectMenu = driver.findElement(By.xpath("//*[@id=\"testingDropdown\"]"));
        Select aut = new Select(selectMenu);
        aut.selectByVisibleText("Manual Testing");

                                    // Generate Alert Box
        WebElement generateAlertBox = driver.findElement(By.xpath("//*[@onclick=\"generateAlertBox()\"]"));
        generateAlertBox.click();

        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

                                    // Generate Confirm Box
        WebElement clickOnbtn = driver.findElement(By.xpath("//*[@onclick=\"generateConfirmBox()\"]"));
        clickOnbtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert confimAlert = driver.switchTo().alert();
        confimAlert.accept();

        String verifyMsg = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
        Assert.assertEquals(verifyMsg,"You pressed OK!");
        System.out.println(verifyMsg);











    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
