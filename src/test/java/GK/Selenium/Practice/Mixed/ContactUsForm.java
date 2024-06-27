package GK.Selenium.Practice.Mixed;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactUsForm {
    @Test
    @Description("Immigration Contact form")
    public void contactFrom() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://visascentral.com/");

        Thread.sleep(8000);

        WebElement nameInputBox = driver.findElement(By.xpath("//input[@name=\"fullname\"]"));
        nameInputBox.sendKeys("Hasan Ali");

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        emailInputBox.sendKeys("hasanalimohammed23@gmail.com");

        WebElement telephoneInputBox = driver.findElement(By.xpath("//input[@type=\"tel\"]"));
        telephoneInputBox.sendKeys("123345654366");

        WebElement mesg = driver.findElement(By.xpath("//input[@name=\"text-948\"]"));
        mesg.sendKeys("Hello there  Iam interested in Canada Pr Process Kindly contact me ");



        WebElement sentBtn = driver.findElement(By.xpath("//input[@value=\"Send\"]"));
        sentBtn.click();


        driver.quit();

    }
}
