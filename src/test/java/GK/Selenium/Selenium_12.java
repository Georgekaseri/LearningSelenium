package GK.Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_12 {
    @Test(groups = "QA")
    @Description("Verify the current URL, and Title of VWo Page")
    public void testVWoLogin12() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

//        WebElement anhor_tag = driver.findElement(By.linkText("Start a free trial"));
        WebElement anhor_tag = driver.findElement(new By.ByPartialLinkText("Start a free"));
        System.out.println("This is Anhor Tag : " +   anhor_tag.getAttribute("href"));
        anhor_tag.click();



        driver.quit();
    }
}