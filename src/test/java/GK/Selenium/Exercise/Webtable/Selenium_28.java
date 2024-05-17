package GK.Selenium.Exercise.Webtable;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_28 {
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--gust");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Static Dropdown")
    public void testdropDown() throws InterruptedException {
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);
        driver.manage().window().maximize();

        /*
        //table[@id="customers"]/tbody/tr[5]/td[2] : - Helen Bennett

        /following-sibling::td : - Country Name

        Print all the data in the table and where is Halen Bennett and which country she is belongs to
         */


        String first_part = " //table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";


        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();   // Row is started from 2 to 7
        int column = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size(); // Column from started from 2


        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                String  data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);

                if (data.contains("Helen Bennett")){
                    String country_path = dynamic_xpath+ "/following-sibling::td";
                    String country_text = driver.findElement(By.xpath(country_path)).getText();
                    System.out.println("--------------- ");
                    System.out.println("Helen Bennett is from : - " + country_text );
                }

            }

        }









    }

    @AfterTest
    public void closeBrowser() {
//        driver.quit();
    }
}
