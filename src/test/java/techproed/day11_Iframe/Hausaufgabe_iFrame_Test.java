package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class Hausaufgabe_iFrame_Test extends TestBase {

    /**
      ● Bir class olusturun: IframeTest
      ● https://the-internet.herokuapp.com/iframe adresine
        gidin.
      ● Bir metod olusturun: iframeTest
      ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
         konsolda yazdirin
      ○Text Box’a “Merhaba Dunya!” yazin.
      ○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
        oldugunu dogrulayin ve konsolda yazdirin
     */

    @Test
    public void iframeTest() {
        //https://the-internet.herokuapp.com/iframe adresine
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsola yazdirin.
        WebElement yazi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        System.out.println("Yazi : " + yazi.getText());
        Assert.assertTrue(yazi.isEnabled());

        // ○Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe); // Önce iframe locate edilir.
        bekle(2);

        WebElement textBox = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear(); // Sonra ic web sayfasina girildikten sonra istenilen webelement locate edilip islem yapilir.
        bekle(2);

        textBox.sendKeys("Merhaba Dunya!");
        bekle(2);

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur  oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent(); // Yazi distaki webSite'da oldugu icin driver'i disa gecirirz.
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        System.out.println("Yazi : " + elementalSelenium.getText());

        Assert.assertTrue(elementalSelenium.isDisplayed());



    }
}
