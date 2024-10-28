package day06_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_BeforeVeAfterNotasyonu {

    // 3 farkli test method'u olusturup
    // asagidaki verilen gorevleri yapin

    // 1- Test otomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- Wisequarter anasayfaya gidin ve logonun gorundugunu test edin
    // 3- bestbuy anasayfaya gidin ve title'in Best Buy icerdigini test edin

    /*
        @BeforeEach ve @AfterEach method'lari her bir test method'undan once ve sonra
        otomatik olarak calisir

        Biz bu class'i class level'dan run ettigimizde
        asagidaki method'lar calisir

        setup
        test otomasyonu url testi PASSED
        teardown
        setup
        Wisequarter logo testi PASSED
        teardown
        setup
        Bestbuy title testi PASSED
        teardown
     */


    WebDriver driver;

    @BeforeEach // her test method'undan önce çalış
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach // her test method'undan sonra çalış
    public void teardown(){

        ReusableMethods.wait(2);
        driver.quit();
    }

    @Test
    public void testOtomasyonuTesti(){

        driver.get("https://testotomasyonu.com");

        String expectedUrlContent = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlContent)){
            System.out.println("Test Otomasyonu URL test PASSED");
        } else System.out.println("Test Otomasyonu URL test FAILED");
    }

    @Test
    public void wiseQuarterTesti(){

        driver.get("https://wisequarter.com");

        WebElement wiseLogoElement = driver.findElement(By.xpath("//img[@src=\"https://wisequarter.com/wp-content/uploads/2022/05/wisequarter-logo.png\"]"));

        if (wiseLogoElement.isDisplayed()){
            System.out.println("Wise Quarter logo test PASSED");
        } else System.out.println("Wise Quarter logo test FAILED");
    }

    @Test
    public void bestbuyTesti(){

        driver.get("https://bestbuy.com");

        String expectedTitleContent = "Best Buy";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Best Buy title test PASSED");
        } else System.out.println("Best Buy title test FAILED");
    }
}
