package GK.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium_03 {
    @Test
    public void testMethod(){
        // Extension to the Edge Browser
        // YouTube Video -. Ad Blocker Extension


        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments( "--headless" );
        chromeOptions.addExtensions(new File("/Users/george/Documents/Adblock-Plus-free-ad-blocker.crx"));
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
