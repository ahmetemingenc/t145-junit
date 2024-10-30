package day11_fileTests_Waits;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C06_ExplicitlyWait {

    WebDriver driver = new ChromeDriver();

    @Test
    public void implicitlyWaitTest(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       // 2. Remove butonuna basin.
       driver.findElement(By.xpath("//*[text()='Remove']")).click();

       // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneTextElement = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsGoneTextElement.isDisplayed());

       // 4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

       // 5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackTextElement = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsBackTextElement.isDisplayed());
    }

    @Test
    public void explicitlyWaitTest(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // bu element gorunmedigi icin locate edemiyoruz
        // bu durumda locate ve wait islemini (2.ve 3.adimlari) birlestiriyoruz

        WebElement itsGoneTextElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));

        Assertions.assertTrue(itsGoneTextElement.isDisplayed());

        // 4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackTextElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));

        Assertions.assertTrue(itsBackTextElement.isDisplayed());
    }

    @AfterEach
    public void teardown(){
        ReusableMethods.wait(2);
        driver.quit();
    }
}
