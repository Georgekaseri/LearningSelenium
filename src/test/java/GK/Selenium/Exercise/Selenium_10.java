package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_10 {
    // Open app.vwo.com
    // Print the title and get the Current URL
    // VerIfy the Current URL is app.vwo.com

    @Test(groups = "QA")
    @Description("Verify the current URL, and Title of VWo Page")
    public void testVWoLogin(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        System.out.println("This is Title of the Page  : "  + driver.getTitle());
        System.out.println("Current the URL of the page : "  + driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        driver.quit();
    }
}
