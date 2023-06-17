package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_Actions extends TestBase {

    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git  “Account” secenegine tikla
        WebElement accountListWE = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListWE).perform();
        //moveToElement() methodu ile mouse'u istediğimiz webElementin üzerine götürebiliriz
        bekle(2);
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));

    }
}
