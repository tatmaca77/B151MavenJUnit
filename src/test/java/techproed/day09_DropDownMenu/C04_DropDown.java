package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDown {

    /**
     programming languages ddm den istediginiz 4 secenegi seciniz
     */

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass()  {
        System.out.println("Test Baslatildi.");
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
    public void test01()  {
        /**
         programming languages ddm den istediginiz 4 secenegi seciniz
         */
        WebElement programmingLanguages = driver.findElement(By.xpath("(//select)[6]"));
        Select options = new Select(programmingLanguages);
        options.selectByIndex(0);
        options.selectByIndex(4);
        options.selectByIndex(2);
        options.selectByVisibleText("Python");

        /** Eger sadece secili olan option'lari yazdirmak istiyorsak :*/
        options.getAllSelectedOptions().forEach(t-> System.out.println(t.getText())); /** LAMBDA */

        // getAllSelectedOptions() bana zaten List döndürdügü icin List'e atmaya gerek yoktur.
        System.out.println("****************************************");

        for ( WebElement w : options.getAllSelectedOptions()) {
            System.out.println(w.getText());                     /** FOREACH */
        }

        /** Seceneklerden 4 tane sectigimizi (verify) yani dogrulayalim. */
        Assert.assertEquals(4,options.getAllSelectedOptions().size());
        // Secili olan 4 tan eoldugu icin expected 4 ve diger method bize tüm seceneklerin size sayisini verir.

        System.out.println("*******************************");

        /** Sectigimiz seceneklerden ilkini yazdiralim. */
        System.out.println("Secilen seceneklerden ilki : " + options.getFirstSelectedOption().getText());

        /** Ilk secenegin Java oldugunu dogrulayalim (verify) */
        Assert.assertEquals("Java", options.getFirstSelectedOption().getText());

        bekle(3);

        /** Sectigimiz seceneklerin hepsini kaldirmak icin deselectAll() kullanilir. */
        options.deselectAll();

       bekle(3);

        /** sendKeys() methodu ile istedigimiz bir secenegi gönderelim. */
        programmingLanguages.sendKeys("C#");

        bekle(3);

        /** visibleText olarak secim yapacagimiz bir method olusturup programming languages ddm den
            bir secenek secelim.
         */
        selectVisibleText(programmingLanguages,"Java");

        bekle(3);

        /** Index olarak secim yapacagimiz bir method olusturup programming languages ddm den
         bir secenek secelim.
         */
        selectIndex(programmingLanguages,1);

        bekle(3);

        /** Value olarak secim yapacagimiz bir method olusturup programming languages ddm den
         bir secenek secelim.
         */
        selectValue(programmingLanguages,"python");  // Value da html kodlari arasindan option tag'indan bakmaliyiz. !!!!

        bekle(3);

    }

    public void selectVisibleText(WebElement ddm, String text) {
        Select options = new Select(ddm);
        options.selectByVisibleText(text);
    }

    public void selectIndex(WebElement ddm, int index) {
        Select options = new Select(ddm);
        options.selectByIndex(index);
    }                                                              /** Disarda ayri methodlar olusturduk. Ve sadece
                                                                    method isimlerinden ulastim. Daha proseffionel */

    public void selectValue(WebElement ddm, String value) {
        Select options = new Select(ddm);
        options.selectByValue(value);
    }

    public void bekle(int saniye) {
        try {                                    //try-catch ile exception yaptik. Method Signature
            Thread.sleep(saniye*1000);      // yapsaydik her yere yine exception atmaliydik.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test @Ignore
    public void ignore() {
        System.out.println("Bu test calismayacak.");
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
