package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;             // Resable Methodlar kullanilir.
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

    /**
       TestBase =>

       Class'indan Object olusturmanin önüne gecmek icin bu class'i abstract yapabiliriz.

       TestBase testBase = new TestBase(); yani bu sekilde obje olusturmanin önüne gecmis oluruz.

       Bu Class'a extends yaptigimiz test class'larindan ulasabiliriz.

     */

    protected static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    /** HARD WAIT ( Bekleme Methodu ) */
    public static void bekle (int saniye) {
        try {                                    //try-catch ile exception yaptik. Method Signature
            Thread.sleep(saniye*1000);      // yapsaydik her yere yine exception atmaliydik.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /** AcceptAlert */
    public static void acceptAlert () {
        driver.switchTo().alert().accept();
    }

    /** DissmissAlert */
    public static void dismissAlert () {
        driver.switchTo().alert().dismiss();
    }

    /** getTextAlert */
    public static String getTextAlert () {
        return driver.switchTo().alert().getText();  // Sonuc olarak verilen Texti String olarak aldik.
    }

    /** sendKeysAlert */
    public static void sendKeysAlert (String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    /** DropDown VisibleText */
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    /** DropDown Index */
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    /** DropDown Value */
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    /** Explicit Wait */
    public void visibleWait(WebElement locate, int seconds ){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(locate));

    }





}
