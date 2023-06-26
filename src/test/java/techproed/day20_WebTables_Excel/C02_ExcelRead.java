package techproed.day20_WebTables_Excel;

import techproed.utilities.TestBase;

import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead extends TestBase {

    @Test
    public void excelReadTest1() throws IOException {

        // excel dosyasından veri okuyabilmemiz icin;
        // 1- dosya yolunu alırız
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        // 2- Capitals dosyasını bizim sistemimize getirmeliyiz. Dosyayı okuyabilmek icin akışa almalıyız.
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3- dosyayı workbook'a atamalıyız. Java ortamında bir excel dosyası olusturmalıyız.


    }

    @Test
    public void readExcelTest2() throws IOException {
        // KISA YÖNTEM

        // 1.satır 1.sütundaki bilgiyi yazdırınız

        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);




    }

    @Test
    public void readExcelTest3() throws IOException {

        // 1.satır 2.sutundaki hücreyi yazdırın

        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);







    }
}
