package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4j {

    @Test
    public void test01() {
        /**             -- Log4j --
        Log4j ==> system.out.println gibi her Test adimminda bilgilendirme yapmamiza yarayan bir API'dir.
             Log4j ile bu bilgilendirmeleri hem konsolda tarih saat olarak hemde src>main>resources icine koydugumuz
        Log4j.xml file da belirttigimiz .log uzantili dosyada yine tarih saat olarak kayit altina almis olacagiz.
             Log4j kullanabilmek icin öncelikle log4-api ve log4j-core dependencies mnvrepository.com adresinden
        (ayni version numaralarina sahip) alip pom.xml dosyamiza koymaliyiz.
             src>main>resources icine koydugumuz log4j.xml dosyasindaki kodlara pdf'deki adres'ten ulasabilirsiniz.
         */

        Logger logger = LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");



    }
}
