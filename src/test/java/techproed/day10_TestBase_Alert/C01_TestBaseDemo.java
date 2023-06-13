package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    /** UTIL CLASS gibidir. */

    @Test
    public void test01() {

        /**
        Techpro sayfasina gidelim ve basligi yazdirin ve basligin "Bootcamp" icerdigini test edelim.
         */
        driver.get("https://techproeducation.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";
        System.out.println("Sayfa Basligi : " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        bekle(3);
        driver.close();

    }
}
