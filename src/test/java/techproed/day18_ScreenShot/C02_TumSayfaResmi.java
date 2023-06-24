package techproed.day18_ScreenShot;

import techproed.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_TumSayfaResmi extends TestBase {

    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        // FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        /**
        FileUtils yerine daha önce ögrendigimiz Files Class'i ile yapabiliriz. !!!!

         FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu)); ****** 1.YOLU ****
                        ===============
         Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));  ******  2.YOLU ****
         */
    }
}
