package day13_webTables_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        // - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String filePath = "src/test/java/day13_webTables_ExcelAutomation/countries.xlsx";

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sayfa1");

        System.out.println(sheet.getRow(0).getCell(1));

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String secondCellOfFirstRow = sheet.getRow(0).getCell(1).getStringCellValue();

        System.out.println(secondCellOfFirstRow);

        // - 2.satir 4.cell’in Asia oldugunu test edelim
        String expectedCellContent = "Asia";
        String actualCellContent = sheet.getRow(1).getCell(3).getStringCellValue();

        assertEquals(expectedCellContent, actualCellContent);

        // - Satir sayisini bulalim
        int numberOfRows = sheet.getLastRowNum() + 1; // .getLastRowNum() index verir

        System.out.println("Number of rows: " + numberOfRows);

        // - Fiziki olarak kullanilan satir sayisini bulun
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();

        System.out.println("Physical number of rows: " + physicalNumberOfRows);

        // - Greece ulkesinin baskentinin Athens oldugunu test edin
        String countryName = "";
        String capitalName = "";

        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            countryName = sheet.getRow(i).getCell(0).getStringCellValue();
            capitalName = sheet.getRow(i).getCell(2).getStringCellValue();

            if (countryName.equalsIgnoreCase("Greece")){

                assertEquals("Athens", capitalName);
            }
        }

        // - Capital isimlerinde Ankara oldugunu test edin
        boolean flag = false;

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {

            capitalName = sheet.getRow(i).getCell(2).getStringCellValue();

            if (capitalName.equalsIgnoreCase("Ankara")){

                flag = true;
            }
        }

        assertTrue(flag);
    }
}
