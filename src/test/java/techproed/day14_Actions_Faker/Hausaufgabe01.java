package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class Hausaufgabe01 extends TestBase {

     /**
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over  Me First" kutusunun ustune gelin
    3- Link 1" e tiklayin
    4- Popup mesajini yazdirin
    5- Popup'i tamam diyerek kapatin
    6- “Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin
      8- “Double click me" butonunu cift tiklayin.
      9-Tıklandığını test edin
      10- Tekrar Double Click Me 'ye iki kere tiklayin.
      11- Tikladigini test edin.
     */

     @Test
     public void test01() {
         // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
         driver.navigate().to("http://webdriveruniversity.com/Actions");

         Actions actions = new Actions(driver);

         // 2- Hover over  Me First" kutusunun ustune gelin
         WebElement hoverOver = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
         actions.moveToElement(hoverOver).perform();
         bekle(2);

         // 3- Link 1" e tiklayin
         driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();

         // 4- Popup mesajini yazdirin
         System.out.println(driver.switchTo().alert().getText());
         //System.out.println(getTextAlert());

         // 5- Popup'i tamam diyerek kapatin
         acceptAlert();
         //driver.switchTo().alert().accept();

         // 6- “Click and hold" kutusuna basili tutun
         WebElement clickAndHold = driver.findElement(By.xpath("//p[text()='Click and Hold!']"));
         actions.moveToElement(clickAndHold).perform();
         bekle(2);
         actions.clickAndHold(clickAndHold).perform();
         bekle(2);

         // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
         WebElement message = driver.findElement(By.xpath("//div[@id='click-box']"));
         System.out.println("Görülen Mesaj : " + message.getText());
         bekle(2);

         // 8- “Double click me" butonunu cift tiklayin.
         WebElement doubleClickMe = driver.findElement(By.xpath("//div[@id='double-click']"));
         actions.moveToElement(doubleClickMe).doubleClick(doubleClickMe).perform();
         bekle(4);

         // 9-Tıklandığını test edin
         WebElement neuClickMe = driver.findElement(By.xpath("//div[@class='div-double-click double']"));
         Assert.assertTrue(neuClickMe.isDisplayed());
         bekle(2);

         // 10- Tekrar Double Click Me 'ye iki kere tiklayin.
         actions.doubleClick(neuClickMe).perform();

         //  11- Tikladigini test edin.
         Assert.assertTrue(doubleClickMe.isDisplayed());
         bekle(2);

     }
}
