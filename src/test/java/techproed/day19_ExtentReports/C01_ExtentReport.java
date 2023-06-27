package techproed.day19_ExtentReports;

import techproed.utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {

    /**
  EXTENTREPORT;
     1- ExtentReport(aventstack) kullanabilmek için öncelikle mvn adresinden 4.0.9 versiyon numaralı
  dependency'i pom.xml dosyamıza ekleriz.
     2- ExtentReports class'ından class seviyeninde obje oluştururuz
     3- ExtentHtmlReporter class'ından class seviyeninde obje oluştururuz
     4- ExtentTest class'ından class seviyeninde obje oluştururuz

     --> Genelde INTERVIEW'da ExtentReport Syntax'ini sormazlar. Evet kullandim dersin.
         Ve bu ExtentReport == JUnit,TestNG, Cucumber'da falan da kullanabiliriz.

     --> EXTENTREPORT  deyince aklima bu 3 Class gelmelidir. !!!!!!
     1-) ExtentReports   2-) ExtentHtmlReporter  3-) ExtentTest
   */
    ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan class
    ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTML formatında düzenler
    ExtentTest extentTest;//--> Test adımlarına eklemek istediğimiz bilgileri bu class ile oluştururuz
    @Test
    public void test01() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // Her raporu ayri ayri olusturur.
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html"; // DOSYA YOLU belirttik.
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//-->HTML formatında raporlamayı başlatacak

        //Raporda gözükmesini isteğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Tolga");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtentTest","Test Raporu");

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        //başlığın Amazon içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Başlığın Amazon içerdiği test edildi");

        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratıldı");

        //sonuc yazısinı konsola yazdıralım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Yazisi : "+sonucYazisi.getText());
        extentTest.info("Sonuc Yazisi konsola yazdırıldı");
        extentTest.pass("Sayfa kapatıldı");
        /**
            extentTest objesi ile "info()" methodunu kullanarak her step'de ne yaptığımızla alakalı bilgi yazabiliriz
        testimizin en sonunda testin bittiğini ifade eden "pass()" methodu ile testimiz ile alakalı son bilgiyi
        ekleyebiliriz.
            Ve son olarak actions daki "perform()" methodu gibi extentReport objesi ile "flush()" methodu kullanarak
        raporu sonlandırırız
         */
        extentReports.flush();//-->bu methodu kullanmazsak raporumuz oluşmaz
    }
}
