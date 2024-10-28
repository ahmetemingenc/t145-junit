package day07_assertions_testBaseClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_All;

import java.util.List;

public class C08_DropdownMenu extends TestBase_All {

    @Test
    public void dropdownMenuTest(){

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.id("dropdown"));

        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> dropdownMenuAllOpElementList = select.getOptions();
        System.out.println(ReusableMethods.convertStringList(dropdownMenuAllOpElementList));

        // 5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedSize = 4;
        int actualSize = dropdownMenuAllOpElementList.size();

        Assertions.assertEquals(expectedSize, actualSize);
    }

}
