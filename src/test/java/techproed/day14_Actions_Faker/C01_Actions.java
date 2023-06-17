package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {

/**
//techpro sayfasina gidelim
//sayfanin altina dogru gidelim
//sayfanin ustune dogru gidelim
 */

@Test
public void test01() {
    //techpro sayfasina gidelim
    driver.get("https://techproeducation.com/");
    driver.findElement(By.xpath("//i[@class='eicon-close']"));
    bekle(2);

    //sayfanin altina dogru gidelim
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

    bekle(2);

    //sayfanin ustune dogru gidelim
    actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();
}

    @Test
    public void test02() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com/");

        //Cikan Reklami kapatalim
        driver.findElement(By.xpath("//i[@class='eicon-close']"));
        bekle(2);

        //sayfanin en altina scroll yapalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);
        bekle(2);

        /** Bazen her action dan sonra perform yapmaya gerek yoktur. Son yapilan action sonuna koyabiliriz. */

        //sayfanin en ustune scroll yapalim
        actions.sendKeys(Keys.HOME).build().perform();
        bekle(2);

        /** build() --> methodu action'lari birlestirmek icin kullanilir. Birden fazla action olusuturlursa actioni baglar
                       ancak islemleri cok hizli yapar. Yavas olmasi icin her action sonuna perform() atabiliriz. */

        /** release() --> methodu mouse'u serbest birakir. */

        /**
her actions dan sonra perform kullanmazsak olay cok seri gerceklesir.
build kullandigimizda olay milisaniye icinde gerceklesir.
araya bekle methodu koysak bile java build methodunun oldugu kisimda sayfayi asagi yaparak hizli sekilde gerceklestirir

release() methodu kutuyu bir yerrden sürükleme veya eslestirme gibi konulari yaparken
mouseyi cekip birakmali sorularda release() methodu kullanilir
actionsta mouseta sürükleme islemi yapiyorsak serbest birakma islemi icin release() methodu kullanilir.
 *///build = kur , inşa et, oluştur.
        //build() -->methodu action'lari birlestirmek icin kullanilan methoddur.Birden fazla olusturdugumuz action
        //objesini birbirine baglar
        //release() methodu mouse'u birakir

    }

    @Test
    public void test03() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']"));
        bekle(2);

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();

        // sayfanin üstüne dogru gidelim
        actions.scrollByAmount(0,-1500).perform();

    }
}
