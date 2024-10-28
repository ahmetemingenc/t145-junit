package day06_jUnitFramework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C03_BeforeVeAfterNotasyonlari {

    /*
            1- JUnit test method'larini kafasina gore calistirir
               Hangi test method'unun once calisacagini ON GOREMEYIZ
               ve KONTROL EDEMEYIZ
            2- Eger sira bizim icin onemli ise
               test method'larinin isimlerini
               method01, method02,... seklinde verirsek
               bu siralamaya uygun calistirir
            3- test01'de anasayfaya gidip url testini yaptiktan sonra driver'i kapatirsak
               test02 calistiginda phone icin ARAMA YAPAMAZ
            4- Bu tur birbirine bagimli test method'lari oldugunda
               en basta setup calismali, tum test method'lari calisip bittikten sonra
               teardown devreye girmeli
            5- JUnit bu modeli @BeforeAll ve @AfterAll ile gerceklestirir
               ANCAKKK bu notasyonlari kullanan method'larin
               MECBUREN static olmasi gerekir


     */

    // 3 farkli test method'u olusturun ve asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidin ve url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin
    // 3- bulunan urunlerden ilkini tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan phone gectigini test edin


    List<WebElement> foundProductList;

    static WebDriver driver;

    @BeforeAll // her test method'undan önce çalış
    public static void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll // her test method'undan sonra çalış
    public static void teardown(){

        ReusableMethods.wait(2);
        driver.quit();
    }

    @Test
    public void test01(){

        driver.get("https://testotomasyonu.com");

        String expectedUrlContent = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlContent)){
            System.out.println("Home URL test PASSED");
        } else System.out.println("Home URL test FAILED");
    }

    @Test
    public void test02(){

        WebElement searchBox = driver.findElement(By.id("global-search"));

        searchBox.sendKeys("phone" + Keys.ENTER);

        foundProductList = driver.findElements(By.className("prod-img"));

        if (foundProductList.size() > 0){
            System.out.println("Found product test PASSED");
        } else System.out.println("Found product test FAILED");
    }

    @Test
    public void test03(){

        foundProductList = driver.findElements(By.className("prod-img"));foundProductList = driver.findElements(By.className("prod-img"));
        foundProductList.get(0).click();

        WebElement productNameElement = driver.findElement(By.xpath("//div[@class=\" heading-sm mb-4\"]"));

        String expectedProductNameContent = "phone";
        String actualProductNameLowerCase = productNameElement.getText().toLowerCase();

        if (actualProductNameLowerCase.contains(expectedProductNameContent)){
            System.out.println("Product name test PASSED");
        } else System.out.println("Product name test FAILED");
    }
}
