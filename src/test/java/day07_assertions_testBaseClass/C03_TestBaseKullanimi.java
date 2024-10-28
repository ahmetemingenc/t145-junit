package day07_assertions_testBaseClass;

import org.junit.jupiter.api.Test;
import utilities.TestBase_All;

public class C03_TestBaseKullanimi extends TestBase_All {

    @Test
    public void aramaTesti(){

        driver.get("https://testotomasyonu.com");
    }
}
