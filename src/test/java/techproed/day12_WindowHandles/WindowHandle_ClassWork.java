package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class WindowHandle_ClassWork extends TestBase {

    /**
    // 1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
// 2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
// 3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
     */

    @Test
    public void windowHandle() {

        // 1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.navigate().to("https://techproeducation.com/");
        String techproActualTitle = driver.getTitle();
        String techproExpectedTitle = "Techpro Education";
        Assert.assertTrue(techproActualTitle.contains(techproExpectedTitle));
        System.out.println("TechPro Education Title : " + techproActualTitle);

        // 2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com/");
        String amazonActualTitle = driver.getTitle();
        String amazonExpectedTitle = "Amazon";
        Assert.assertTrue(amazonActualTitle.contains(amazonExpectedTitle));
        System.out.println("Amazon Title : " + amazonActualTitle);

        // 3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com/feed/");
        String linkedInActualTitle = driver.getTitle();
        String linkedInExpectedTitle = "LinkedIn";
        Assert.assertTrue(linkedInActualTitle.contains(linkedInExpectedTitle));
        System.out.println("LinkedIn Title : " + linkedInActualTitle);


    }
}
