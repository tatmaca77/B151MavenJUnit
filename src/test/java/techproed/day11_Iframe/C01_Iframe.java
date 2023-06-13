package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {  // extends TestBase ile Before After dan kurtulduk.

    /**
    //==>   https://testcenter.techproeducation.com/index.php?page=iframe gidin.
    //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
    //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
    //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
     */

    @Test
    public void iframe() {
        //==>   https://testcenter.techproeducation.com/index.php?page=iframe gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        WebElement anIframeYazisi = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']"));
        String istenenYazi = "black border";
        Assert.assertTrue(anIframeYazisi.getText().contains(istenenYazi));

        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
        WebElement iframe = driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']")); // iframe locate etmeliyiz.
        driver.switchTo().frame(iframe); // iframe locate ettikkten sonra icteki web sayfasina switchTo() ile gectik.
        /**
           Applications lists yazisini dogru locate edip, dogru sekilde görünür oldugunu test etmemize ragmen
           ilk basta Test FAILD oldu. Bunun üzerine; HTML kodlarini inceleyince Applications lists yazisinin
           aslinda bir "iframe" icerisinde oldugunu gördük. Bu durumda önce iframe'i locate edip switchTo() ile
           iframe'e gecis yapmaliyiz.
         */
        WebElement applicationList = driver.findElement(By.xpath("//h1[text()='Applications lists']"));
        Assert.assertTrue(applicationList.isDisplayed());

        //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
        driver.switchTo().defaultContent(); // En üstteki frame üzerine cikarir. Distaki web sayfasina gecis yaptik.
        /** parentFrame() => Bir üst seviyedeki iframe'e cikmak icin kullanilir.
         * defaultContent() => En üstteki ifram'e cikmak icin kullanilir -
         * Bu soru icin ikiside olur. Cünkü sadece icice sadece 1 tane web sayfasi vardir.
         */
        WebElement poveredBy = driver.findElement(By.xpath("//p[text()='Povered By']"));
        String istenen = "Povered";
        Assert.assertTrue(poveredBy.getText().contains(istenen));

    }
}
