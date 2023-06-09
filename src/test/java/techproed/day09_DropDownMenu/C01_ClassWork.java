package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    /**
    1)https://amazon.com adresine gidin
    2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
        ○ title Test  => Sayfa başlığının "Amazon" kelimesini içerip içermediğini test edin
        ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        ○ wrongTitleTest => Sayfa basliginin "amazon" içermediğini doğrulayın
     */

    /**
       @Before ve @After kullnamayinca, onlar yerine Class kullaninca tek bir sayfa üzerinde islemler yapilir.
       Eger kullanirsak her bir Test Cse icin ayri ayri sayfalar acilacak ve kapatilacakti.
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @Test
    public void titleTest() {
        //○ title Test  => Sayfa başlığının "Amazon" kelimesini içerip içermediğini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone" + Keys.ENTER + Keys.CLEAR);
        driver.navigate().back();

        Util_Class.bekle(3);

     // Eger CLEAR yapmazsak aramalari yanyana yazar.

    }

    @Test
    public void imageTest() {
        //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(image.isDisplayed());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung" + Keys.ENTER);
        driver.navigate().back();
        Util_Class.bekle(3);
    }

    @Test
    public void searchBoxTest() {
        //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nokia" + Keys.ENTER);
        driver.navigate().back();
    }

    @Test
    public void wrongTitleTest() {
        //○ wrongTitleTest => Sayfa basliginin "amazon" içermediğini doğrulayın
        String actualTitle = driver.getTitle();//Amazon ....
        String expectedTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Util_Class.bekle(3);
        driver.close();
    }
    // After koyarsam her test icin Web acilir sonra kapanir.
}
