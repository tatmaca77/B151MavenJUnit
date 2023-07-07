package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.beans.JavaBean;

public class C03_Training extends TestBase {

    /**
     1)getValueTest metotu olustur
     2)GitHub sayfasina git
     3)2023 butonunu rengini Kirmizi yaz
     */

    @Test
    public void getValueTest() {
        // 2)GitHub sayfasina git
        driver.get("https://github.com/tatmaca77");

        // 3)2023 butonunu rengini Kirmizi yaz
        WebElement button = driver.findElement(By.xpath("//a[contains(@class,'js-year-link filter-item')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.color='red';",button);
        bekle(4);
        webElementResmi(button);
        bekle(2);

    }

    @Test
    public void test02() {
        driver.get("https://github.com/tatmaca77");

        WebElement button = driver.findElement(By.xpath("//a[contains(@class,'js-year-link filter-item')]"));

        jsGetAttributeColor(button);
        bekle(2);

    }
}
