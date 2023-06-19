package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class Hausaufgabe02 extends TestBase {


    /**
    1.Bir Class olusturalim KeyboardActions2
2.https://html.com/tags/iframe/ sayfasina gidelim
3.video’yu gorecek kadar asagi inin
4.videoyu izlemek icin Play tusuna basin
5.videoyu calistirdiginizi test edin
     */

    @Test
    public void keyboardActions() {
        // 2.https://html.com/tags/iframe/ sayfasina gidelim
        driver.navigate().to("https://html.com/tags/iframe/");

        Actions actions = new Actions(driver);

        // 3.video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();


        //4.videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[1]"));
        driver.switchTo().frame(iframe);
        bekle(2);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        bekle(4);

        // 5.videoyu calistirdiginizi test edin
        driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']")).click();
        WebElement youtube = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtube.isDisplayed());
        bekle(2);
    }
}
