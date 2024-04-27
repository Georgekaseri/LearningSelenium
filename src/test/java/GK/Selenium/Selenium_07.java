package GK.Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium_07 {
    public static void main(String[] args) {


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);




        WebDriver driver = new ChromeDriver();
        driver.get("https://google.co.uk");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}

