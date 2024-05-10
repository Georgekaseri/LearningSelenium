package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_14 {

    @Test(groups = "QA")
    @Description("Verify the current URL, and Title of VWo Page")
    public void testVWoLogin13() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login  ");

    }
}
