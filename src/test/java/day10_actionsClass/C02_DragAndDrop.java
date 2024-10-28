package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Each;

public class C02_DragAndDrop extends TestBase_Each {

    @Test
    public void test03(){

        // 1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);

        WebElement acceptableBox = driver.findElement(By.xpath("//*[text()='Acceptable']"));
        WebElement targetArea = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(acceptableBox, targetArea).perform();

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedText = "Dropped!";
        String actualText = targetArea.getText();

        Assertions.assertEquals(expectedText, actualText);

        // 4- Sayfayi yenileyin
        driver.navigate().refresh();

        // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableBox = driver.findElement(By.id("draggable-nonvalid2"));
        targetArea = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableBox, targetArea).perform();

        // 6- “Drop Here” yazisinin degismedigini test edin
        String expectedText2 = "Drop Here";
        String actualText2 = targetArea.getText();

        Assertions.assertEquals(expectedText2, actualText2);
    }
}
