package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

        Thread.sleep(2000);

        // Pay Bills yazan kısıma tıklayın
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();

        Thread.sleep(2000);

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

        // “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement mesaj = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if(mesaj.isDisplayed()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        Thread.sleep(2000);

        // Sayfayi kapatın
        driver.close();


    }

}
