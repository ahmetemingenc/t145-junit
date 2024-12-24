package day14_writeExcel_Screenshot_jsExecutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_TakeScreenShot extends TestBase_Each {

    // 3 farkli test method'u olusturun ve asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidin
    //    title'in "Test Otomasyonu" icerdigini test edin ve tum sayfa screenshot alin
    // 2- wisequarter anasayfaya gidin
    //    url'in "wisequarter" icerdigini test edin ve tum sayfa screenshot alin
    // 3- youtube anasayfaya gidin
    //    url'in "youtube" icerdigini test edin ve tum sayfa screenshot alin

    @Test
    public void toTitleTest(){

        driver.get("https://testotomasyonu.com");

        String expectedTitleContent = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleContent));

        ReusableMethods.getAllPageScreenShot(driver);
    }

    @Test
    public void wiseUrlTest(){

        driver.get("https://wisequarter.com");

        String expectedUrlContent = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlContent));

        ReusableMethods.getAllPageScreenShot(driver);
    }

    @Test
    public void youtubeUrlTest(){

        driver.get("https://youtube.com");

        String expectedUrlContent = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlContent));

        ReusableMethods.getAllPageScreenShot(driver);
    }
}
