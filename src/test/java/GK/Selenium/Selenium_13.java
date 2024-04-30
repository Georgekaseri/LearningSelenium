package GK.Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;

import java.util.List;

public class Selenium_13 {
    @Test(groups = "QA")
    @Description("Verify the current URL, and Title of VWo Page")
    public void testVWoLogin13() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login  ");

        List<WebElement> all_atags = driver.findElements(By.tagName("a"));
//        all_atags.get(0).click(); // start free trial
//        all_atags.get(1).click(); // 2nd one - vwo insights
//        all_atags.size(); // 2
        for( WebElement element: all_atags){
            System.out.println(element.getText());
        }


        driver.close(); // Close the current window


    }
}