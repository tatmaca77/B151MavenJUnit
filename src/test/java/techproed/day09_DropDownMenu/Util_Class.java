package techproed.day09_DropDownMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util_Class {



    public static void selectIndex(WebElement ddm, int index) {
        Select options = new Select(ddm);
        options.selectByIndex(index);
    }                                                              /** Disarda ayri methodlar olusturduk. Ve sadece
                                                                       method isimlerinden ulastim. Daha proseffionel */

    public static void selectValue(WebElement ddm, String value) {
        Select options = new Select(ddm);
        options.selectByValue(value);
    }

    public static void bekle(int saniye) {
        try {                                    //try-catch ile exception yaptik. Method Signature
            Thread.sleep(saniye*1000);      // yapsaydik her yere yine exception atmaliydik.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
