package day14_writeExcel_Screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C05_WebElementScreenshot extends TestBase_Each {

    @Test
    public void searchTest() throws IOException {

        driver.get("https://testotomasyonu.com");

        String expectedUrlContent = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlContent));

        ReusableMethods.wait(1);

        ReusableMethods.getAllPageScreenShot(driver);

        WebElement searchBox = driver.findElement(By.id("global-search"));

        searchBox.sendKeys("phone" + Keys.ENTER);

        WebElement resultTextElement = driver.findElement(By.className("product-count-text"));
        String resultText = resultTextElement.getText();

        Assertions.assertTrue(resultText.charAt(0) != '0');

        ReusableMethods.wait(1);

        ReusableMethods.getWebElementScreenshot(driver, resultTextElement);

        driver.findElement(By.xpath("(//*[@class='prod-title mb-3 '])[1]")).click();

        WebElement productNameElement = driver.findElement(By.xpath("(//*[@class=' heading-sm mb-4'])[1]"));

        String expectedProductNameContent = "phone";
        String actualProductName = productNameElement.getText().toLowerCase();

        Assertions.assertTrue(actualProductName.contains(expectedProductNameContent));

        ReusableMethods.wait(1);

        ReusableMethods.getWebElementScreenshot(driver, productNameElement);
    }
}
