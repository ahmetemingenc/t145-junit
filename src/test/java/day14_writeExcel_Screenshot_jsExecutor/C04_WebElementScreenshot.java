package day14_writeExcel_Screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C04_WebElementScreenshot extends TestBase_Each {

    @Test
    public void searchTest() throws IOException {

        driver.get("https://testotomasyonu.com");

        WebElement searchBox = driver.findElement(By.id("global-search"));

        searchBox.sendKeys("Java" + Keys.ENTER);

        String expectedResult = "0 Products Found";
        String actualResult = driver.findElement(By.className("product-count-text")).getText();

        Assertions.assertEquals(expectedResult, actualResult);

        String filePath = "target/screenshots/webElementScreenshot.png";

        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));

        File webElementSs = new File(filePath);

        File tempFile = searchResultElement.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(tempFile, webElementSs);
    }
}
