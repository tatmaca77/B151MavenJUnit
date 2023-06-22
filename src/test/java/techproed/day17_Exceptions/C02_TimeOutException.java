package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    /**
     TimeOutException : Sayfada aradigimiz elementi Wait ile belirttigimiz max sürede
                        bulamadigi durumda TimeoutException hatasi aliriz. Eger bu hatayi alirsak "wait" isleminde
                        bir yanlislik yapildigini anlamaliyiz. !!!!
     */

    /**
     //Techpro sayfasina gidin
     //Reklami kapatin
     //searchBox görünür oluncaya kadar bekleyin.
     */

    @Test
    public void timeOutException() {
        //Techpro sayfasina gidin
        driver.get("https://techproeducation.com");
        bekle(3);


        //Reklami kapatin
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //searchBox görünür oluncaya kadar bekleyin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='YANLISSearch...']")));

        /**
        TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlis bir locate aldik.

        WebElementi beklerken o webelementin locate'ini bulamadigi icin max. belirttigimiz süre kadar bekledi ve
        TimeOutException hatasini verdi.
         */

    }

    @Test
    public void timeOutException2() {

        /**
        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
// Start butonuna tıklayınız
// Hello World! yazısının görünürlügünü test ediniz
         */

        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        //visibleWait(helloWorld,100); TestBase icindeki Explicit methodun'dan yararlanabiliriz.

        Assert.assertTrue(helloWorld.isDisplayed());

    }
}
