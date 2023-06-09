package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown_ClassWork {

    /**
      ● Bir class oluşturun: DropDown
      ● https://the-internet.herokuapp.com/dropdown adresine gidin.
           1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
           2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
           3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
           4.Tüm dropdown değerleri(value) yazdırın
           5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("DropDown Test baslatildi...");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(ddm);
        ddm.click();
        Thread.sleep(2000);
        options.selectByIndex(1);
        WebElement selectedOption = options.getFirstSelectedOption();
        System.out.println("Secilen Ilk Secenek : " + selectedOption.getText());
        ddm.click();
        Thread.sleep(2000);
        options.selectByValue("2");
        selectedOption = options.getFirstSelectedOption();
        System.out.println("Secilen 2. Secenek : " + selectedOption.getText());
        options.getOptions().forEach(t-> System.out.println(t.getText()));
        ddm.click();
        Thread.sleep(2000);
        options.selectByVisibleText("Option 1");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("DropDown Test sonlandirildi...");
    }
}
