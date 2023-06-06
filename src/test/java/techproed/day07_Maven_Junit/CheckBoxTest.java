package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckBoxTest {

    /**
    1.Bir class oluşturun : CheckBoxTest
     2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
          a. Verilen web sayfasına gidin.
             https://the-internet.herokuapp.com/checkboxes
              b. Checkbox1 ve checkbox2 elementlerini locate
            edin.
                 c. Checkbox1 seçili değilse onay kutusunu tıklayın
                        d. Checkbox2 seçili değilse onay kutusunu tıklayın

     */
WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Thread.sleep(2000);
        checkBox1.click();
        Thread.sleep(2000);
        checkBox2.click();
        Thread.sleep(2000);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
