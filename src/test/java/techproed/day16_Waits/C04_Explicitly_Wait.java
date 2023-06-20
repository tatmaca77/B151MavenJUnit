package techproed.day16_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C04_Explicitly_Wait extends TestBase {

    /**
    //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
//==>  Remove tuşuna basın
//==>  "It's gone!" yazısının görünür oldugunu test edin.
     */

    @Test
    public void test01() {
        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //==>  Remove tuşuna basın
        driver.findElement(By.xpath("//button[text()='Remove']")).click();


        //==>  "It's gone!" yazısının görünür oldugunu test edin.
       WebElement itsgoneMessage = driver.findElement(By.xpath("//p[@id='message']"));

       visibleWait(itsgoneMessage,25);  // Explicit ile de Implicity Wait ile de cözülebilir bu soru.

       Assert.assertTrue(itsgoneMessage.isDisplayed());

        /** driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
           burda locate alirken It's gone! yazisinin tirnaklari bizim text()='' tirnaklari ile karsiyor bu yüzden
           cift tirnak yaptik.
         */


    }
}
