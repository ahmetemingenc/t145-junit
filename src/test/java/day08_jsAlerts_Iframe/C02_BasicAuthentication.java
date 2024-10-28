package day08_jsAlerts_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C02_BasicAuthentication extends TestBase_Each {

    @Test
    public void test01(){
        // 1- https://testotomasyonu.com/basicauth sayfasina gidin
        // driver.get("https://testotomasyonu.com/basicauth");
        // 2- asagidaki yontem ve test datalarini kullanarak
        // authentication’i yapin
        // Html komutu : https://username:password@URL
        // Username : membername
        // password : sunflower

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        // 3- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement congratulationsText = driver.findElement(By.tagName("i"));
        Assertions.assertTrue(congratulationsText.isDisplayed());
    }
}
