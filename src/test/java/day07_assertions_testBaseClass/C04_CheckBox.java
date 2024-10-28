package day07_assertions_testBaseClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_All;

public class C04_CheckBox extends TestBase_All {

    // Gerekli yapiyi olusturun ve aşağıdaki göre tamamlayın

    @Test
    public void checkBoxTest(){

        // a. Verilen web sayfasına gidin.
        // https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
        WebElement carpintiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck4']"));

        sirtAgrisiCheckBox.click();
        carpintiYaziElementi.click();

        // c. Sirt Agrisi ve Carpinti checkbox’larininin
        // seçili olduğunu test edin
        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());

        // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());
    }
}
