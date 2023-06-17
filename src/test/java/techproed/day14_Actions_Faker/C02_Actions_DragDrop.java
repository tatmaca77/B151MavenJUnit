package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {

    @Test
    public void test01() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        /**
          drag ve drop webelemetleri "iframe" icinde oldugu icin iframe'e gecis yapmaliyiz.
         */
        driver.switchTo().frame(0);  // 1 tane iframe oldugu icin index ile aldik 0 yaptik. Yada locate al.

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        bekle(2);
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();
        bekle(2);
        /**
             Eger bir hareketli webelement'i tutup baska bir webelement'in üzerine birakmak istersek
        sürüklemek istedigimiz webelementin locate'ini alip üzerine birakacagimiz webelementin locate'ini de alarak
        dragAndDrop(kaynak, hedef) methodu ile islemi gerceklestirebiliriz.
         */
    }

    /** ********** 2. YOL ********* */

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        /**
         drag ve drop webelemetleri "iframe" icinde oldugu icin iframe'e gecis yapmaliyiz.
         */
        driver.switchTo().frame(0);  // 1 tane iframe oldugu icin index ile aldik 0 yaptik. Yada locate al.

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        bekle(2);
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveToElement(drop).release().perform();
        bekle(2);

        //clickAndHold() --> Bu method ile webelemente mouse ile basili tuttuk.
        //moveToElement() --> Bu method ile basili tuttugumuz we'ti diger we'tin üzerine götürdük.
        //release() --> Bu method ile basili tuttugumuz webelement'i serbest biraktik.
        //perform() --> Bu method ile de islemi sonlandirdik.
    }

    @Test
    public void test03() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        /**
         drag ve drop webelemetleri "iframe" icinde oldugu icin iframe'e gecis yapmaliyiz.
         */
        driver.switchTo().frame(0);  // 1 tane iframe oldugu icin index ile aldik 0 yaptik. Yada locate al.

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        bekle(2);
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(84,28).release().perform();

        //moveByOffset() --> Beirtmis oldugumuz koordinatlara webelementi tasir.


    }
}
