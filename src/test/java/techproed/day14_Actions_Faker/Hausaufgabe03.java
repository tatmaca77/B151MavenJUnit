package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class Hausaufgabe03 extends TestBase {

    /**
    Test01 :
1- amazon gidin
2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
3. dropdown menude 40 eleman olmadigini doğrulayın
Test02
1. dropdown menuden elektronik bölümü seçin
2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
4. ikinci ürüne relative locater kullanarak tıklayin
5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
Test03
1. yeni bir sekme açarak amazon anasayfaya gidin
2. dropdown’dan bebek bölümüne secin
3. bebek puset aratıp bulundan sonuç sayısını yazdırın
4. sonuç yazsının puset içerdiğini test edin
5-üçüncü ürüne relative locater kullanarak tıklayin
6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
Test 4
1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */

    @Test
    public void test01() {
        /** Test01 :
        1- amazon gidin
        2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        3. dropdown menude 40 eleman olmadigini doğrulayın
         */
        driver.get("https://www.amazon.com/");

        List<WebElement> ddm = driver.findElements(By.xpath("//select[@id='searchDropdownBox']"));
        for (int i = 0; i < ddm.size() ; i++) {
            System.out.println((i+1) + "." + ddm.get(i).getText());
        }
        System.out.println("***********2.YOL LAMBDA*******************");
        ddm.stream().forEach(t-> System.out.println(t.getText()));
        bekle(3);

        Assert.assertTrue(ddm.size()<40);

    }

    @Test
    public void test02() {
       /** Test02
        1. dropdown menuden elektronik bölümü seçin
        2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        4. ikinci ürüne relative locater kullanarak tıklayin
        5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        */
        driver.get("https://www.amazon.com/");

        // 1. dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        selectIndex(ddm,6);
        bekle(3);

        // 2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        bekle(3);

        //  3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement actualResult = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Yazisi : " + actualResult.getText());
        String expectedResult = "iphone";
        Assert.assertTrue(actualResult.getText().contains(expectedResult));
        bekle(2);

        // 4. ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).click();
        bekle(2);

        // 5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String productTitle = driver.getTitle();
        System.out.println("Ürün Basligi : " + productTitle);
        WebElement productPrice = driver.findElement(By.xpath("//div[@class='a-section a-spacing-micro']"));
        System.out.println("Ürün Fiyati : " + productPrice.getText());

        driver.findElement(By.id("add-to-cart-button")).click();
        bekle(4);

    }

    @Test
    public void test03() {

        /**
         Test03
         1. yeni bir sekme açarak amazon anasayfaya gidin
         2. dropdown’dan bebek bölümüne secin
         3. bebek puset aratıp bulundan sonuç sayısını yazdırın
         4. sonuç yazsının puset içerdiğini test edin
         5-üçüncü ürüne relative locater kullanarak tıklayin
         6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
         */

        //1. yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

        // 2. dropdown’dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        selectVisibleText(ddm,"Baby");
        bekle(2);

        // 3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
        bekle(3);

        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Yazisi: " + sonucYazisi.getText());
        String [] sonuclar  = sonucYazisi.getText().split(" ");  // Sonuc Sayisi icin Array'e at split ile ayir.
        System.out.println("Sonuc Yazisi : " + Arrays.toString(sonuclar));
        System.out.println("Sonuc Sayisi : " + sonuclar[0]);

        //  4. sonuç yazsının puset içerdiğini test edin
        String expectedSonucYazisi = "puset";
        Assert.assertTrue(sonucYazisi.getText().contains(expectedSonucYazisi));

        // 5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();
        bekle(2);

        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String productTitle = driver.getTitle();
        System.out.println("Ürün Basligi : " + productTitle);
        WebElement productPrice = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-micro'])[1]"));
        System.out.println("Ürün Fiyati : " + productPrice.getText());

        driver.findElement(By.id("add-to-cart-button")).click();
        bekle(4);

    }

    @Test
    public void test04() {

        /**
        // Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
         */


    }
}


