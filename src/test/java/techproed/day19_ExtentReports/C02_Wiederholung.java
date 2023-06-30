package techproed.day19_ExtentReports;

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

public class C02_Wiederholung extends TestBase {

    /**
    //amazon sayfasına gidelim
    //başlığın Amazon içerdiğini test edelim
    //arama kutusunda iphone aratalım
    //sonuc yazısinı konsola yazdıralım
    // ekran görüntüsü alalim
     */

    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

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
        extentTest.info("Amazon Sayfasina gidildi."); // Test hakkinda bize bilgi verir.


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


        //



    }
}
