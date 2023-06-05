package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {

    public static void main(String[] args) throws InterruptedException {

        /**
        1.http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3. Login alanine “username” yazdirin
        4. Password alanine “password” yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Bills sayfasina gidin
        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8. tarih kismina “2020-09-10” yazdirin
        9. Pay buttonuna tiklayin
        10.“The payment was successfully submitted.” mesajinin ciktigini
        control edin
       */

        WebDriverManager.chromedriver().setup(); // Hep fiziki olarak belirttigimiz browser yolunu belirttik.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://zero.webappsecurity.com");

        Thread.sleep(2000);

        WebElement signIn = driver.findElement(By.xpath("//button[@id='signin_button']"));
        signIn.click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        Thread.sleep(3000);

        WebElement signIn2 = driver.findElement(By.xpath("//input[@type='submit']"));
        signIn2.click();

        Thread.sleep(3000);

        driver.navigate().back(); // Wegen des Sicherheitsmauerer

        driver.findElement(By.xpath("//strong[text()='Online Banking']" + Keys.ENTER));

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Pay Bills']" + Keys.ENTER));

        Thread.sleep(3000);

        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("20");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@class='btn btn-primary']" + Keys.ENTER));




    }
}
