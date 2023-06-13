package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {

     /**
    Eger bir sayfadaki bir buttona tikladigimizda bir uyari penceresi cikiyorsa ve bu cikan pencereye sag klik yapip
    locate alamiyorsak, bu bir Js Alert'tur.
    *Js(JAVA Script) Alert'u handle edebilmek icin driver'imizi o pencereye gecirmemeiz gerekir.
       Bunun icin; driver objemizi kullanarak
    *swichTo() methoduyla alert() methodunu kullanarak js alert'e gecir yapmis oluruz.
    *accept() ya da dismiss() methodlariyla js Alert'u onaylar ya da iptal ederek kapatiriz
    */

     //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
     //Bir metod olusturun: acceptAlert
     //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
     // “You successfully clicked an alert” oldugunu test edin.
     //Bir metod olusturun: dismissAlert
     //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
     //“successfuly” icermedigini test edin.
     //Bir metod olusturun: sendKeysAlert
     //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
     //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    @Test
    public void acceptAlert1 () {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        bekle(3);
        driver.switchTo(). // gecmek icin kullanilan method
                alert().  // alert'e gecis yapar
                accept();  // cikan alert'te ok yada tamam butonuna tiklar.
        bekle(2);
        WebElement result = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        System.out.println("Cikan Sonuc Yazisi : " + result.getText());
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, result.getText());
    }

    @Test
    public void dismissAlert1 () {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);
        driver.switchTo().
                alert().
                dismiss();
        bekle(3);
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println("Cikan Sonuc Yazisi : " + result.getText());
        String expectedResult = "successfuly;";
        Assert.assertFalse(result.getText().contains(expectedResult));
    }

    @Test
    public void sendKeysAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement js_Prompt = driver.findElement(By.xpath("(//button)[3]"));
        js_Prompt.click();
        bekle(2);
        driver.switchTo().
                alert().
                sendKeys("tolga");
        bekle(2);
        driver.switchTo().alert().accept();//Isimden sonra Keys.ENTER calismayinca alertten accept yaptik.
        bekle(2);
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println("Cikan Sonuc Yazisi : " + result.getText());
        String expectedName = "tolga";
        Assert.assertTrue(result.getText().contains(expectedName));
    }
}
