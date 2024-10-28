package day08_jsAlerts_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class C03_IFrame extends TestBase_All {

    @Test
    public void iframeTest(){

        // Bu class, test sayfası çalışmadığı için iptal

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        // konsolda yazdirin.
        WebElement anIFrameTextElement = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(anIFrameTextElement.isEnabled());

        System.out.println(anIFrameTextElement.getText());

        // - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElement);

        WebElement textBoxElement = driver.findElement(By.tagName("p"));

        textBoxElement.sendKeys("Merhaba Dunya!");

        // - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur
        // oldugunu dogrulayin ve yazisini konsolda yazdirin.
    }
}
