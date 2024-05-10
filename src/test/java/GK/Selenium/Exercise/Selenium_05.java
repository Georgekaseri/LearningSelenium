package GK.Selenium.Exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium_05 {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();

        //Maximized Screen
//       chromeOptions.addArguments("--start-maximized");
        /*
         * 1. headless
         * 2. start max
         * 3. window
         * 4. add exnetions
         * 5. 100 of another options - you can use with it
         *
         * */

        //Screen Size
        chromeOptions.addArguments("--window-size=800,600");
        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments( "--headless" );




        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
