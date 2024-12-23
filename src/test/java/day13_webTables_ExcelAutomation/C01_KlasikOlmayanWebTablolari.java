package day13_webTables_ExcelAutomation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;
import java.util.SortedMap;

public class C01_KlasikOlmayanWebTablolari extends TestBase_Each {

    @Test
    public void test01() {

        // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerElementsList = driver.findElements(By.xpath("//*[@role='hdata']"));

        System.out.println(ReusableMethods.convertStringList(headerElementsList));

        // 3. 3.sutunun basligini yazdirin
        System.out.println(headerElementsList.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> allDataElementsList = driver.findElements(By.xpath("//*[@role='tdata']"));

        System.out.println(ReusableMethods.convertStringList(allDataElementsList));

        // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Number of data: " + allDataElementsList.size());

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> allRowElementsList = driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("Number of rows: " + allRowElementsList.size());

        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("Numnber of columns: " + headerElementsList.size());

        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> thirdColumnElementsList = driver.findElements(By.xpath("//*[@role='trow'] /*[@role='tdata'][3]"));

        System.out.println(ReusableMethods.convertStringList(thirdColumnElementsList));

        // 9. Tabloda " Category" si Furniture olan urunun fiyatlarini yazdirin
        // xpath of Category element = //*[@role='trow'] [  *  ]/*[@role='tdata'][2]
        // xpath of Price    element = //*[@role='trow'] [  *  ]/*[@role='tdata'][3]

        for (int i = 1; i <= 5 ; i++) {

            String categoryXpath = "//*[@role='trow'] [" + i + "]/*[@role='tdata'][2]";
            String priceXpath    = "//*[@role='trow'] [" + i + "]/*[@role='tdata'][3]";

            String categoryValue = driver.findElement(By.xpath(categoryXpath)).getText();

            if (categoryValue.equalsIgnoreCase("Furniture")){

                String priceStr = driver.findElement(By.xpath(priceXpath)).getText();

                System.out.println(priceStr);
            }
        }

        // 10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        getData(2,2);

    }

    public void getData(int row, int column){

        String dynamicXpath = "//*[@role='trow'] [" + row + "]/*[@role='tdata'][ "+ column + "]";

        WebElement dynamicDataElement = driver.findElement(By.xpath(dynamicXpath));

        System.out.println(dynamicDataElement.getText());
    }
}