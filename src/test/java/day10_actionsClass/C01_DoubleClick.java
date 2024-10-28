package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class C01_DoubleClick extends TestBase_Each {

    @Test
    public void test01(){

        // 1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        // 2- “DGI Drones” uzerinde sag click yapin
        Actions actions = new Actions(driver);

        WebElement dgiDronedElement = driver.findElement(By.id("pic2_thumb"));

        actions.contextClick(dgiDronedElement).perform();

        // 3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedAlertText = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertText = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertText, actualAlertText);

        // 4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
    }
}
