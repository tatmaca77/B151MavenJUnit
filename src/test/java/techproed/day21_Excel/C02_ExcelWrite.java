package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {


    @Test
    public void excelWriteTest01() throws IOException {

        /**
        // Bir "Nüfus" sütunu olusturun
// baskent nufuslarını excel dosyasına yazınız.
// (D.C: 1000, Paris:1100, London:1200, Ankara:1300)
         */

        // Bir Nüfus Sütunu olusturunuz.
        String filePath = "src/test/java/resources/Capitals.xlsx"; //1.ADIM
        FileInputStream fis = new FileInputStream(filePath); // 2.ADIM
        Workbook workbook = WorkbookFactory.create(fis); // 3.ADIM

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");

        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1000");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100"); // Degistirdik
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(1200);
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(1300);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("1500");
        workbook.getSheet("Sheet1").getRow(8).createCell(2).setCellValue("2500");
        /**
        Ister tirnak icinde String olarak yaz istersen integer olarak. Tek farki sag veya sola yasli sekilde yazar.
         */

        /**
        Excel Tables'da bir Hücre yani Sütun olusturmak icin "createCell" kullanilir.
        Hücre icine yazdirmak istedigimiz deger icin "setCellValue" methodu kullanilir.
         */

        FileOutputStream fos = new FileOutputStream(filePath);
        /**
        Datalari bizim Classimizdan Capitals yani Excel icine göndermek icin "FileOutputStream" objesi olusturulur.
         */

        workbook.write(fos);
        /**
        workbook'taki datalari "fos" icine yazmis olduk.
         */

        fos.close();
        workbook.close();
    }
}
