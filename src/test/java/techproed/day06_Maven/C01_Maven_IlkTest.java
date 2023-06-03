package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Maven_IlkTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // Hep fiziki olarak belirttigimiz browser yolunu belirttik.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /**
            https://www.amazon.com/ sayfasina gidiniz.
            arama kutusunu locate edelim
            "Samsung headphones" ile arama yapalim
            Bulunan sonuc sayisini yazdiralim
            Ilk urunu tiklayalim
            Sayfadaki tum basiklari yazdiralim

         */
        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("//span[text()='1-16 von 192 Ergebnissen oder Vorschlägen für']"));
        System.out.println(sonucYazisi.getText());

        String[] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println(sonucSayisi[2]);

        WebElement ilkUrun = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        ilkUrun.click();
        /** ALTERNATIVE */
        //driver.findElement(By.xpath("(//h2//a)[1]"));

        //Sayfadaki tum basiklari yazdiralim
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1 | //h2 "));
        /** driver.findElements(By.xpath("(//*[@class='nav-a  '])[1] | (//*[@class='nav-a  '])[2]")) */
        // Bu sekilde de index ile ve bu güzel xpath kullanimi ile alabiliriz.
        sayfaBasliklari.forEach(t -> System.out.println(t.getText()));
        /** Bu "XPath" kullanimi cok iyi bir yöntemdir. Bu sekilde sayfadaki bütün basliklari locate ederiz.
            Ve sonuc fazla oldugu icin onu bir "List" icine atmis olduk.
            Sonrasinda ekrana yazdiramk icin "Lambda" kullanrak yazdirmis olduk.
         */

        driver.quit();


    }




}
