package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_BeforeClassAfterClass {

    /**
       @BeforeClass ve @AfterClass metodlari sadece static metodlar ile calisir.

     @BeforeClass = class'da en önce calisan methodtur.
     @AfterClass = class'da en son calisan methodtur.
    */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class'da en önce calisan methodtur.Sadece 1 kez calisir.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'da en son calisan methodtur.Sadece 1 kez calisir.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan önce calisir.");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra calisir.");
    }

    @Test
    public void test01() {
        System.out.println("Test 01 calisir.");
    }

    @Test
    public void test02() {
        System.out.println("Test 02 calisir.");
    }
}
