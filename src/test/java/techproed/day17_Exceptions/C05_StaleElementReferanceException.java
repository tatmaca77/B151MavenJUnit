package techproed.day17_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.awt.*;
import java.util.List;

public class C05_StaleElementReferanceException extends TestBase {

    /**
     // Amazon sayfasına gidelim
     // arama motoruna iphone yazıp aratalım
     // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım
     */

    @Test
    public void StaleElementRefarenceExceptionTest01() {
        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        // arama motoruna iphone yazıp aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);

        // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım
        List<WebElement> produkte = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        for (int i = 0; i < produkte.size() ; i++) {

            produkte.get(i).click(); // StaleElementRefarenceException aldik.
            System.out.println((i+1) + ".URUN TITLE" + driver.getTitle());
            driver.navigate().back();
            if (i==4){
                break;
            }
        }

        /**
        Burda StaleElementRefarenceException hatasi aliriz. Cünkü back() yaptiktan sonra tekrar webelemeti tekrar
         göremiyor. Webelement locate'i bayatlamis olur. Tekrar ona hatirlatmamiz gerekiyor. !!!!!!
         */

        /**Test02 de Handle edilmis hali vardir. */
    }

    @Test
    public void StaleElementRefarenceExceptionTest02() {
        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        // arama motoruna iphone yazıp aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);

        // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım
        List<WebElement> produkte = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        for (int i = 0; i < produkte.size() ; i++) {
            produkte = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
            produkte.get(i).click();
            System.out.println((i+1) + ".URUN TITLE" + driver.getTitle());
            driver.navigate().back();
            if (i==4){
                break;
            }
        }

    }
}
