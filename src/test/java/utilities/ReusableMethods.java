package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods extends TestBase_Each {

    public static List<String> convertStringList(List<WebElement> elementList) {

        List<String> stringElementList = new ArrayList<>();

        for (WebElement each : elementList) {

            stringElementList.add(each.getText());
        }

        return stringElementList;
    }

    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    public static void switchToWindowByTitle(WebDriver driver, String title) {

        Set<String> allWindowsWhdSet = driver.getWindowHandles();

        for (String each : allWindowsWhdSet) {

            driver.switchTo().window(each);

            if (driver.getTitle().equals(title)) {
                break;
            }
            ;
        }
    }

    public static void switchToWindowByUrl(WebDriver driver, String url) {

        Set<String> allWindowsWhdSet = driver.getWindowHandles();

        for (String each : allWindowsWhdSet) {

            driver.switchTo().window(each);

            if (driver.getCurrentUrl().equals(url)) {
                break;
            }
            ;
        }
    }

    public String getCellData(int rowNo, int columnNo) {

        String dynamicXpath = "//tbody/tr[" + rowNo + "]/td[" + columnNo + "]";
        WebElement dynamicCellDataElement = driver.findElement(By.xpath(dynamicXpath));

        return dynamicCellDataElement.getText();
    }

    public static void getAllPageScreenShot(WebDriver driver) {

        LocalDateTime localDate = LocalDateTime.now();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String timeLabel = localDate.format(format);

        String filePath = "target/screenshots/allPageScreenshot" + timeLabel + ".png";

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File allPageScreenshot = new File(filePath);

        File tempFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tempFile, allPageScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getWebElementScreenshot(WebDriver driver, WebElement element){

        LocalDateTime localDate = LocalDateTime.now();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String timeLabel = localDate.format(format);

        String filePath = "target/screenshots/webElementSs" + timeLabel + ".png";

        File webElementSs = new File(filePath);

        File tempFile = element.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tempFile, webElementSs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}