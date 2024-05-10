package GK.Selenium.Exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_01 {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.get("https://youTube.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();


        /* Selenium Flow
         * 1. Create Session, ID - q09876q789e8wq89we87
         * 2. Session -> Run the commands - GET -> GET Method w3c Protocol
         * 3. EdgeDriver (Server) -> Tell the Edge Browser
         * 4. Open a Fresh copy of thre Edge Browser and Open the URL - https//sdet.live
         * 5. Driver - Command (POST) Request - Shutdown the browser.
         * */



    }

}
