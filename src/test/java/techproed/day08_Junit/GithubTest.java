package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GithubTest {

    /**
       1. Bir Class olusturalim YanlisEmailTesti
       2. https://github.com/tatmaca77 sayfasina gidelim
       3. click to Repositories
       4. Email kutusuna @isareti olmayan bir mail yazip enter’a
           bastigimizda “Invalid email address” uyarisi ciktigini test edelim.

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
        driver.get("https://github.com/tatmaca77");
    }

    @Test
    public void test01() {
        WebElement repo = driver.findElement(By.xpath("(//a[@data-selected-links='repositories /tatmaca77?tab=repositories'])[1]"));
        repo.click();
    }
}
