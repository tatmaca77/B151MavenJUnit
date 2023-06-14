package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class WindowHandle_ClassWork extends TestBase {

    /**
       ● Tests package’inda yeni bir class olusturun: WindowHandle
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
olduğunu doğrulayın.
     */

    @Test
    public void iframe() {
        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        String windowHandle = driver.getWindowHandle();

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement actualText = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        System.out.println("Actual text: " + actualText);
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText.getText());

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);
        bekle(2);

        // ● Click Here butonuna basın.
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();
        bekle(2);

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin
        String newActualTitle = driver.getTitle();
        String newExpectedTitle = "New Window";
        //Assert.assertEquals(newExpectedTitle,newActualTitle);

        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newActualText = driver.findElement(By.xpath("New Window"));
        String newExpectedText = "New Window";
        Assert.assertEquals(newExpectedText,newActualText.getText());
        bekle(2);

        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” oldugunu dogrulayin.
        driver.switchTo().window(windowHandle);
        bekle(2);

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "The Internet";
        Assert.assertEquals(expectedTitle2,actualTitle2);


    }
}
