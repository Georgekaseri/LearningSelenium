package GK.Selenium.Practice.Action_Classes;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Key_File_Upload {
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
    public void testSearchItem() throws InterruptedException {
        String URL = "https://the-internet.herokuapp.com/upload";
        driver.get(URL);
        driver.manage().window().maximize();





        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String dir = System.getProperty("user.dir");

        System.out.println(dir);
        chooseFile.sendKeys(dir + "/src/test/java/GK/Selenium/Exercise/UploadFile.txt");
        driver.findElement(By.id("file-submit")).click();








    }


            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
