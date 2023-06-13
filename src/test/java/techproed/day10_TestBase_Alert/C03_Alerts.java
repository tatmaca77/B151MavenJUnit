package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_Alerts extends TestBase {

    // https://demoqa.com/alerts adresine gidelim.
    //Click Button to see alert karsisindaki butona tiklayalim
    // Cikan Alert'te You clicked a button yazisinin ciktigini test edelim
    // Ve alert'ü kapatalim.


    @Test
    public void test01() {
        // https://demoqa.com/alerts adresine gidelim.
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karsisindaki butona tiklayalim
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        bekle(2);

        // Cikan Alert'te You clicked a button yazisinin ciktigini test edelim
        /** String cikanYazi = driver.switchTo().alert().getText(); */ //Bunun yerine method kull.

        System.out.println("Alert Message : " + getTextAlert());
        Assert.assertEquals("You clicked a button", getTextAlert());
        bekle(2);

        // Ve alert'ü kapatalim.
        acceptAlert();  // - TestBase --> class'inda olusturdugmuz method.
    }

    @Test
    public void test02() {
        driver.get("https://demoqa.com/alerts");
        //On button click, confirm box will appear karşsindaki buttona basalım
        driver.findElement(By.xpath("(//button)[4]")).click();
        bekle(2);
        //Çıkan alertte iptal'e basalım
        dismissAlert();
        //sonuc yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);
    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[5]")).click();
        bekle(2);
        //çıkan alerte ismimizi girelim
        sendKeysAlert("Erol");
        bekle(2);
        acceptAlert();
        //ismi girdiğimizi doğrulayalım
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Erol"));
    }


}
