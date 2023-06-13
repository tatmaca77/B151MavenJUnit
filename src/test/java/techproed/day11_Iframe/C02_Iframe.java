package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Iframe extends TestBase {

    /**
       //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
      //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
      //==>  textBox içindeki yazıyı siliniz.
     //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
      //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
     */

    @Test
    public void iframe() {
        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
        WebElement kalinYazi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        String icerik = "Editor";
        Assert.assertTrue(kalinYazi.getText().contains(icerik));

        //==>  textBox içindeki yazıyı siliniz.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        /** 1.YOL  --> WebElement */
        //driver.switchTo().frame(iframe); // iframe locate edildi, switchTo ile icteki website gecildi.

        /** 2.YOL index --> iframe icteki web sayfasina geceriz. */
        //driver.switchTo().frame(0);// iframe tag'i ile baska bir yapi yok unique oldugu icin index 0 dedik.

        /**
           Eger 2 tane iframe olsaydi ve 2. iframe'e gecmek isteseydim index'i 1 yapmaliydim.
         */

        /** 3.YOL --> iframe icteki website geceriz. Eger iframe tag icinde "id" veya "name" attribute varsa kullan. */
        // iframe HTML kod blogunda id veya name attribute'u varsa ; yoksa KULLANILAMAZ !!!!!
        driver.switchTo().frame("mce_0_ifr");  // bu sekilde de gecis yapbiliriz.


        bekle(2);
        WebElement textBox = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear(); // textBox locate edildi ve icindeki silindi.
        bekle(2);

        //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(2);

        //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent(); /// Yazi distaki webSite'da oldugu icin driver'i disa gecirirz.
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());

        /**
          Ic ice bir cok Web Sayfasi varsa eger defaultContent() yerine parentFrame() kullanmaliyiz.
         */



    }
}
