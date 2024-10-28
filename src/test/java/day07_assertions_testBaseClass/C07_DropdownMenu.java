package day07_assertions_testBaseClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_All;
import utilities.TestBase_Each;

import java.util.List;

public class C07_DropdownMenu extends TestBase_All {

    @Test
    public void dropdownMenuTest(){

        // https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        // 1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        WebElement gunDropdownMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        Select selectGun = new Select(gunDropdownMenu);
        selectGun.selectByIndex(5);

        int a = 5;

        System.out.println("ahmet");


        // 2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDropdownMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));

        Select selectAy = new Select(ayDropdownMenu);
        selectAy.selectByValue("nisan");

        // 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDropdownMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

        Select selectYil = new Select(yilDropdownMenu);
        selectYil.selectByVisibleText("1990");

        // 4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        // 5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayDropdownMenuTumOpElementleriList = selectAy.getOptions();

        System.out.println(ReusableMethods.convertStringList(ayDropdownMenuTumOpElementleriList));

        // 6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedSize = 13;
        int actualSize = ayDropdownMenuTumOpElementleriList.size();

        Assertions.assertEquals(expectedSize, actualSize);
    }
}
