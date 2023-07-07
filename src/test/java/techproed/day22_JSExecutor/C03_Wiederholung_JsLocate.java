package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_Wiederholung_JsLocate extends TestBase {

    /**
     //  https://www.carettahotel.com/ a gidiniz
     //  Tarih kısmını JS ile locate ediniz.
     //  Date WebElementi'nin Attribute degerlerini yazdiralim.
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
        WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
        date.clear();
        date.sendKeys("28.04.2024");
        bekle(2);
        scrollEnd();


        //  Date WebElementi'nin Attribute degerlerini yazdiralim.
        String idAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').id").toString();
        String typeAttDegeri = (String) js.executeScript("return document.getElementById('checkin_date').type");
        String nameAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').value").toString();

        System.out.println("ID Attribute Degeri : " + idAttributeDegeri);
        System.out.println("Type Attribute Degeri : " + typeAttDegeri);
        System.out.println("Name Attribute Degeri : " + nameAttributeDegeri);
        System.out.println("Value Attribute Degeri : " + valueAttributeDegeri);

    }
}
