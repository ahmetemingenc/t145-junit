package day09_switchingWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_KontrolsuzWindowGecisi extends TestBase_Each {

    @Test
    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        String expectedText = "Add/Remove Elements";
        String actualText = driver.findElement(By.tagName("h2")).getText();

        Assertions.assertEquals(expectedText, actualText);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

        //● Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//a[text()='Electronics Products']")).click();

        //● Electronics sayfasinin acildigini test edin
        ReusableMethods.switchToWindowByTitle(driver, "Test Otomasyonu - Electronics");

        String expectedUrl = "https://testotomasyonu.com/category/7/products";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl, actualUrl);

        //● Bulunan urun sayisinin 16 olduğunu test edin
        String expectedProductNumber = "16";
        String actualProductNumber = driver.findElement(By.xpath("//*[text()='16 Products Found']")).getText();

        Assertions.assertTrue(actualProductNumber.contains(expectedProductNumber));

        //● Ilk actiginiz addremove sayfasinin oldugu window’a donun
        ReusableMethods.switchToWindowByTitle(driver, "Test Otomasyonu");

        //● Url’in addremove icerdigini test edin
        String expectedUrlContent = "addremove";
        String AddRemoveUrl = driver.getCurrentUrl();

        Assertions.assertTrue(AddRemoveUrl.contains(expectedUrlContent));
    }
}
