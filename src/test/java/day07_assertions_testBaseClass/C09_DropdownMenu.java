package day07_assertions_testBaseClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class C09_DropdownMenu extends TestBase_All {

    @Test
    public void singinTest(){

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        WebElement singinButton = driver.findElement(By.id("signin_button"));
        singinButton.click();

        // 3. Login kutusuna “username” yazin
        WebElement loginBox = driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");

        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        WebElement singinSubmitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        singinSubmitButton.click();

        driver.navigate().back();
    }

    @Test
    public void paybillsDropdownTest(){

        // 6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropdownMenu = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropdownMenu);
        select.selectByIndex(6);

        // 9. “amount” kutusuna bir sayi girin
        WebElement amountBox = driver.findElement(By.id("pc_amount"));
        amountBox.sendKeys("10");

        // 10. “US Dollars” in secilmedigini test edin
        WebElement usDollarsRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assertions.assertFalse(usDollarsRadioButton.isSelected());

        // 11. “Selected currency” butonunu secin
        WebElement selectedCurrencyRadioButton = driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrencyRadioButton.click();

        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        WebElement calculateCostsButton = driver.findElement(By.id("pc_calculate_costs"));
        WebElement purchaseButton = driver.findElement(By.id("purchase_cash"));

        calculateCostsButton.click();
        purchaseButton.click();

        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement alertMessageElement = driver.findElement(By.id("alert_content"));
        Assertions.assertTrue(alertMessageElement.isDisplayed());
    }
}
