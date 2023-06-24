package techproed.day18_ScreenShot;

import techproed.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import techproed.utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEresmi extends TestBase {

    /**
     Bir webelementin resmini almak için önce Webelementi "locate" edip bir webelemente assing ederiz.
    ve bu webelementi direk "getScreenShotAs()" methodunu kullanarak resmini belirttimiz dosyaya kaydederiz.
     */
    @Test
    public void name() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);

        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")); // Locate al
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // Her seferinde ayri ayri yazmasi icin tarih belirtim.
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg"; // Nereye ve Ne türde kayit edeyim ?
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu)); // Son adim Kayit islemi yaptim.

        /**
         FileUtils.copyFile sonucYazisi.getScreenshotAs(OutputType.FILE) ==> Ne olarak kayit edeyim ? oder Nasil kayit edeyim ?

        ,new File(dosyaYolu)) ==> Nereye kayit edeyim ?
         */

        /**
        Yani aslinda biz burda hem sonucYazisinin testini yapmis oluruz; hem de onun kaniti olarak
        ekran görüntüsünü almis oluruz. !!!!!!
         */
    }
}
