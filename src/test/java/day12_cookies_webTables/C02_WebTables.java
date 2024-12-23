package day12_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C02_WebTables extends TestBase_Each {

    @Test
    public void test01(){

        // 1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        // 2.Web table tum body’sini yazdirin
        WebElement allBodyElement = driver.findElement(By.tagName("tbody"));

        // 3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String actualAllBodyText = allBodyElement.getText();
        String expectedTableContent = "Comfortable Gaming Chair";

        Assertions.assertTrue(actualAllBodyText.contains(expectedTableContent));

        // 4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> lineElementsList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedNumberOfLines = 5;
        int actualNumberOfLines = lineElementsList.size();

        Assertions.assertEquals(expectedNumberOfLines, actualNumberOfLines);

        // 5. Tum satirlari yazdirin
        System.out.println(ReusableMethods.convertStringList(lineElementsList));

        // 6. Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> firstLineElementsList = driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedNumberOfRows = 4;
        int acutalNumberOfRows = firstLineElementsList.size();

        Assertions.assertEquals(expectedNumberOfLines, actualNumberOfLines);

        // 7. 3.sutunu yazdirin
        List<WebElement> thirdRowElementsList = driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));

        System.out.println(ReusableMethods.convertStringList(thirdRowElementsList));

        // 8. Tablodaki basliklari yazdirin
        System.out.println(driver.findElement(By.tagName("thead")).getText());

        // 9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(getCellData(2, 3));

        // 10. 4. satirdaki category degerinin "Furniture" oldugunu test edin
        String expectedCategoryName = "Furniture";
        String actualCategoryName = getCellData(4,2);

        Assertions.assertEquals(expectedCategoryName, actualCategoryName);
    }


    public String getCellData(int lineNo, int rowNo){

        String dynamicXpath = "//tbody/tr[" + lineNo + "]/td[" + rowNo + "]";
        WebElement dynamicCellDataElement = driver.findElement(By.xpath(dynamicXpath));

        return dynamicCellDataElement.getText();
    }
}
