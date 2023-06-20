package techproed.day16_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_WebDriverWait_ExplicitWait extends TestBase {

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

        /** Explicit Wait kullandik. "extends TestBase" icinde Resable methodunu olusturduk.*/
        visibleWait(helloWorld,100);

        Assert.assertTrue(helloWorld.isDisplayed());

    }
}
