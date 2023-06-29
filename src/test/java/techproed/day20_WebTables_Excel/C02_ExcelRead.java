package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead extends TestBase {

    /**
       EXCEL dosyasından veri okuyabilmemiz için öncelikle pom.xml dosyamıza poi ve poi.ooxml dependency'lerini
   yüklememiz gerekir.
       Sonra üzerinde çalışacağımız excel dosyasını projemizde src>test>java>techpoed>resources package'i içine
   kayarız.
    */
    @Test
    public void test01() throws IOException {
        //1. - Dosya yolunu alırız
        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";

        //2. - Dosyayı okuyabilmemiz için javada akışa almamız gerekir
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3. - Java ortamında bir excel dosyası oluşturabilmek için;
        Workbook workbook = WorkbookFactory.create(fis);//-->Akışa aldığımız dosyayı okuyoruz

        //4. - Oluşturduğumuz excel'den sayfa(sheet) seçmemiz gerekir
        Sheet sheet = workbook.getSheet("Sheet1");

        //5. - Belirttiğimiz sayfaki satır(row) bilgisini seçmemiz gerekir
        Row row = sheet.getRow(0);//-->Satır da index 0(sıfır)'dan başladığı için 1. satırı getirir

        //6. - Belirttiğimiz satırdaki hücre(Cell) bilgisini seçmemiz gerekir
        Cell cell = row.getCell(0);

        //Son olarak cell bilgisini sout ile yazdırıp excel'deki 1.satır 1.hücredeki veriyi görebiliriz
        System.out.println(cell);

    }

    @Test
    public void test02() throws IOException {

        /** PRATİK ÇÖZÜM  */

        //1. Satır ve 1. sütun daki bilgileri yazdıralım
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String satir1Sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println("1. Satır 1. Sütun Bilgisi = "+satir1Sutun1);
    }

    @Test
    public void test03() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("3. Satir 1. Sütun bilgisi = "+satir3Sutun1);
        Assert.assertEquals("France",satir3Sutun1);

        //Kullanılan satır sayısın bulun
        System.out.println("Kullanılan Satir Sayisi : "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //NOT:getPhysicalNumberOfRows() methodu kullanılan yani içi dolu olan satırların sayısını verir.Index 1 den başlar

        //Sayfadaki satır sayısını yazdırınız
        System.out.println("Sayfadaki Satir Sayisi : "+workbook.getSheet("Sheet1").getLastRowNum());
        /** NOT:getLastRowNum() methodu sayfadaki son satırın sıra numarasını verir ve index 0(sıfır) dan başlar */


        /** Ülke-Başkent şeklinde verileri yazdırın */
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }
    }
}
