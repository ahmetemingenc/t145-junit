package day09_switchingWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase_Each;

public class C02_YeniWindowOlusturma extends TestBase_Each {

  /*
            Biz testlerimiz sirasinda pek cok kere
            bir webelementi tiklayabiliriz

            NORMAL OLARAK bir web elementi tikladigimizda
            yeni bir window acilmaz
            ayni window'da farkli bir URL'e sahip olan
            baska bir sayfaya yonlendiriliriz

            EGER yeni bir window acarak
            acilan yeni window'da bir sayfaya gitmemiz istenirse

           driver.switchTo().newWindow() kullanabiliriz.

           yeni window'u driver'a actirdigimiz icin
           driver otomatik olarak yeni window'a gecer

           EGER test sirasinda eski window'lara donmemiz gerekecekse
           gectigimiz her window'un window handle degerini kaydederiz
           ve sonra bu WHD'lerini kullanarak
           istenen window'a gecis yapariz

         */

    @Test
    public void test01(){

        // testotomasyonu ana sayfaya gidin
        driver.get("https://testotomasyonu.com");

        // whd'ini kaydedin ve yazdırın
        String toWhd = driver.getWindowHandle();

        System.out.println("Test Otomasyonu WHD: " + toWhd);

        // yeni bir tab'da wisequarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");

        // whd'ini kaydedin ve yazdırın
        String wiseWhd = driver.getWindowHandle();
        System.out.println("Wise WHD: " + wiseWhd);

        // yeni bir window açıp testotomasyonu sayfasina gidip electronics linkine tıklayın
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://testotomasyonu.com");

        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

        // whd'ini kaydedin ve yazdirin
        String toNewWindowWhd = driver.getWindowHandle();
        System.out.println("Test Otomasyonu New Window WHD: " + toNewWindowWhd);

        // testotomasyonu anasayfanin açık olduğu window'a dönün
        driver.switchTo().window(toWhd);

        // title'ın Test Otomasyonu - Test Otomasyonu olduğunu test edin
        String expectedTitle = "Test Otomasyonu - Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

        // wisequarter ana sayfanın açık olduğunu window'a gidin
        driver.switchTo().window(wiseWhd);

        // url'in https://www.wisequarter.com/ olduğunu test edin
        String expectedUrl = "https://www.wisequarter.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}
