package techproed.day19_ExtentReports;

import techproed.utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_ExtentReport extends TestBase {

    @Test
    public void test01() {
        extentReport("Chrome","Amazon Testi","Tolgahan");
        extentTest = extentReports.createTest("ExtentReport","Test Raporu"); // Test islemlerini baslatir.

        // amazon sayfasina gidiniz.
        driver.get("https://amazon.com");
        extentTest.info("Amazon Sayfasina gidildi."); // Test hakkinda bize bilgi verir.


        // sayfanin resmini cekiniz. (method kullanmadanda yazmaliyim)
        tumSayfaResmi();
        extentTest.info("Sayfanin Resmi alindi.");


        //arama kutusunda iphone aratiniz.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama Kutusunda iphone aratildi.");
        extentTest.pass("Sayfa kapatildi.");





    }
}
