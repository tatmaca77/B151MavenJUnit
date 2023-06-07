package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertions_Aufgabe {

    /**
       1)Bir class oluşturun: YoutubeAssertions
       2) https://www.youtube.com adresine gidin
       3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
          => Sayfa başlığının “YouTube” oldugunu test edin
          => YouTube resminin görüntülendiğini (isDisplayed()) test edin
          ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
          ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

     */
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Die YouTube-Tests haben jetzt begonnen.");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://www.youtube.com");
    }

    @Test
    public void test01() throws InterruptedException {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("YouTube", actualTitle);
        Thread.sleep(2000);

    }

    @Test
    public void test02() throws InterruptedException {
        WebElement akzeptieren = driver.findElement(By.xpath("(//div[@aria-hidden='true'])[29]"));
        akzeptieren.click();
        Thread.sleep(2000);
        WebElement logo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test03() throws InterruptedException {
        WebElement suchen = driver.findElement(By.xpath("//input[@placeholder='Suchen']"));
        Assert.assertTrue(suchen.isEnabled());
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.equals("youtube"));

        Thread.sleep(2000);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("YouTube-Test jetzt abgeschlossen");
    }

    @Test @Ignore
    public void ignore() {
        System.out.println("Zurzeit wird man nicht beginnen");
    }
}
