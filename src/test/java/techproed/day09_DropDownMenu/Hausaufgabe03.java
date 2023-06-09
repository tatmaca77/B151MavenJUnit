package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Hausaufgabe03 {

    /**
    1.http://zero.webappsecurity.com/ Adresine gidin
    2.Sign in butonuna basin
    3.Login kutusuna “username” yazin
    4.Password kutusuna “password.” yazin
    5.Sign in tusuna basin(not: navigate.Back yapınız)
    6.Pay Bills sayfasina gidin
    7.“Purchase Foreign Currency” tusuna basin
    8.“Currency” drop down menusunden Eurozone’u secin
    9.“amount” kutusuna bir sayi girin
    10.“US Dollars” in secilmedigini test edin
    11.“Selected currency” butonunu secin
    12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
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
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void test01() {
        // 2.Sign in butonuna basin
        WebElement sigInButton = driver.findElement(By.xpath("(//button[@id='signin_button'])[1]"));
        sigInButton.click();

        Util_Class.bekle(2);

        // 3.Login kutusuna “username” yazin
        // 4.Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        // Sign in tusuna basin(not: navigate.Back yapınız)
        WebElement button = driver.findElement(By.xpath("//input[@value='Sign in']"));
        button.click();
        driver.navigate().back();

        Util_Class.bekle(2);

        // Pay Bills sayfasina gidin
        WebElement onlineBanking = driver.findElement(By.xpath("//li[@id='onlineBankingMenu']"));
        onlineBanking.click();
        Util_Class.bekle(2);
        WebElement payBills = driver.findElement(By.xpath("//span[text()='Pay Bills']"));
        payBills.click();

        Util_Class.bekle(2);

        // “Purchase Foreign Currency” tusuna basin
        WebElement purchaseForeign= driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']"));
        purchaseForeign.click();

        Util_Class.bekle(2);

        // “Currency” drop down menusunden Eurozone’u secin ve yazdirin.
        WebElement currency = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currency);
        select.selectByIndex(6);
        // Secileni yazdirin.
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Secilen : " + selectedOption.getText());

        // “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("20");

        // “US Dollars” in secilmedigini test edin
        WebElement dolar = driver.findElement(By.xpath("(//label[@class='radio inline'])[2]"));
        Assert.assertFalse(dolar.isSelected());

        // “Selected currency” butonunu secin
        WebElement selectedCurrency = driver.findElement(By.xpath("(//label[@class='radio inline'])[3]"));
        selectedCurrency.click();

        Util_Class.bekle(2);

        // “Calculate Costs” butonuna basin
        WebElement calculateCosts = driver.findElement(By.id("pc_calculate_costs"));
        calculateCosts.click();

        Util_Class.bekle(2);

        // “purchase” butonuna basin
        WebElement purchase = driver.findElement(By.id("purchase_cash"));
        purchase.click();

        // “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement result =driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']"));
        Assert.assertTrue(result.isDisplayed());

    }

    @Test @Ignore
    public void ignore() {
        System.out.println("Bu Test Daha sonra yapilacak...");
    }

    @After
    public void tearDown() throws Exception {
        Util_Class.bekle(2);
        driver.close();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("DropDownTest hat beendet.");
    }
}
