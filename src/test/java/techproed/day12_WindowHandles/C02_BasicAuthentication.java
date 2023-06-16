package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    //Authentication eski bir yöntem olabilir. Eger yeni bir sayfa olusturanlar sayfasini
    //daha süslü olmasi icin bu sistemi kullanmak isteyebilir. Bu karsimiza cok cikmaz.
    /**
    - Authentication kimlik dogrulama yöntemidir.
    - Söz konusu sisteme dahil olunup olunamayacagini belirleyen formu ifade eder.
    - Authentication üzerinde sag click yapip locate yapilamaz.
    - Authentication bir "Alert" degildir.
    - Authentication yapabilmek icin uygulamanin kullanicilara,
    Authenrication'i nasil yapacagina dair bilgilendirme yapmis olmasi gereklidir:
    - https://username:password@URL bunun gibi.
     */

    /**
    // Aşağıdaki bilgileri kullanarak authentication yapınız:

// Url: https://the-internet.herokuapp.com/basic_auth
// Username: admin
// Password: admin

//Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız

     https://username:password@URL
     Yukarida belirtilen formata uygun kimlik dogrulamasi yapilacaktir.
     */

    @Test
    public void basicAuthentication() {
        // Url: https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(2);

        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
        WebElement text = driver.findElement(By.xpath("//p"));
        String expectedText = "Congratulations";
        Assert.assertTrue(text.getText().contains(expectedText));

    }
}
