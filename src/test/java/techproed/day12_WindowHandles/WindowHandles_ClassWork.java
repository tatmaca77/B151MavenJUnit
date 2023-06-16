package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.Set;

public class WindowHandles_ClassWork extends TestBase {

    /**
     https://testcenter.techproeducation.com/index.php?page=multiple-windows
● Title in ‘Windows’ oldugunu test edin
● Click here a tiklayin
● Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
     */

    @Test
    public void windowHandles() {
        // https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        // ● Title in ‘Windows’ oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(expectedTitle,actualTitle);

        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE : " + sayfa1Handle);

        // ● Click here a tiklayin
        WebElement button = driver.findElement(By.xpath("//a[text()='Click Here']"));
        button.click();

        bekle(2);

        // ● Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Sayfalarin Handles Degerleri : " + windowHandles);
        String sayfa2Handle = "";

        for (String w : windowHandles) {
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle = w;
            }
        }
        System.out.println("SAYFA2HANDLE : " + sayfa2Handle);

        driver.switchTo().window(sayfa2Handle);

        // ● Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        Assert.assertEquals(expectedTitle2,actualTitle2);

        bekle(2);

        // ILk sayfaya geri dön.
        driver.switchTo().window(sayfa1Handle);
    }
}
