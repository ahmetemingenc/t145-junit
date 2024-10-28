package day07_assertions_testBaseClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class C06_RadioButtons extends TestBase_Each {

    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    @Test
    public void selectByButton() {

        // a. Verilen web sayfasına gidin.
        // https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // direk buton’dan size uygun olani secin
        erkekRadioButton.click();

        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }

    @Test
    public void selectByText() {

        // a. Verilen web sayfasına gidin.
        // https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // yazıdan size uygun olani secin
        WebElement erkekRadioText = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        erkekRadioText.click();

        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }
}
