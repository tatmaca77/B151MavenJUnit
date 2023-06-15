package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {

    /**
    //  https://the-internet.herokuapp.com/windows adresine gidin.
//  ilk sayfasının Handle degerini alın yazdırın
//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
//  ilk sayfa Title'ının "The Internet" olduğunu test edin.
//  "Click Here" butonuna tıklayın.
//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
//  ikinci sayfaya tekrar geçin.
//  ilk sayfaya tekrar dönün.
     */

    @Test
    public void windowHandle() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows ");

        //  ilk sayfasının Handle degerini alın yazdırın
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE : " + sayfa1Handle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement actualText = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        System.out.println("Ilk Sayfadaki Yazi : " + actualText.getText());
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText.getText());

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        System.out.println("Ilk Sayfanin Title : " + actualTitle);
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();
                           //click isleminden sonra yeni bir sekme aciliyor bu yüzden yeni sekmeye driver gecmeli.
        bekle(2);

        /**
          Eger bir butona tikladigimizda bizim kontrolümüz disinda 2.sayfa aciliyorsa otomatik acilan
          2.sayfaya driver'i gecirmemiz gereklidir. 2.sayfaya gecirebilmemiz icin 2.sayfanin handle degerini
          bulmaliyiz. getWindowHandles() methodu ile biz acilan tüm sekmelerin handle degerlerini görürüz.
          Bu bize degerleri Set<String> icinde verir. Daha sonra :
          driver.switchTo().window(sayfa2Handle); diyerek 2.sayfaya gecis yapariz.
         */

        /*String yeniSayfaHandle = driver.getWindowHandle();  // Handle degerleri hep farkli olur !!!
        System.out.println("Yeni Sayfanin Handle Degeri : " + yeniSayfaHandle); */
        /** Her sayfanin kendine had ve Unique Handle Degeri vardir. */
        /** Burda sayfalarin handle degerleri ayni bu yüzden islem yapariz. */
        Set<String> windowHandleSet = driver.getWindowHandles();
        System.out.println(windowHandleSet);
                            /**getWindowHandles ile acilan tüm sekmelerin handle deferlerini Set olarak getirir. */
        String sayfa2Handle = "";
        for (String w : windowHandleSet) {
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle = w;
            }
        }
        System.out.println("SAYFA2HANDLE : " + sayfa2Handle);

        driver.switchTo().window(sayfa2Handle);  // Yeni sayfaya driver'i gecirmis oluruz.

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String yeniActualTitle = driver.getTitle();
        String yeniExpectedTitle = "New Window";
        Assert.assertEquals(yeniExpectedTitle,yeniActualTitle);


        bekle(2);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(sayfa1Handle);
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "The Internet";
        Assert.assertEquals(expectedTitle2,actualTitle2);

        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2Handle);

        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(sayfa1Handle);
    }
}
