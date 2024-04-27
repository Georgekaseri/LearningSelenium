package GK.Selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium_09 {
    public static void main(String[] args) throws MalformedURLException {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://youTube.com");

        chromeDriver.navigate().to("https://googlw.co.uk");
        chromeDriver.navigate().to(new URL("https://www.airbnb.co.uk/"));
        chromeDriver.navigate().back();
        chromeDriver.navigate().forward();
        chromeDriver.navigate().refresh();


    }
}
