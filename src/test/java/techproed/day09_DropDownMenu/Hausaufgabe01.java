package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Hausaufgabe01 {

    /**
    ●https://www.amazon.com/ adresine gidin.
           -Test 1
               Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
               oldugunu test edin
           -Test 2
               1.Kategori menusunden Books secenegini secin
               2.Arama kutusuna Java yazin ve aratin
               3.Bulunan sonuc sayisini yazdirin
               4.Sonucun Java kelimesini icerdigini test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Test hat begonnen.");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.com/ ");
    }

    @Test
    public void test01() {
        WebElement kategorien = driver.findElement(By.id("nav-search-dropdown-card"));
        Select options = new Select(kategorien);


        Assert.assertEquals(28,options.getOptions().size());





    }

    @Test
    public void test02() {
        WebElement kategorien = driver.findElement(By.id("nav-search-dropdown-card"));
        kategorien.click();
        Select options = new Select(kategorien);
        options.selectByIndex(3);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

    }
}
