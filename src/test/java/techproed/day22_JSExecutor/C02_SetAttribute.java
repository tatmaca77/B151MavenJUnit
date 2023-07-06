package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_SetAttribute extends TestBase {

    /**
    //Techpro education ana sayfasina git
//Arama kutusuna QA yaz
     */

    @Test
    public void test01() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // --> Reklami kapatiriz.


        //Arama kutusuna QA yaz
        /**
        <input> tag'ina sahip webelementlere deger gönderirken sendKeys() methodunu kullaniriz.
        sendKeys() methodu ile deger gönderemedigimiz durumlarda js executor ile rahatlikla deger gönderebiliriz.

         <input> tag'larinda "value" attribute degeri, arama kutusu icindeki veriyi temsil eder.
         */

        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'",searchBox);//-->value attribute deger olarak QA yazdirir.
        bekle(2);

    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // --> Reklami kapatiriz.


        //Arama kutusuna QA yaz
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        jsSendKeys("JAVA",searchBox);
        bekle(2);
    }

    @Test
    public void test03() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // --> Reklami kapatiriz.


        //Arama kutusuna QA yaz
        /**
        JS Executor ile bir attribute deger atayabiliriz. Asagidaki örnekte oldugu gibi. Sayfadaki aramaKutusunu locate
         edip arama kutusunun value attribute'ne 'QA' degerini atariz. Ama cok karsilasmayabiliriz.
         */
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);
        bekle(2);
    }

    @Test
    public void test04() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // --> Reklami kapatiriz.


        //Arama kutusuna QA yaz
        /**
         JS Executor ile bir attribute deger atayabiliriz. Asagidaki örnekte oldugu gibi. Sayfadaki aramaKutusunu locate
         edip arama kutusunun value attribute'ne 'QA' degerini atariz. Ama cok karsilasmayabiliriz.
         */
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','TOLGA')",aramaKutusu);
        //-->elementor-search-form-9f26725 normal de id atribute değeri
        /** Ama ben gecici olarak "id" attribute degerini 'TOLGA' olarak degistirdim. */
        driver.findElement(By.id("TOLGA")).sendKeys("Java",Keys.ENTER);

    }

    @Test
    public void test05() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // --> Reklami kapatiriz.


        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        jsSetAttribute("value","QA",aramaKutusu); // Method ile attribute degerini set ettik.
        bekle(2);

    }
}
