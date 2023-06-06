package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C03_Class_Work {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        Thread.sleep(2000);

        // Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        Thread.sleep(2000);

        /**  3- Login alanina  “username” yazdirin
             4- Password alanine “password” yazdirin
             5- Sign in buttonuna tiklayin
         */ // Bu islemleri istersek tek b ir kod blogunda yazabiliriz.
        /*
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username", Keys.TAB,"password", Keys.ENTER);
        */

        // Login alanina  “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");

        Thread.sleep(2000);

        // Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        Thread.sleep(2000);

        // Sign in buttonuna tiklayin
        WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
        signIn.click();

        Thread.sleep(2000);

        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();

        Thread.sleep(2000);

        // Online Banking bölümüne tıklamalın
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        // 6- Online Banking bölümüne tıklamalın
        /**
          --> (//*[text()=.])[11] --> Bu sekilde text ile aldigimiz bir XPath'de text degisse bile biz o
                                      webelement'i handle edebiliriz.
         */

        Thread.sleep(2000);

        // Pay Bills yazan kısıma tıklayın
        //driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
        driver.findElement(By.xpath("(//h4)[4]//span")).click();

        Thread.sleep(2000);

        // 7- Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        // 8- Date kismina “2020-09-10” yazdirin
        // 9- Pay buttonuna tiklayin
        /** Eger istersek tek bir kod blogu ile bu 3 kodu yazabiliriz. */
        //driver.findElement(By.cssSelector("#sp_amount")).sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);
        /** Burda oldugu gibi yaparsak daha pratik ve hizli olur. Ancak tabikide hepsinin ayri ayri locate'ini alabiliriz. */

        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("100");

        Thread.sleep(2000);

        // Date kismina “2020-09-10” yazdirin
        WebElement date = driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2020-09-10");

        Thread.sleep(2000);

        // Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        Thread.sleep(2000);

        // 10- “The payment was successfully submitted.” mesajinin ciktigini test edin

        WebElement mesaj = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if(mesaj.isDisplayed()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        /** Bu 2 türlü kullanimlada istedigimizi yapabiliriz. */

        // 10- “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//span)[1]"));
        System.out.println(sonucYazisi.getText());

        if (sonucYazisi.getText().equals("The payment was successfully submitted.")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        Thread.sleep(2000);

        // Sayfayi kapatın
        driver.close();


    }

}
