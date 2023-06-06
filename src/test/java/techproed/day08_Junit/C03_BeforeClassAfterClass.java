package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon Testi baslatildi.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Testi sonlandirildi.");
    }

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://amazon.com"); // Her iki test'te amazon'a gidecegimiz icin ortaktir buraya koyabiliriz.
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01 () {
        //driver.get("https://amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("samsung"
        +Keys.ENTER);
    }

    @Test
    public void test02() {
        //driver.get("https://amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone"
                +Keys.ENTER);
    }
}
