package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_FormDoldurma extends TestBase_Each {

    @Test
    public  void test01(){

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
                .sendKeys("Ahmet Emin").sendKeys(Keys.TAB)
                .sendKeys("Genc").sendKeys(Keys.TAB)
                .sendKeys("ahmetemingenc8@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("Sifre.deneme123").sendKeys(Keys.TAB)
                .sendKeys("Sifre.deneme123").perform();

        ReusableMethods.wait(1);

        signUpButtonElement.click();

        // 5- Kaydin olusturuldugunu test edin
        // kayit icin alanlari doldurup sign up butonuna basinca bizi sign in ekranina yonlendirdi
        // kaydin olusturuldugunu anlamak icin giris yapabiliriz

        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement signInButton = driver.findElement(By.id("submitlogin"));

        emailBox.sendKeys("ahmetemingenc8@gmail.com");
        passwordBox.sendKeys("Sifre.deneme123");
        signInButton.click();

        WebElement logoutButton = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assertions.assertTrue(logoutButton.isDisplayed());
    }
}
