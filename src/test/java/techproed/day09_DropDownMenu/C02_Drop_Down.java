package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Drop_Down {

    /**
      DROPDOWN --> Altbasliklarin oldugu acilir menü listesidir.
               Dropdown'u handle(automate) etmek icin :
     1-) Dropdown menüyü ilk olarak locate ederiz.
     2-) Select Object'i olustururuz.
     3-) Select object'inin ddm webelementinin icerigine ve seceneklerine erisim saglamasi icin
         SELECT sinifina argüman olarak locate ettigimiz webelement'i koyariz.
     SYNTAX :
             Select options = new Select(ddm webelementi)
     4-) Select class'i sadece <select> tag'i ile olusturulmus dropdown menülere uygulanabilir.
     5-) select objesi ddm'yü handle edebilmek icin 3 method kullanilir.
         - selectByVisibleText() --> Ddm deki elemente görünür metin ile ulasmak icin kullanilir.
         - selectByIndex() --> Index ile ulasmak icin kullanilir. (Index 0(sifir)'dan baslar.)
         - selectByValue() --> Element'in degeri ile ulasmak icin kullanilir.(option tag'larindaki deger ile)
     6-) getOptions() --> Locate ettigimiz ddm'deki tüm secenekleri bize verir.(List'e atip loop ile yazdirabiliriz.)
     7-) getFirstSelectedOption() --> Ddm'deki secili kalan secenegi bize verir. Birden fazla secenek
                                      secildiyse, bu secilenlerin ilkini bize verir.
     8-) Ddm'ye sendKeys() methodu ile de dropdown menu'deki seceneklerden birini kullanabiliriz.
     */

    /**
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Diese Tests haben jetzt begonnen.");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() throws InterruptedException {
        /**1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz */
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement month = driver.findElement(By.xpath("(//select)[3]"));
        WebElement date = driver.findElement(By.xpath("(//select)[4]"));

        Select options1 = new Select(year);
        Select options2 = new Select(month);
        Select options3 = new Select(date);

        options1.selectByIndex(5);
        Thread.sleep(2000);
        options2.selectByValue("3");//Index degil sadece de value alir. "" icine yaz o degeri verir.
        Thread.sleep(2000);
        options3.selectByVisibleText("28");
    }

    @Test
    public void test02() {
        /**
        2.Method:
        a. Tüm eyalet isimlerini yazdıralım
         */
        WebElement states = driver.findElement(By.xpath("//select[@id='state']"));
        Select options = new Select(states);
        options.getOptions().forEach(t-> System.out.println(t.getText())); /** LAMBDA */
        /** Lambda veya forEach ile yazdirabiliriz. */

        System.out.println("***********************************");
        // 2.YOL
        List<WebElement> eyaletler = driver.findElements(By.xpath("//select[@id='state']"));
        /** eyaletler.stream().forEach(t-> System.out.println(t.getText())); */
        for (WebElement w : eyaletler) {
            System.out.println(w.getText());  // Foreach ile de yazdirabiliriz.
        }
    }

    @Test
    public void test03() {
        /**
        3.Method:
        a. State dropdownindaki varsayilan secili secenegin
         'Select a State' oldugunu verify edelim
         */
        WebElement states = driver.findElement(By.xpath("//select[@id='state']"));
        Select options = new Select(states);
        String defaultOption = options.getFirstSelectedOption().getText(); // Varsayilani String yaptik.
        System.out.println("Secili olan Secenek : " + defaultOption); // Yazdirdik
        Assert.assertEquals("Select a State",defaultOption);// Assert ile kontrol ettik.
        Assert.assertTrue(defaultOption.contains("Select"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Test sonlandirildi.");
    }
}
