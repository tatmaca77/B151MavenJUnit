package techproed.day17_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_NullPointerException {

    /**
    NullPointerException : Degisken ya da Object olusturup bu degiskene atama yapmadigimizda
                           ya da esitlemedigimizde NullPointerException hatasi aliriz. !!!!!
     */

    WebDriver driver;

    Faker faker;

    Actions actions;

    Integer sayi;

    String isim;

    @Test
    public void nullPointerExceptionTest01() {
        /**
        driver = new ChromeDriver(); atamasini yapmadigimiz icin NullPointerException hatasi aldik.
         */
        driver.get("https://amazon.com");
    }

    @Test
    public void nullPointerExceptionTest02() {
        /**
        faker = new Faker(); atamasini yapmadigimiz icin NullPointerException hatasi aldik.
         */
        System.out.println(faker.name().firstName());
    }

    @Test
    public void nullPointerExceptionTest03() {
        /**
        actions = new Actions(); atamasini yapmadigimiz icin NullPointerException hatasi aldik.
         */
        actions.doubleClick().perform();
    }

    @Test
    public void nullPointerExceptionTest04() {
        /**
        sayi = 6; sayi degiskenine atama yapmadigimiz icin NullPointerException hatasi aldik.
         */
        System.out.println(sayi+5);
    }

    @Test
    public void nullPointerExceptionTest05() {
        /**
        isim = Maho; isim degiskenine atama yapmadigimiz icin NullPointerException hatasi aldik.
         */
        System.out.println(isim);
    }
}
