package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class ClassWork02 extends TestBase {


    /**
    // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // videoyu durdurunuz
    // videoyu tam ekran yapınız
    // videoyu calıstırınız
    // videoyu kucultunuz
    // videoyu durdurunuz
    // Videoyu calistirdiginizi test ediniz
    // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
     */

    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        Actions actions = new Actions(driver);

        // Videoyu görecek kadar asagiya ininiz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);
        bekle(2);
        driver.findElement(By.xpath("//button[@aria-label='Wiedergabe']")).click();
        bekle(5);

        // videoyu durdurunuz
        driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']")).click();
        bekle(2);

        // videoyu tam ekran yapınız
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        bekle(2);

        // videoyu calıstırınız
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        bekle(2);

        // videoyu kucultunuz
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        bekle(2);

        // videoyu durdurunuz
        driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']")).click();
        bekle(2);

        // Videoyu calistirdiginizi test ediniz
        WebElement youTube = driver.findElement(By.xpath("//a[@title='Auf YouTube ansehen']"));
        Assert.assertTrue(youTube.isDisplayed());
        bekle(2);

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();

        WebElement text = driver.findElement(By.xpath("//h1[text()='jQuery Flexy Plugin Demos']"));
        Assert.assertTrue(text.isDisplayed());
        bekle(2);

    }
}
