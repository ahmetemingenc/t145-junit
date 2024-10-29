package day10_actionsClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C07_FakeBilgilerleFormDoldurma extends TestBase_Each {

    @Test
    public void test01(){

        Faker faker = new Faker();
        String password = faker.internet().password();
        String email = faker.internet().emailAddress();
;
        // 1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        // 2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[text()='Account'])[1]")).click();

        // 3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();

        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstNameBoxElement = driver.findElement(By.id("firstName"));
        WebElement signUpButtonElement = driver.findElement(By.id("btn-submit-form"));

        Actions actions = new Actions(driver);

        ReusableMethods.wait(1);

        actions.click(firstNameBoxElement)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(password).sendKeys(Keys.TAB)
                .sendKeys(password).perform();

        ReusableMethods.wait(1);

        signUpButtonElement.click();

        // 5- Kaydin olusturuldugunu test edin
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement signInButton = driver.findElement(By.id("submitlogin"));

        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        signInButton.click();

        WebElement logoutButton = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assertions.assertTrue(logoutButton.isDisplayed());
    }
}
