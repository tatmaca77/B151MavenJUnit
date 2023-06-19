package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileUpload extends TestBase {

    /**
    // masaustunde bir deneme dosyası olusturun
// 'https://the-internet.herokuapp.com/upload' adresine gidiniz
// 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
// 'Upload' butonuna basın
// 'File Uploaded!' yazısının goruntulendigini test edin
     */

    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dateiAuswählen = driver.findElement(By.xpath("//input[@id='file-upload']"));
        bekle(2);

        //dateiAuswählen.sendKeys("C:\\Users\\User\\Desktop\\deneme.txt");
        /** Bunu dinamik olarak yapmaliyim. */

        String farkliKisim = System.getProperty("user.home");
        System.out.println("Farkli Kisim : " + farkliKisim);
        String ortakKisim ="\\Desktop\\deneme.txt";

        String dosyaYolu = farkliKisim + ortakKisim;
        dateiAuswählen.sendKeys(dosyaYolu);
        bekle(4);

        /**
        click() methodunu kullanmamliyim; cünkü dosya sec butonuna basinca benim bilgisayarima erisim dosyalari cikar
                Ancak SELENIUM benim pc'me müdahale edemez. Bu yüzden click gereksiz,
                "sendKeys()" ile direkt dosyaYolunu göndeririz.
         */

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        bekle(2);

        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement message = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(message.isDisplayed());
    }
}
