package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Hausaufgabe02 {


    /**
    ●https://the-internet.herokuapp.com/dropdown adresine gidin.
      1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın  (yani secilen ilk degeri yazdirmak)
      2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
      3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
      4.Tüm dropdown değerleri(value) yazdırın
      5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        False yazdırın.
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("DropDownTest hat jetzt begonnen.");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void test01() {
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);

        //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        WebElement selectedOption = select.getFirstSelectedOption(); // (yani secilen ilk degeri yazdirmak)
        System.out.println("Secilen 1. secenek(Index ile) : " + selectedOption.getText());

        Util_Class.bekle(2);

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        selectedOption = select.getFirstSelectedOption();
        System.out.println("Secilen 2. secenek(Value ile) : " + selectedOption.getText());

        Util_Class.bekle(2);

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        selectedOption = select.getFirstSelectedOption();
        System.out.println("Value ile secilen secenek(VisibleText ile) : " + selectedOption.getText());

        // 4.Tüm dropdown değerleri(value) yazdırın
        select.getOptions().forEach(t-> System.out.println(t.getText()));

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        Assert.assertEquals(3,select.getOptions().size());
        System.out.println("True");

    }

    @After
    public void tearDown() throws Exception {
        Util_Class.bekle(2);
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Ab jetzt hat DropDownTest beendet.");
    }
}
