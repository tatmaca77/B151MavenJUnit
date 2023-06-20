package techproed.day16_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {

    /**
    Fluent Wait --> Belirli bir kosul gerceklesene kadar max. süre boyunca belirttigimiz
                    araliklarla WebElementi kontrol ederek bekler.
                    Expilicit'den farki; kontrol aralikligini biz belirleyebiliriz.,
                    Expilicit Wait'de 500ms, Fluent Wait'de biz belirleriz.
     */

    @Test
    public void fluentWait() {

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
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).//FluentWait icin max bekleme süresini belirtir.
                        pollingEvery(Duration.ofSeconds(3)).// Her 3 sn'de bir WebElementi kontrol eder.
                        withMessage("Ignore Exception");// Hata aninda bize istedigimiz mesaji vermesini saglar.

        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertTrue(helloWorld.isDisplayed());

        /**
        Thread.sleep() : Javadan gelir. Belirttigimiz süre kadar kodlari bekletir.

         Implicitly Wait : Sayfadaki tüm WebElementlerin yüklenebilmesi icin max bekleme süresidir.%80 cözüm saglar.

         Explicit Wait : 2'ye ayrilir.

                    a-) WebDriverWait : Belirli bir kosul gerceklesene kadar max süre boyunca, default olarak
                        500ms(5sn) araliklarla webelementi kontrol ederek bekler...

                    b-) FluentWait : Belirli bir kosul gerceklesene kadar max süre boyunca, belirttigimiz araliklarla
                                     webelementi kontrol ederek bekler...

         */

    }
}
