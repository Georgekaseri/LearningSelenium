package GK.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium_01 {
    @Test
    public void testMethods(){

        // Extension to the Edge Browser
        // YouTube Video -. Ad Blocker Extension

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("/Users/george/Downloads/OGDLPMHGLPEJOIOMCODNPJNFGCPMGALE_3_3_2_0.crx"));
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.youtube.com/");
        System.out.println();
//        driver.quit();
    }
}
