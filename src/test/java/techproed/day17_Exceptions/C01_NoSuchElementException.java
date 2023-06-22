package techproed.day17_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    /**
    NoSuchElementException : Sayfada bulunmayan bir elemente erisim saglanmaya calisildiginda "NoSuchElementException"
                             hatasi aliriz. Yada yanlis locate islemi alirsakta karsilasiriz.
     */

    /**
    //Techpro sayfasina gidin
    //Reklami kapatin
    //searchBox'a JAVA yazip aratalim
     */

    @Test
    public void NoSuchElementException() {
        //Techpro sayfasina gidin
        driver.get("https://techproeducation.com");
        bekle(3);


        //Reklami kapatin
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //searchBox'a JAVA yazip aratalim
        driver.findElement(By.xpath("//input[@placeholder='YANLISSearch...']")).sendKeys("JAVA", Keys.ENTER);


        /**
     NoSuchElementException:
Yanlis locator
Popup, yeni pencere, iframe,…
Sayfa dolmada problemler ve yavaslamalar
Sakli olan elementle

            Solution:
Locatorin dogrulugunu tekrar kontrol et
Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada
fluent wait kullaniriz
     */
    }
}
