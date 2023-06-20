package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions extends TestBase{

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        /** Sağ klik yapabilmek için öncelikle Actions class'ından bir obje oluşturmalıyız */

        Actions actions = new Actions(driver);
        actions.contextClick(kutu).//sağ klik yapma methodu kullandık.argüman olarak we'tin locate'ini yazdık
                perform();//actions objemizle yapacağımız işlemi uygulaması için veya sonlandırması için perform() kullanırız.
        bekle(2);

        //Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
        Assert.assertEquals("You selected a context menu",getTextAlert());
        //TestBase deki getTextAlert() methodu kullandık --> driver.switchTo().alert().getText();
        bekle(2);

        //Tamam diyerek alert’i kapatın
        acceptAlert();//-->TestBase deki methodu kullandık --> driver.switchTo().alert().accept()

        /** contextClick() ==> methodu mouse'da sag tiklamamiza yarar. */
    }
}
