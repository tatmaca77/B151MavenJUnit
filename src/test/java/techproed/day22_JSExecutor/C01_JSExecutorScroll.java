package techproed.day22_JSExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_JSExecutorScroll extends TestBase {

    /**
    //Techpro education ana sayfasına git
//"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
//Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
//Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
//Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
//Sayfayı en alta scroll yapalım
//Sayfayi en üste scroll yapalım
     */


    /**                      NOTES:
    Actions class'indaki gibi js executor ile de sayfada scroll islemi yapabiliriz. Bir web elementi locate edip
     o webelement görülür olana kadar scroll yapabiliriz.

     "arguments[0].scrollIntoView(true);",Webelement --> Bu script kodu ile belirtmis oldugumuz webelemete scroll yapariz.
     */
    @Test
    public void test01() throws IOException {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // --> Reklami kapatiriz.

        WebElement weofferWE = driver.findElement(By.xpath("//*[text()='we offer']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weofferWE);
        bekle(2);

        tumSayfaResmi(); // --> TestBase'deki ScreenShot methodu

        /**
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

         */

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeWE = driver.findElement(By.xpath("//span[text()='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);
        bekle(2);

        tumSayfaResmi();


        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUS =driver.findElement(By.xpath("(//div[@class='sc_heading ']//h3)[3]"));
        js.executeScript("arguments[0].scrollIntoView(true);",whyUS);
        bekle(2);

        tumSayfaResmi();


        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);
        bekle(2);

        tumSayfaResmi();


        //Sayfayı en alta scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(2);

        /**
        Yani aslinda x,y kordinatlariyla düsünerek yazabiliriz. scroll(x,y) gibi olur.
        x-> 0 olursa y dogrultusunda yukari asagi scroll eder.
        y-> 0 olursa x dogrultusunda sag sola scroll eder.
         */


        /**
        Mantik olarak en alttaki bir WE'ti locate edip oraya Scroll yaptirabiliriz ve en alta gitmis oluruz. !!!!!
         */
        //js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);




        //Sayfayi en üste scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        bekle(2);

        /**
         Mantik olarak en üstteki bir WE'ti locate edip oraya Scroll yaptirabiliriz ve en alta gitmis oluruz. !!!!!
         */

        /*WebElement lmsLogin = driver.findElement(By.xpath("(//a[@class='elementor-item'])[4]"));
        js.executeScript("arguments[0].scrollIntoView(true);",lmsLogin);*/

    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,1500)");// --> x=0, y=1500 pixel olarak bir noktaya scroll yapar.
        bekle(2);

        /**
        Yani aslinda düsünme mantigi aynidir. x-> 0 da sabit tutariz. y -> 500 olur ve yukari asagi scroll yapar.
         */

        // Bu yöntem cok kullanilan bir yöntem degildir.

    }

    @Test
    public void test03() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // --> Reklami kapatiriz.

        WebElement weofferWE = driver.findElement(By.xpath("//*[text()='we offer']"));
        jsScrollWE(weofferWE);
        bekle(2);

        tumSayfaResmi(); // --> TestBase'deki ScreenShot methodu


        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeWE = driver.findElement(By.xpath("//span[text()='Enroll Free Course']"));
        jsScrollWE(enrollFreeWE);
        bekle(2);

        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUS =driver.findElement(By.xpath("(//div[@class='sc_heading ']//h3)[3]"));
        jsScrollWE(whyUS);
        bekle(2);

        tumSayfaResmi();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        jsScrollWE(enrollFreeWE);
        bekle(2);

        tumSayfaResmi();


        //Sayfayı en alta scroll yapalım
        scrollEnd();
        bekle(2);


        //Sayfayi en üste scroll yapalım
        scrollHome();
        bekle(2);


    }
}
