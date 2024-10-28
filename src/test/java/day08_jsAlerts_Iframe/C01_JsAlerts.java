package day08_jsAlerts_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class C01_JsAlerts extends TestBase_All {

        // 3 test method'u olusturup asagidaki gorevi tamamlayin


    @Test
    public void test01(){
        // 1. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.wait(2);

        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertText, actualAlertText);

        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02(){
        //  2.Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();

        String expectedAlertText = "You clicked: Cancel";
        String actualAlertText = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedAlertText, actualAlertText);
    }

    @Test
    public void test03(){

        // 3.Test
        //- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedAlertText = "Abdullah";
        String actualAlertText = driver.findElement(By.id("result")).getText();

        Assertions.assertTrue(actualAlertText.contains(expectedAlertText));
    }
}
