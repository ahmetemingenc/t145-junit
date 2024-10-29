package day11_fileTests_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExistTest {

    @Test
    public void test01(){

        //day11 package'i içinde random.jpg dosyasının var olduğunu test edin

         /*
            Biz Selenium'da tum islemleri
            olusturdugumuz WebDriver objesi ile yapiyoruz

            adindan da anlasilacagi gibi
            WebDriver Web icin olusturulmustur ve bilgisayarimizdaki dosyalara ERISEMEZ

            Bilgisayarimizdaki dosyalara erismek icin Java'yi kullanacagiz
            Java'nin bilgisayarimizdaki dosyalara ulasmasi icin
            dosya yoluna ihtiyacimiz var
         */

        String filePath = "src/test/java/day11_fileTests_Waits/random.jpg";

        System.out.println(Files.exists(Paths.get(filePath)));

        Assertions.assertTrue(Files.exists(Paths.get(filePath)));
    }

    @Test
    public void test02(){

        // Eğer dosya projemizin içinde değilse

        String filePath = "C:/Users/legen/Downloads/random.jpg";

        Assertions.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
