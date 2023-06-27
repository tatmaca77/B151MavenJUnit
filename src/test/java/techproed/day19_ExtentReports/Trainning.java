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

public class Trainning extends TestBase {

    //amazon sayfasına gidelim
    //başlığın Amazon içerdiğini test edelim
    //arama kutusunda iphone aratalım
    //sonuc yazısinı konsola yazdıralım

    /*
    Extent Reports dedigimde aklima ilk gelen 3 Class'tir.
    1-Extent Reports  2- Extent Html Reporter  3- Extent Test
     */

    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    public void extentReports() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date()); // Her raporu ayri ayri olusturur.
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html"; // DOSYA YOLU belirttik.
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//-->HTML formatında raporlamayı başlatacak

        //Raporda gözükmesini isteğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Totti");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtentTest","Test Raporu");


        //amazon sayfasına gidelim
        driver.navigate().to("https://amazon.com");
        extentTest.info("Amazon Sayfasina gidildi.");

        //başlığın Amazon içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Basligin Amazon icerdiginin Testi yapildi");

        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama Kutusunda iphone yazip aratildi.");

        //sonuc yazısinı konsola yazdıralım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc YAzisi : " + sonucYazisi.getText());
        extentTest.info("Sonuc Yazisi Konsola Yazdirildir.");
        extentTest.pass("Sayfa Kapatildi.");


        extentReports.flush(); /** TestBase'de After methodu icinde...... */
    }
}
