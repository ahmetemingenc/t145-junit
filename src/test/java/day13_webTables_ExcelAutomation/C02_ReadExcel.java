package day13_webTables_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // Ulkeler excelinde Sayfa1'in 2.satirindaki 2.datayi yazdirin

        // Selenium bilgisayarimizda olan excel'e ulasamaz
        // excel'e ulasmak icin Java'yi kullanacagiz

        String filePath = "src/test/java/day13_webTables_ExcelAutomation/countries.xlsx";

        FileInputStream fileInputStream = new FileInputStream(filePath);

        // Excel ozel bir yapiya sahiptir
        // bir excel workbook'da farkli sheet(sayfa)'ler
        // her sayfada row(satir)'lar ve her satir'da cell(hucre)'ler var

        // yukledigimiz apache poi sayesinde
        // excel'deki yapinin aynisini kod dunyamizda olusturabiliriz

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sayfa = workbook.getSheet("Sayfa1"); // parametre olarak yazilan sayfa ismi
                                                       // excel'de gorunen hali olmalidir

        Row row = sayfa.getRow(1); // index

        Cell cell = row.getCell(1); // index

        System.out.println("2. cell of 2. row: " + cell);
    }
}
