package day14_writeExcel_Screenshot_jsExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C06_JavaScriptExecutor extends TestBase_Each {

    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com/form");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement hastaliklarTextBox = driver.findElement(By.id("diger-hastalik"));

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", hastaliklarTextBox);

        hastaliklarTextBox.sendKeys("Hello World!");

        ReusableMethods.wait(2);

        jse.executeScript("alert('Hello World!');");
    }
}
