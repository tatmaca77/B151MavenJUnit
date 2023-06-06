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

public class RadioButtonTest {

    /**
    1.Bir class oluşturun : RadioButtonTest
    2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
          - https://www.facebook.com adresine gidin
          - Cookies’i kabul edin
          - “Create an Account” button’una basin
          - “radio buttons” elementlerini locate edin
          - Secili degilse cinsiyet butonundan size uygun olani secin.
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
        driver.get("https://www.facebook.com");
        WebElement cookies = driver.findElement(By.xpath("//button[@title='Alle Cookies erlauben']"));
        cookies.click();
        Thread.sleep(2000);
        WebElement neuesKonto = driver.findElement(By.xpath("//a[@rel='async']"));
        neuesKonto.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Vorname']"));
        driver.findElement(By.xpath("//input[@name='lastname']"));
        driver.findElement(By.xpath("//input[@name='reg_email__']"));
        driver.findElement(By.id("password_step_input"));
        WebElement männlich = driver.findElement(By.xpath("//label[text()='Männlich']"));
        männlich.click();
        Thread.sleep(2000);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
