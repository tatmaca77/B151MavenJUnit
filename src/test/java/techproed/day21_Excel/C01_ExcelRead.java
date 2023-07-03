package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

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


        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satir3Sutun1);


        Assert.assertEquals("France", satir3Sutun1);





        /** getSheet("Sheet1") ==> Sag alt kösede sayfanin ismi yazar bunu belirtmis oluruz. */
        /** getRow(2) ==> index kullanarak 3.satirdaki veriyi aldik */
        /** getCell(0); ==> index kullanarak 1.sütunualdik */
        /** toString(); ==> String'e cevirdim ve assign ettim hata gitti. */






        /*
        //Son satir sayisini bakalim
         */
        int lastRowNumber = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Son Satir Sayisi : " + (lastRowNumber+1));  // Sonucu bize index olarak verir. Aslinda 11 veri var ama index'den dolayi 10 yazar.


        /** getLastRowNum(); ==> Excel'deki son satir sayisini index olarak bize verir.
                                 Bu sebeple +1 yaparim ve tam olarak son satir sayisini almis oluruz.*/



        // Kullanilan Satir Saysini bulalim
        int physicalNumberOfRows = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("Kullanilan Satir Sayisi : " + physicalNumberOfRows);


        /** getPhysicalNumberOfRows() ==> bu method ile kullanilanSatir sayisini buluruz.
                                         Index'i 0 dan degil 1 den baslatir.*/

    }

    @Test
    public void readExcelTest02() throws IOException {
        /**
          Tüm Verileri almak istersek; "MAP" en uygun JAVA objesidir. Cünkü Key-Value iliskisi vardir.
          Bu sebeple ilk sütun Key olur 2.Sütun Value olur.
         */

        //Capital Dosyasindaki tüm verileri yazdiriniz. !!!!!!

        Map<String,String> capitalsMap = new HashMap<>();
        /**
        Capitals Dosyasindaki tüm verileri koyabilecegimiz en uygun JAVA objesi Map'tir. Ve iki degerde yani
        hem "Key" hem de "Value" String oldugu icin parantez icleri String oldu.
         */


        /** First Step */
        String filePath = "src/test/java/resources/Capitals.xlsx";


        /** Second Step */
        // Capital Files input etmeliyiz. Sistemimize getirmeliyiz.
        FileInputStream fis = new FileInputStream(filePath);  // Dosyayi okuyabilmemiz icin akisa almaliyiz. Stream ile.


        /** Third Step */
        // Dosyayi Workbook'a atamaliyiz. JAVA ortaminda bir Excel dosyasi olusturmaliyiz.
        Workbook workbook = WorkbookFactory.create(fis);


        /**For loop öncesinde i nereye kadar gitmeli sorusunun cevabi olarak son satir sayisini bulduk */
        int lastRowNumber = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Son Satir Sayisi : " + lastRowNumber);


        /** For-loop ile key-value belirledik ve onlari put ile Map icine attik, sonra yazdirdik. */
        for (int i = 0; i < lastRowNumber; i++) {
            String key = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            capitalsMap.put(key, value);
        }
        System.out.println("Tüm Veriler : " + capitalsMap);

    }
}
