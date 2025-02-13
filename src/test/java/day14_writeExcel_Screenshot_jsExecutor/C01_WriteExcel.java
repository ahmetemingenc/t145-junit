package day14_writeExcel_Screenshot_jsExecutor;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        // 1) Yeni bir Class olusturalim WriteExcel
        // 2) Yeni bir test method olusturalim writeExcelTest()
        // 3) Adimlari takip ederek Sayfa1’deki 1.satira kadar gidelim
        String filePath = "src/test/java/day13_webTables_ExcelAutomation/countries.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sayfa1");

        // 4) 5.hucreye yeni bir cell olusturalim
        sheet.getRow(0).createCell(4);

        // 5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sheet.getRow(0).getCell(4).setCellValue("Nüfus");

        // 6) 2.satir nufus kolonuna 1500000 yazdiralim
        sheet.getRow(1).createCell(4).setCellValue(1500000);

        // 7) 10.satir nufus kolonuna 250000 yazdiralim
        sheet.getRow(9).createCell(4).setCellValue(250000);

        // 8) 15.satir nufus kolonuna 54000 yazdiralim
        sheet.getRow(14).createCell(4).setCellValue(54000);

        // 9) Dosyayi kaydedelim
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

        // 10)Dosyayi kapatalim
        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();
    }
}
