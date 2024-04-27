package GK;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Testcase02 {
    @Test
    @Description("Verify title of the Visas Central Website.")
    public void titlePage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.co.uk/");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
