package techproed.day18_ScreenShot;

import net.bytebuddy.build.Plugin;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ubung01_ScreeShot extends TestBase {

    /**
    Class : ScreenShot2
1.Techpro education a git
2.Sosyal medya elemanlarını goruntusunu al
     */

    @Test
    public void screenShot() throws IOException {
        // 1.Techpro education a git
        driver.navigate().to("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.cssSelector("html>body>div:nth-of-type(9)>div>a>i")).click();
        bekle(2);


        /** Reusable Methodlarda kullanilabilir. TestBase icindeki !!!!!! */

        // 2.Sosyal medya elemanlarını goruntusunu al
        WebElement facebook = driver.findElement(By.xpath("(//span[text()='Facebook'])[2]"));
        String date1 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "src/test/java/techproed/ElementResmi/WEscreenShot" + date1 + ".jpeg";
        FileUtils.copyFile(facebook.getScreenshotAs(OutputType.FILE),new File(filePath));
        bekle(2);



        // 2.Sosyal medya elemanlarını goruntusunu al
       /*
       WebElement twitter = driver.findElement(By.xpath("(//a[@href='https://twitter.com/techproedu'])[1]"));
        String date2 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath2 = "src/test/java/techproed/ElementResmi/WEscreenShot" + date2 + ".jpeg";
        FileUtils.copyFile(twitter.getScreenshotAs(OutputType.FILE),new File(filePath2));
         */
        WebElement twitter = driver.findElement(By.xpath("(//a[@href='https://twitter.com/techproedu'])[1]"));
        webElementResmi(twitter);
        bekle(2);


        // 2.Sosyal medya elemanlarını goruntusunu al
        WebElement youtube = driver.findElement(By.xpath("(//i[@class='fab fa-youtube'])[1]"));
        String date3 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath3 = "src/test/java/techproed/ElementResmi/WEscreenShot" + date3 + ".jpeg";
        FileUtils.copyFile(youtube.getScreenshotAs(OutputType.FILE),new File(filePath3));
        bekle(2);


        // 2.Sosyal medya elemanlarını goruntusunu al
        WebElement instagram = driver.findElement(By.xpath("(//i[@class='fab fa-instagram'])[1]"));
        String date4 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath4 = "src/test/java/techproed/ElementResmi/WEscreenShot" + date4 + ".jpeg";
        FileUtils.copyFile(instagram.getScreenshotAs(OutputType.FILE),new File(filePath4));
        bekle(2);


        // 2.Sosyal medya elemanlarını goruntusunu al
        WebElement linkedIn = driver.findElement(By.xpath("(//i[@class='fab fa-linkedin'])[1]"));
        String date5 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath5 = "src/test/java/techproed/ElementResmi/WEscreenShot" + date5 + ".jpeg";
        FileUtils.copyFile(linkedIn.getScreenshotAs(OutputType.FILE),new File(filePath5));
        bekle(2);


        // 2.Sosyal medya elemanlarını goruntusunu al
        WebElement mail = driver.findElement(By.xpath("html[1]/body[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[6]/a[1]"));
        String date6 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath6 = "src/test/java/techproed/ElementResmi/WEscreenShot" + date6 + ".jpeg";
        FileUtils.copyFile(mail.getScreenshotAs(OutputType.FILE),new File(filePath6));
        bekle(2);


        // 2.Sosyal medya elemanlarını goruntusunu al
        WebElement whatsapp = driver.findElement(By.xpath("(//i[@class='fab fa-whatsapp'])[1]"));
        String date7 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath7 = "src/test/java/techproed/ElementResmi/WEscreenShot" + date7 + ".jpeg";
        FileUtils.copyFile(whatsapp.getScreenshotAs(OutputType.FILE),new File(filePath7));
        bekle(2);

    }
}
