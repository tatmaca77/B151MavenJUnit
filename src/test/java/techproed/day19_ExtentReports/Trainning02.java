package techproed.day19_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trainning02 extends TestBase {

    @Test
    public void test01() throws IOException {

        extentReport("Chrome","Agentur für Arbeit Test","Tolgahan Atmaca");
        extentTest = extentReports.createTest("ExtentReport","Test Raporu");


        //agenturfurarbeit sayfasina gidiniz.
        driver.get("https://www.arbeitsagentur.de/");
        extentTest.info("Agentur für Arbeit Sayfasina gidildi.");

        // sayfanin resmini cekiniz
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        extentTest.info("Tum Sayfanin Ekran Görüntüsü Alindi.");

        //cikan yazi görünüyor mu ?
        WebElement cikanYazi = driver.findElement(By.xpath("//h1[text()='Willkommen, wie können wir Sie weiterbringen?']"));
        System.out.println(cikanYazi.getText());
        Assert.assertTrue(cikanYazi.isDisplayed());
        extentTest.info("Cikan Yazinin Varligi Test Edildi.");
        extentTest.pass("Sayfa Kapatildi");

        extentReports.flush();



    }
}
