package day09_switchingWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class C01_Window_SayfaKarsilastirmasi extends TestBase_Each {

    @Test
    public void test01(){

        // testotomasyonu ana sayfaya gidin ve window handle değerini yazdırın
        driver.get("https://testotomasyonu.com/");
        System.out.println(driver.getWindowHandle());

        String toWhd = driver.getWindowHandle();

        // wisequarter sayfasına gidin ve window handle değerinin değişmediğini test edin

        String wiseWhd = driver.getWindowHandle();

        Assertions.assertEquals(toWhd, wiseWhd);
    }
}
