package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Training extends TestBase {

    /**
     //GitHub  ana sayfasina git
//Arama kutusuna js executor yaz
     */

    @Test
    public void test01() {
        //GitHub  ana sayfasina git
        driver.navigate().to("https://github.com/tatmaca77");

        WebElement searchBox = driver.findElement(By.xpath("//button[contains(@class,'header-search-button placeholder')]"));
        searchBox.click();

        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='js executor'",searchBox);
        bekle(5); */

        jsSendKeys("JS Executor",searchBox);
        bekle(2);

    }
}
