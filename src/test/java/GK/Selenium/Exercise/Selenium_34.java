package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium_34 {
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
    public void testSearchItem() throws InterruptedException {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();



        Thread.sleep(4000);

      WebElement searchFlight = driver.findElement(By.id("fromCity"));
      Actions actions = new Actions(driver);
      actions.moveToElement(searchFlight).click().sendKeys("New Delhi").build().perform();

        List<WebElement> searchDestination = driver.findElements(By.xpath("//*[@class=\"react-autosuggest__suggestions-list\"]/li"));


      for(WebElement del: searchDestination){
          if (del.getText().contains("New Delhi")) {
              del.click();
              break;

          }
      }

      WebElement returnFlight = driver.findElement(By.id("toCity"));
      actions.moveToElement(returnFlight).click().sendKeys("Mumbai").build().perform();

      List<WebElement> list_Auto =driver.findElements(By.xpath("//*[@class=\"react-autosuggest__suggestions-list\"]/li"));

      for (WebElement mum : list_Auto){
          if (mum.getText().contains("Mumbai")){
              mum.click();
              break;
          }
      }








    }


            @AfterTest
            public void closeBrowser () {
                driver.quit();
            }
        }
