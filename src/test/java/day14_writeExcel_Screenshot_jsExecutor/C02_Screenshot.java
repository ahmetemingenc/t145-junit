package day14_writeExcel_Screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C02_Screenshot extends TestBase_Each {

    @Test
    public void searchTest() throws IOException {

        driver.get("https://testotomasyonu.com");

        WebElement searchBox = driver.findElement(By.id("global-search"));

        searchBox.sendKeys("Java" + Keys.ENTER);

        String expectedResult = "0 Products Found";
        String actualResult = driver.findElement(By.className("product-count-text")).getText();

        Assertions.assertEquals(expectedResult, actualResult);

        String filePath = "target/screenshots/allPageScreenshot.png";

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File allPageScreenshot = new File(filePath);

        File tempFile = screenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(tempFile, allPageScreenshot);
    }
}
