package day09_switchingWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C03_KontrolsuzAcilanWindowlarArasiGecis extends TestBase_Each {

    @Test
    public void test01(){

 //     https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

 //     Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();

        Assertions.assertEquals(expectedText, actualText);

 //     Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

 //     Click Here butonuna basın.

         /*
            Kontrolsuz bir window acildiginda
            driver bunu bilemeyecegi icin eski window'da kalir

            Yeni acilan window'un WHD'ini bilmiyoruz
            yeni window'un WHD'ini almak icin once yeni window'a gecmeliyiz
            AMMA yeni window'a gecmek icin de WHD'ini bilmemiz gerekiyor

            Burada imdadimiza Zor gunlerin dostu,
            gariplerin kahramani Java yetisir
         */

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        Set<String> allWindowsWhdSet = driver.getWindowHandles();

         /*
            yukardaki allWindowsWhdSet'de 2 tane WHD var
            bunlardan biri 18.satirda kaydettigimiz windowsWhd ile ayni deger,
            digeri farkli bir deger

            biz bir for each loop ile
            Set'deki WHD'lerini gozden gecirip
            windowsWhd'e esit olmayani 2.windowun WHD'i olarak atayabiliriz
         */

 //     Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        ReusableMethods.switchToWindowByTitle(driver, "New Window");

        String expectedTitle2 = "New Window";
        String actualTitle2 = driver.getTitle();

        Assertions.assertEquals(expectedTitle2, actualTitle2);

 //     Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedText2 = "New Window";
        String actualText2 = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();

        Assertions.assertEquals(expectedText2, actualText2);

 //     Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin
        ReusableMethods.switchToWindowByTitle(driver, "The Internet");

        String actualTitle3 = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle3);
    }
}
