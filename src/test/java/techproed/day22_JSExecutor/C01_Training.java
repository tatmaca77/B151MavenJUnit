package techproed.day22_JSExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Training extends TestBase {
    /**
     //Amazon'a gidin
     //"Zurück zum Seitenanfang" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
     //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
     //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
     //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
     //Sayfayı en alta scroll yapalım
     //Sayfayi en üste scroll yapalım
     */

    @Test
    public void test01() throws IOException {
        //Amazon'a gidin
        driver.navigate().to("https://www.amazon.com");  // Amazon'da sürekli yazilar ve ürünler degisiyor locate alinmiyor.

        //"Zurück zum Seitenanfang" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement element = driver.findElement(By.xpath("//div[@class='navFooterBackToTop']//span[1]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        bekle(2);

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "src/test/java/techproed/TumSayfaResmi/screenShot" + date + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(filePath));


        //Aynı sayfada "Zusätzliche Artikel" elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement element2 = driver.findElement(By.xpath("(//h2[@class='as-title-block-left']//span)[3]"));

        js.executeScript("arguments[0].scrollIntoView(true);",element2);
        bekle(2);

        String date1 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath1 = "src/test/java/techproed/TumSayfaResmi/screenShot" + date1 + ".jpeg";
        TakesScreenshot ts1 = (TakesScreenshot) driver;
        FileUtils.copyFile(ts1.getScreenshotAs(OutputType.FILE),new File(filePath1));


        //Aynı sayfada "Weitere Artikel" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement element3 = driver.findElement(By.xpath("//span[text()='Weitere Artikel für dich']"));

        js.executeScript("arguments[0].scrollIntoView(true);",element3);
        bekle(2);

        String date2 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath2 = "src/test/java/techproed/TumSayfaResmi/screenShot" + date2 + ".jpeg";
        TakesScreenshot ts2 = (TakesScreenshot) driver;
        FileUtils.copyFile(ts2.getScreenshotAs(OutputType.FILE),new File(filePath2));


        //Aynı sayfada tekrar "Zusätzliche Artikel" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        js.executeScript("arguments[0].scrollIntoView(true);",element2);
        bekle(2);

        String date3 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath3 = "src/test/java/techproed/TumSayfaResmi/screenShot" + date3 + ".jpeg";
        TakesScreenshot ts3 = (TakesScreenshot) driver;
        FileUtils.copyFile(ts3.getScreenshotAs(OutputType.FILE),new File(filePath3));


        //Sayfayı en alta scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(2);


        //Sayfayi en üste scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        bekle(2);

    }


    /**
    Github sayfasina git.
   Sayfanin en altina git ve ekran görüntüsü al
   Sayfanin en üstüne git ve prfil fotografinin ekran görüntüsünü al
   Repositories'e tikla
   Acilan sayfada "Batch151_Selenium_Practice" görünene kadar scroll yap ve ekran görüntüsü al.

     NOTE : TestBase icindeki methodlari kullanarak kod blogu olustur.
     */

    @Test
    public void test02() {
        driver.get("https://github.com/tatmaca77");

        scrollEnd();
        tumSayfaResmi();

        bekle(2);

        scrollHome();
        WebElement photo = driver.findElement(By.xpath("//img[contains(@class,'avatar avatar-user')]"));
        webElementResmi(photo);

        bekle(2);

        driver.findElement(By.xpath("(//a[contains(@class,'UnderlineNav-item js-responsive-underlinenav-item')])[2]")).click();

        WebElement element = driver.findElement(By.xpath("//a[@href='/tatmaca77/Batch151_Selenium_Practice']"));
        jsScrollWE(element);
        tumSayfaResmi();

        bekle(2);


    }
}
