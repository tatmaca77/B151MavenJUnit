package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClassWork {

    /**
     https://the-internet.herokuapp.com/checkboxes sayfasına gidin.
             Checkbox1 ve checkbox2 elementlerini locate edin.
             Checkbox1 seçili değilse secin
             Checkbox2 seçili değilse secin
      */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("CheckBox Test baslatildi.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("CheckBox Test sonlandirildi.");
    }

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test @Ignore ("Amazon gitmekten vaz gectik.")
    public void ignore() {
        driver.get("https://amazon.com");
    }

    @Test
    public void testBoxes() throws InterruptedException {
        // https://the-internet.herokuapp.com/checkboxes sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        Thread.sleep(2000);

        // Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        // Checkbox1 seçili değilse secin
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }

        Thread.sleep(2000);

        //  Checkbox2 seçili ise secin ve secili olmayacak durumda olsun
        if (checkBox2.isSelected()) {
            checkBox2.click();
        }

        Thread.sleep(2000);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
