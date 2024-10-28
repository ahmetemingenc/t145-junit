package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_JUnitTestNotasyonu {

    // 3 farkli test yapmak istiyoruz
    // ancak testler bagimsiz olarak da calistirilabilmelidir

    // Bu class'a kadar
    // "Run edilebilir bir class olusturmak icin main method gereklidir" DIYORDUK

    // Framework'ler sadece calisma duzeni demek degildir
    // bize ekstra kolayliklar da saglar
    // JUnit'in bize sagladigi ILK ve en ONEMLI kolaylik @Test notasyonudur

    // Notasyonlar kucuk bilgiler (Meta data) barindiran ozel yapilardir
    // diger bir deyisle, belirli bir gorevi gerceklestirmek icin olusturulan ozel yapilardir


    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com");

        ReusableMethods.wait(2);
        driver.quit();
    }

    @Test
    public void test02(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://wisequarter.com");

        ReusableMethods.wait(2);
        driver.quit();
    }

    @Test
    public void test03(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://youtube.com");

        ReusableMethods.wait(2);
        driver.quit();
    }
}
