package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_MoveToElement extends TestBase_Each {

    @Test
    public void test03(){

        // 1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);

        WebElement kidsWearMenuElement = driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"));

        actions.moveToElement(kidsWearMenuElement).perform();

        // 3- “Boys” linkine basin
        driver.findElement(By.xpath("//*[text()='Boys']")).click();

        // 4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // 4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        WebElement productNameElement = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedProductName = "Boys Shirt White Color";
        String actualProductName = productNameElement.getText();

        Assertions.assertEquals(expectedProductName, actualProductName);
    }
}
