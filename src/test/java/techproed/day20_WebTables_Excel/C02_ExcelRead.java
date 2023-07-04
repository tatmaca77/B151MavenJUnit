package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {

    /**
       EXCEL dosyasından veri okuyabilmemiz için öncelikle pom.xml dosyamıza poi ve poi.ooxml dependency'lerini
   yüklememiz gerekir.
       Sonra üzerinde çalışacağımız excel dosyasını projemizde src>test>java>techpoed>resources package'i içine
   kayarız.
    */

    @Test
    public void readExcelTest01() throws IOException {
        /*
        // 3. satir 1. sütun degerini yazdirin France Test
        // Excel File Path
         */

        /** Excel'deki 3 banko Adim asagidaki gibidir. */

        /** First Step */
        String filePath = "src/test/java/resources/Capitals.xlsx";


        /** Second Step */
        // Capital Files input etmeliyiz. Sistemimize getirmeliyiz.
        FileInputStream fis = new FileInputStream(filePath);  // Dosyayi okuyabilmemiz icin akisa almaliyiz. Stream ile.


        /** Third Step */
        // Dosyayi Workbook'a atamaliyiz. JAVA ortaminda bir Excel dosyasi olusturmaliyiz.
        Workbook workbook = WorkbookFactory.create(fis);
    }
}

