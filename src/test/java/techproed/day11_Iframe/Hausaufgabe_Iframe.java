package techproed.day11_Iframe;

import io.netty.handler.ssl.IdentityCipherSuiteFilter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class Hausaufgabe_Iframe extends TestBase {

    /**
    ● Bir class olusturun: IframeOdev
1)https://the-internet.herokuapp.com/iframe sitesine gidiniz
2) sayfadaki toplam iframe sayısını bulunuz.
3) Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
4) Paragrafdaki yaziyi silelim
5) Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
6) Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
     */

    @Test
    public void iframe() {
        // 1) https://the-internet.herokuapp.com/iframe sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2) sayfadaki toplam iframe sayısını bulunuz.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe); // Önce iframe locate edilir.

        // 4) Paragrafdaki yaziyi silelim
        WebElement textBox = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear(); // textBox locate edildi ve icindeki silindi.
        bekle(2);

        // 5) Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        textBox.sendKeys("iframein icindeyim");

        // 3) Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        driver.switchTo().defaultContent();
        WebElement editor = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(editor.getText().contains("Editor"));
        bekle(2);

        // 6) Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        String elementalSelenium2 = "Elemental Selenium";
        Assert.assertTrue(elementalSelenium.getText().contains(elementalSelenium2));





    }
}
