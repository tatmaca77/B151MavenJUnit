package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {
    WebDriver driver; //WebDriver driver disarda olusturduk. Cünkü her method icinde ayri ayri driver objesi yazmaliydik.
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void techproedTest2() {                      // Test yaparken siralama yapmak method isminde cok önemlidir.
        driver.get("https://techproeducation.com");
    }

    @Test          // Techpro üstte olmasina ragmen method ismine sayisal isim verildigi icin amazon önce calisir.
    public void amazonTest1() {
        driver.navigate().to("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her class'tan önce bir kez calisir.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class'tan sonra bir kez calisir.'");
    }

    /**
       @Before ve @After Class her zaman "static" tir.
      Method'lari static'tir. !!!!!!!!!!!!!!
     */
}
