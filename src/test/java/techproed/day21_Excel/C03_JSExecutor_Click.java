package techproed.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {

    /**
      JavaScript Executers :
      * Eger bir Web Sayfasinin Html kodlari tamamen veya kismen JavaScript kullanilarak olusturulduysa o sayfa ile
        etkilesimde bulunmak icin standart WebDriver komutlari yetersiz olabilir.

     Bu durumda sayfa ile etkilesime gecebilmek icin JavaScriptExecutor arayüzünü kullanmak gerekir. JsExecutor arayüzü
     sayfaya direkt ulasabilir.

     Ancak mümkünse WebDriver'in sundugu standart yöntemlerle sayfa ile etkilesime gecmek her zaman daha iyidir.
     Cünkü; JS kullanimi sayfanin daha yavas yüklenmesine neden olabilir...

     Ingiliz anahtari gibidir her durumda kullanilabilir, her sekilde kullanilmali hatayi aza indirir ve ayni isi yapar.
     */

    @Test
    public void jsExecuterClick() {
        /**
        // amazona gidelim
        //returns click
         */
        // amazona gidelim
        driver.get("https://www.amazon.com");


        ////returns click
        WebElement returns = driver.findElement(By.xpath("//a[@id='nav-orders']"));
        //returns.click();

        /**
    Ilgili webElementin HTML kodu , JavaScript kullanilarak olusturulduysa standart WebDriver komutu olan click()
    yetersiz kalabilir. Boyle durumlarda JavaScriptExecuter kullanilarak sayfa ile etkilesime gecilebilir
         */



        /** Standart bir JSExecutor komutudur. */
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",returns);






    }
}
