package GK.Selenium.Exercise;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_11 {
    @Test(groups = "QA")
    @Description("Verify the current URL, and Title of VWo Page")
    public void testVWoLogin() {

         //Project #1 - TC ( Negaative) - Invalid username, pass - Error message**
//
//        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
//        2. **Find the Email id** and enter the email as admin@admin.com
//        3. **Find the pass inputbox** and enter passwrod as admin.
//        4. Find and Click on the submit button
//        5. Verify that the error message is shown "Your email, password, IP address or location did not match"
//

        // 2. **Find the Email id** and enter the email as admin@admin.com
        //  id, className, name, css Selector, xpath
        //  LinkText and PartialText which are onlu for <a>
        // <input
        // type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi">


        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        System.out.println("This is Title of the Page  : "  + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("georgekaseri22@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Hyderabad85");

        WebElement signInButton = driver.findElement(By.id("js-login-btn"));
        signInButton.click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement error_Message = driver.findElement(By.className("notification-box-description"));
        String error_msg_text = error_Message.getText();
        String error_msg_attribute = error_Message.getAttribute("data-qa");
        System.out.println(error_msg_attribute);


        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");



        driver.quit();
    }
}
