package day06_jUnitFramework;

import org.apache.hc.core5.http.protocol.RequestUserAgent;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_OtomatikSonucRaporlama {

     /*
        JUnit bir test method'unun FAILED oldugunu
        o test method'unda exception olusmasiyla anlayabilir

        bugune kadar yaptigimiz gibi
        if-else ile test yaparsak
        kod sorunsuz olarak calisip biitigi icin
        JUnit test'i PASSED olarak algilar

        JUnit ile uyumlu bir sonuc raporu gorebilmek icin
        - ya if-else ile yapip FAILED oldugunda exception firlatacagiz
        - ya da JUnit'in bize verdigi promosyonlardan
          assertion method'larini kullanacagiz
     */

    @Test
    public void titleTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // testotomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com");

        // Title'in Test Otomasyonu oldugunu test edin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED");
            throw new AssertionError("Actual title : " + actualTitle);
        }

        ReusableMethods.wait(2);
        driver.quit();
    }
}
