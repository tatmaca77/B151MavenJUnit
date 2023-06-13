package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {

    /**
    //  https://www.techproeducation.com adresine gidiniz
    //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin

//  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

//  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz

//  techproeducation sayfasına geçiniz
//  youtube sayfasına geçiniz
//  linkedIn sayfasına geçiniz:
     */

    @Test
    public void windowHandle() {
        //  https://www.techproeducation.com adresine gidiniz
        driver.get(" https://www.techproeducation.com");
        /**
           techproeducation sayfasinin handle degerini getWindowHandle() methodu ile
           elde edebiliriz. Sayfalar arasi gecis yapabilmek icin handle degerleri gereklidir. !!!
         */
        String techproWindowHandle = driver.getWindowHandle();
        System.out.println("Techpro Window Handle : " + techproWindowHandle);

        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
        String actualTitle = driver.getTitle();
        String expextedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expextedTitle,actualTitle);

        //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);// Yeni bir pencereye driver'i tasidik.
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();
        System.out.println("Youtube Window Handle : " + youtubeWindowHandle);

        // Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedInWindowHandle = driver.getWindowHandle();
        System.out.println("LinkedIn Window Handle : " + linkedInWindowHandle);

        //  techproeducation sayfasına geçiniz
        driver.switchTo().window(techproWindowHandle);
        bekle(2);

        //  youtube sayfasına geçiniz
        driver.switchTo().window(youtubeWindowHandle);
        bekle(2);

        // linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedInWindowHandle);
        bekle(2);
    }
}
