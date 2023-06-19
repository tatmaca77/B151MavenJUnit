package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    /**
    //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
   //"b10 all test cases" dosyasını indirin
   // Dosyanın başarıyla indirilip indirilmediğini test edin.
     */

    @Test
    public void fileDownload() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);


        //   C:\Users\User\Downloads\b10 all test cases, code.docx
        File silinecekDosya = new File("C:\\Users\\User\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

        /**
        Eger localinizden otomasyon ile bir dosya silmek istiyorsak File class'indan obje olusturup dosya yolunuzu
        icine yerlestirirz. Ve olusturdugumuz obje ile delete() methodu ile o dosyayi silebiliriz.

         Her calistiginda yeni bir dosya indirilecegi icin dosya kalbaligi olusur.
         Ayni zamanda dogrulama yaparken garanti olur.
         Bu bize her zaman bilgisayarimizdan bu dosyadan 1 tane olmasina yardimci olur. !!!!

         Ayni isimde birden fazla dosya indirmis olsak da her indirilenin yanina index verecegi icin
         ve bizim ilk indirdigimiz o klasörün icinde bulamayacagi icin her zaman ilk dosyanin varligini test ederiz.

         */

        //"b10 all test cases" dosyasını indirin
        driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']")).click();
        bekle(5); // Indirme islemi uzun sürebilir. !!!!!!

        // Dosyanın başarıyla indirilip indirilmediğini test edin.

        // "C:\Users\User             \Downloads\b10 all test cases, code.docx"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\b10 all test cases, code.docx";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
