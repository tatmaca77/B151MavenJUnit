package techproed.day16_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

    /** NOTES:
        SELENIUM Waits :
     A-) Implicitly Wait --> Sayfadaki tüm Webelemenlerin yüklenebilmesi icin max. bekleme süresidir.
     B-) Explicitly Wait --> Belirli bir kosul gerceklesene kadar max. süre boyunca default olarak
                             500ms araliklarla webelement'i kontrol ederek bekler.Sadece belirli bir
                             WebElement icin kullanilir.
        JAVA Wait:
     A-) Thread.sleep --> Bu da kod blogunu max belirledigimiz süre icinde bekletiriz. Sonrasinda alt
                          kod bloguna gecer ve devam eder.

     */

    @Test
    public void test01() {

        /**
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        //==> Start buttonuna tıklayın
         //==> Hello World! yazısının görünürlügünü test edin
         */
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        /** Start butonuna basinca hemen yazi görünmez. Bu yüzden fail verir. Aralarindaki
            senkronizationu saglamaliyim. Yani bekletme isi yaptirip görünene kadar bekletmeliyim. */



        //==> Hello World! yazısının görünürlügünü test edin
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        /** Explicit Wait kullandik. */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        /** *** 1 .YOL **** */
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        /** *** 2.YOL **** */
        //WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

        Assert.assertTrue(helloWorld.isDisplayed());


        /*
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(helloWorld.isDisplayed());
        */
        /**
        Implicitly Wait kullanmis olduk; cünkü extends TestBase yaptik onun icinde var zaten bekletme.
        Ama Implicitly Wait ile Hata aldik Test FAILD oldu.
         Hello World yazisinin görünürlügünü Implicitly Wait ile cözemedik. !!!!!
         Assertion isleminde hata aliriz. Yazi aninda görünmüyor.
         */

        /*
        Normalde Thread.sleep te kullanilir ancak cokta makul degildir. Biz Selenium da calisiyrouz
        Selenium tabanli Wait'ler kullanilir. Thread.sleep() icinde verecegimiz bekleme süresi boyunca bekler
        WebElementi daha kisa sürede bulsa bile. !!!!!
         */



    }
}
