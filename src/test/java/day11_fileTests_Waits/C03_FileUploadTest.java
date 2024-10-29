package day11_fileTests_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C03_FileUploadTest extends TestBase_Each {

    @Test
    public void test01(){

         /*
            Eger chooseFile butonuna basarsak
            bilgisayarimizdan dosya secmemiz gerekir
            AMMA WebDriver bilgisayarimizdan dosya secemez

            bu durumda Selenium'un cozumunu kullanacagiz

            Cozum :  chooseFile butonunu locate edip
                     bir WebElement olarak kaydedecegiz
                     sonra yuklemek istedigimiz dosyanin
                     dinamik dosya yolunu chooseFile butonuna sendKeys() ile yollayacagiz
         */

        // 1. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // 2. chooseFile butonuna basalim
        // 3. Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        String dynamicFilePath = System.getProperty("user.home") + "/Downloads/random.jpg";

        chooseFileButton.sendKeys(dynamicFilePath);

        // 4. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        // 5. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedText = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));

        Assertions.assertTrue(fileUploadedText.isDisplayed());
    }
}
