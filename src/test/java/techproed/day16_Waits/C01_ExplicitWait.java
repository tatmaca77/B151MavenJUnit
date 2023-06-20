package techproed.day16_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

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



        //==> Hello World! yazısının görünürlügünü test edin


    }
}
