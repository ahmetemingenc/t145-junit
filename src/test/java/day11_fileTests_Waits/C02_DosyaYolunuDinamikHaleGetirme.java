package day11_fileTests_Waits;

import org.junit.jupiter.api.Test;

public class C02_DosyaYolunuDinamikHaleGetirme {

    @Test
    public void test01(){

          /*
            Bir ekiple calistigimizda
            olusturulan testlerin her ortamda calismasi beklenir

            File testlerinde dosya yolu onemli oldugundan
            dosya yolunu dinamik hale getirmek icin
            Java'dan yardim aliriz
         */

        // 1- Bilgisayarın ana dosya yolu için
        System.out.println(System.getProperty("user.home"));

        // 2- İçinde olduğumuz proje yolu
        System.out.println(System.getProperty("user.dir"));
    }
}
