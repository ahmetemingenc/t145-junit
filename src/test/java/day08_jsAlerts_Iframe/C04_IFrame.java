package day08_jsAlerts_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

import java.util.List;

public class C04_IFrame extends TestBase_All {

    @Test
    public void test01(){
        // 1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        // 2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));

        driver.switchTo().frame(electronicsIFrame);

        WebElement electronicsProductsTextElement =
                driver.findElement(By.xpath("//h2[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsTextElement.isDisplayed());

        // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellComputerElement =
                driver.findElement(By.xpath("//span[text()='DELL Core I3 11th Gen ']"));

        String expectedDellComputerName = "DELL Core I3 11th Gen";
        String actualDellComputerName = dellComputerElement.getText();

        Assertions.assertEquals(expectedDellComputerName, actualDellComputerName);

        // 4- sag bölümde, bölüm ismi olan 'Fashion' yazisinin görünür olduğunu test edin
        driver.switchTo().defaultContent();
        // eğer iç içe birden fazla iframe varsa en üstteki ana sayfaya götürür
        // driver.switchTo().parentFrame();
        // eğer iç içe birden fazla iframe varsa bir üstteki iframe ye götürür

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[2]"));

        driver.switchTo().frame(fashionIFrame);

        WebElement fashionSectionTextElement = driver.findElement(By.xpath("//h2[text()='Fashion']"));

        Assertions.assertTrue(fashionSectionTextElement.isDisplayed());

        // 5- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin
        List<WebElement> productNameList = driver.findElements(By.tagName("p"));

        int counter = 0;

        for (WebElement eachElement : productNameList){

            if (eachElement.getText().contains("Men Slim Fit")){
                counter++;
            }
        }

        Assertions.assertTrue(counter > 0);

        // 6- ‘Here are some products’ yazisinin gorunur olduğunu test edin
        driver.switchTo().defaultContent();

        WebElement hereAreTextElement = driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assertions.assertTrue(hereAreTextElement.isDisplayed());

        // 7- Sayfayi kapatin
    }
}
