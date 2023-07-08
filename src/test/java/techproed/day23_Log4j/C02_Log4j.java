package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C02_Log4j extends TestBase {
    /**
        //Techproeducation sayfasina gidelim
        //Sayfa Basliginin Egitim icerdigini dogrulayalim
     */

    @Test
    public void test01() {

        Logger logger = LogManager.getLogger(C02_Log4j.class);

        //Techproeducation sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        logger.info("Techpro Sayfasina gidildi.");

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        logger.info("Sayfada cikan reklam kapatildi.");


        //Sayfa Basliginin Egitim icerdigini dogrulayalim
        Assert.assertFalse(driver.getTitle().contains("Egitim") );
        logger.error("Sayfanin basligi Egitim kelimesini icermiyor.");

    }
}
