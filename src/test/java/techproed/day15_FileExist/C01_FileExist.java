package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    /** SELENIUM ile biz sadece WebSayfasini test ederiz. Bizim bilgisayarimiza müdahale edemez. !!!!!
     ● Selenium ile windows uygulamalarını test edemiyoruz. Ama test etmek için JAVA kullanabiliriz.
     ● Bilgisayarımızda bir dosya olup olmadığını(exist) kontrol etmek için Java'yı kullanabiliriz

     ○System.getProperty ( "user.dir"); icinde bulunulan
     klasörün yolunu (Path) verir

     ○System.getProperty ( "user.home");
     bilgisayarimizda bulunan user klasörünü verir

     ○Files.exists (Paths.get (filePath)); Bilgisayarınızda
     dosyanın olup olmadığını kontrol eder. Assert islemi icine bunu yazariz.
     */

    @Test
    public void fileExist() { // WebSayfasi ile isimiz olmadigi icin Selenium ile bir isimiz yoktur.

        System.out.println(System.getProperty("user.dir")); // Icinde bulundugumuz projenin dosya yolunu verir.

        System.out.println(System.getProperty("user.home")); // Herkesin bilgisayarindaki farkli olan kismi dinamik olarak verir.

        /**
          SORU : 1
          // Desktop(masaustu)'da bir text dosyası olusturun
          // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
         */

        /*
        Dosyanin bilgisayarimda masaüstünde olup olmadigini JAVA ile test ederiz.
        Cünkü Selenium sadece websayfalarini test eder.
        SELENIUM benim bilgisayarimdaki desktop'a müdahale edemez. !!!!!!
         */

        /**  "C:\Users\User\Desktop\Text.txt"  ---> Masaütündeki dosyanin yolu.*/

        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\User\\Desktop\\Text.txt" ))); // Mevcut mu ?

        /** Daha Dinamik hale getirelim */
        // "C:\Users\User             \Desktop\Text.txt"

        String farkliKisim = System.getProperty("user.home"); // Herkesin bilgisayarinda farkli olan kisimdir.
        String ortakKisim = "\\Desktop\\Text.txt"; // Herkesin bilgisayarinda ortak olan kisimdir.

        String dosyaYolu = farkliKisim + ortakKisim; // dosya yolu olarak iki kismida aldik.

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));






    }
}
