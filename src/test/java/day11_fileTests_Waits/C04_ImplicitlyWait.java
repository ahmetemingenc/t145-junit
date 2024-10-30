package day11_fileTests_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class C04_ImplicitlyWait extends TestBase_Each {

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com");

        // verilen kelime icin arama yapin
        String verilenKelime = "phone";

        WebElement searchBox = driver.findElement(By.id("global-search"));

        searchBox.sendKeys(verilenKelime);

        // arama sonucunda urun bulunabildigini test edin
        List<WebElement> productElementList = driver.findElements(By.className("prod-img"));
        Assertions.assertTrue(!productElementList.isEmpty());
    }
}
