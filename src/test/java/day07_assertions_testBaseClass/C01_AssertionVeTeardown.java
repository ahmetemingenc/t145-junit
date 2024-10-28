package day07_assertions_testBaseClass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_AssertionVeTeardown {

    // Yapilan islem tek bir test method'unda yapilacak kadar kucuk olsa da
    // teardown() kullanmak daha mantiklidir

    WebDriver driver;

    @BeforeEach
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){

        ReusableMethods.wait(2);
        driver.quit();
    }

    @Test
    public void titleTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Title'in Test Otomasyonu oldugunu test edin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}
