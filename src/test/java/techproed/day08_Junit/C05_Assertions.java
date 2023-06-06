package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {

    /**
    // 4 tane test methodu olusturun

// test01
// https://amazon.com sayfasına gidin
// sayfa baslıgının "Amazon" kelimesini icerdigini test edin


// test02
// https://amazon.com sayfasına gidin
// Amazon resminin görüntülendiğini (isDisplayed()) test edin


// test03
// https://amazon.com sayfasına gidin
// arama kutusunun erisilebilir oldugunu test edin


// test04
// https://amazon.com sayfasına gidin
// sayfa baslıgının "kitap" icermedigini test edin

    */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Test Baslatildi.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Test Sonlandirildi.");
    }

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void test01() {
        driver.get("https://amazon.com");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));
        // Sayfa basligi Amazon kelimesini iceriyor mu diye baktik.

    }

    @Test
    public void test02() {
        driver.get("https://amazon.com");
        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test03() {
        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Assert.assertTrue(aramaKutusu.isEnabled());

    }

    @Test
    public void test04() {
        driver.navigate().to("https://amazon.com");
        String actualTitle = driver.getTitle();
        //Assert.assertTrue(!actualTitle.contains("kitap"));
        Assert.assertFalse(actualTitle.contains("kitap"));

    }

    @Test @Ignore ("Bu Test Hazirda bekliyor. Suan da calistirilmayacaktir.")
    public void ignore() {
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
