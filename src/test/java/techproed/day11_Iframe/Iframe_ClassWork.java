package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class Iframe_ClassWork extends TestBase {

    /**
     User Story:
➢ Sinif : IFrame
➢ https://testcenter.techproeducation.com/index.php?page=iframe
➢ Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin
oldugunu test edelim
➢ Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
➢ Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
     */

    @Test
    public void iframe() {
        // ➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        // ➢ Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        WebElement anIframe = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']"));
        Assert.assertTrue(anIframe.getText().contains("black border"));

        // ➢ Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        WebElement iframe = driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']"));
        driver.switchTo().frame(iframe); // Icteki web sitesine gecis yaptik.

        WebElement appList = driver.findElement(By.xpath("//h1[text()='Applications lists']"));
        Assert.assertTrue(appList.isDisplayed());

        // ➢ Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        driver.switchTo().defaultContent();
        WebElement poveredBy = driver.findElement(By.xpath("//p[text()='Povered By']"));
        Assert.assertTrue(poveredBy.isDisplayed());
    }
}
