package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods extends TestBase_Each{

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
        } catch (InterruptedException e) {}
    }

    public static void switchToWindowByTitle(WebDriver driver, String title){

        Set<String> allWindowsWhdSet = driver.getWindowHandles();

        for (String each : allWindowsWhdSet){

            driver.switchTo().window(each);

            if (driver.getTitle().equals(title)){
                break;
            };
        }
    }

    public static void switchToWindowByUrl(WebDriver driver, String url){

        Set<String> allWindowsWhdSet = driver.getWindowHandles();

        for (String each : allWindowsWhdSet){

            driver.switchTo().window(each);

            if (driver.getCurrentUrl().equals(url)){
                break;
            };
        }
    }

    public String getCellData(int rowNo, int columnNo){

        String dynamicXpath = "//tbody/tr[" + rowNo + "]/td[" + columnNo + "]";
        WebElement dynamicCellDataElement = driver.findElement(By.xpath(dynamicXpath));

        return dynamicCellDataElement.getText();
    }
}