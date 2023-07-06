package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_GetAttribute extends TestBase {
    /**
     //  https://www.carettahotel.com/ a gidiniz
     //  Tarih kısmını JS ile locate ediniz.
     //  Yazili metinleri alıp ve yazdırınız
     */

    @Test
    public void test01() {
        //  https://www.carettahotel.com/ a gidiniz
        driver.navigate().to("https://www.carettahotel.com/");
        bekle(2);
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        bekle(8);


        //  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
        WebElement date = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
        date.clear(); // Önce mecvutta bisey varsa onu silmeliyiz. !!!!
        date.sendKeys("07.07.2023");
        bekle(5);

        /**
        querySelector == getElementById --> js executor ile locate alirsak bu sekilde 2 yol vardir.
         */

       /**
    Java Script kodlariyla yazilmis webelementleri bizim bildigimiz findElement() methoduyla locate edemeyebiliriz
    js executor kullanarak ister html ister java script ile yazilmis olsun bir webelementin locatini js executor
    ile alabiliriz. Yukaridaki ornekte sayfadaki tarih webelementini js executor ile locate ettik
        */

        //  Date WebElementi'nin Attribute degerlerini yazdiralim.
        String idAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').id").toString();
        String typeAttDegeri = (String) js.executeScript("return document.getElementById('checkin_date').type");
        String nameAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').value").toString();

        System.out.println("ID Attribute Degeri : " + idAttributeDegeri);
        System.out.println("Type Attribute Degeri : " + typeAttDegeri);
        System.out.println("Name Attribute Degeri : " + nameAttributeDegeri);
        System.out.println("Value Attribute Degeri : " + valueAttributeDegeri);

        /**
        Burda istersek casting yapariz, istersek toString() methodu ile kizarikligi hallederiz...
         */

        /**
        JS executor ile attribute degerlerini yazdirabilmek icin js ile locate ettigimiz webelementin sonuna
        yikaridaki örnekteki gibi hangi attribute degerini yazdirmak istersek o attribute adini yazariz.
         */
    }

    @Test
    public void test02() {
        /**
        1)getValueTest metotu olustur
2)https://www.priceline.com/ a git
3)Submit butonunu rengini Kirmizi yaz
         */

        driver.get("https://www.priceline.com/");

        WebElement findYourHotel = driver.findElement(By.xpath("//div[text()='Find Your Hotel']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.color='red';",findYourHotel);
        bekle(6);
        webElementResmi(findYourHotel);

    }
}
