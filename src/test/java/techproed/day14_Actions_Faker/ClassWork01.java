package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class ClassWork01 extends TestBase {

    /**
    //google sayfasına gidelim
// Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
// Sayfayı bekleyin
// Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
//Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
     */

    @Test
    public void test01() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div[text()='Alle akzeptieren']")).click();

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);

        //Sayfayı bekleyin
        bekle(4);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).//-->sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL,"a");//-->Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir

        driver.findElement(By.xpath("//*[@class='gLFyf']")).//-->sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL,"x");//-->Seçilen metni ctrl+x ile kestik

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).//-->sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL,"v",Keys.ENTER);//-->Seçilen metni ctrl+v ile yapistirdik ve arattik.

    }
}
