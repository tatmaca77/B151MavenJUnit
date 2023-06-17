package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {

    /**
    // google anasayfasina gidelim  https://www.google.com/
        // arama kutusunda:
        // shift tusuna basili olarak "selenium" yazdiralim ve shift tusunu serbest birakarak "java" yazdiralim
     */

    @Test
    public void test01() {

        // google anasayfasina gidelim  https://www.google.com/
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.xpath("//div[text()='Alle akzeptieren']")).click();

        // arama kutusunda:
        // shift tusuna basili olarak "selenium" yazdiralim ve shift tusunu serbest birakarak "java" yazdiralim
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        bekle(2);

        actions.keyDown(aramaKutusu, Keys.SHIFT).sendKeys("selenium").
                keyUp(Keys.SHIFT).sendKeys("java",Keys.ENTER).perform();
        bekle(2);

        // keyDown(aramaKutusu, Keys.SHIFT) --> Arama Kutusunda shift tusuna bastik.
        // keyUp(Keys.SHIFT) --> Shift tusunu serbest biraktik.
        // sendKeys("selenium") --> Bu method ile istedigimiz yaziyi yazdik.
        // Keys.ENTER) --> Enter'a basip arattik.
        // perform(); --> Islemi bitirdik.

    }

    /** ***** 2. YOL *******    ---ACTION--- olmadan kullanimi
          Genelde mause harketlerinde "action" kullanirsin. Klavye hareketlerinde cok gerek yok !!!!! */

    @Test
    public void test02() {
        // google anasayfasina gidelim  https://www.google.com/
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.xpath("//div[text()='Alle akzeptieren']")).click();

        // arama kutusunda:
        // shift tusuna basili olarak "selenium" yazdiralim ve shift tusunu serbest birakarak "java" yazdiralim
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        bekle(2);
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
        bekle(2);

        /**
           NOTE : Genelde mause harketlerinde "action" kullanirsin. Klavye hareketlerinde cok gerek yok !!!!!
         */

        /*
        Mause islemleri icin action class'ini kullanmamiz gereklidir. Fakat bir metin kutusundaki klavye islemleri
        icin action class'ini kullanmadan sendKeys() methodu ile de istedigimiz bir metni büyük veya kücük
        yazdirabilir, hatta bir den fazla klavye tuslarina bastirabiliriz. Yukaridaki örnekte sendKeys() methodu
        ile Keys.SHIFT diyerek sonrasinda yazdirmak istedigimiz metni tirnak icinde kücük harflerle yazmamiza
        ragmen büyük harflerle texti yazdirir. Tekrar Keys.SHIFT kullanarak "shift" tusunu serbest birakmis oluruz.
         */
    }

}
