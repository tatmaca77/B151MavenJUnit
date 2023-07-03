package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_Training {

    @Test
    public void excelWrite() throws IOException {
        /**
         // Bir "Nüfus" sütunu olusturun
         // baskent nufuslarını excel dosyasına yazınız.
         // (D.C: 1000, Paris:1100, London:1200, Ankara:1300)
         */
        String filePath = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("Sheet1").getRow(0).createCell(3).setCellValue("NUFUS ARTISI");

        workbook.getSheet("Sheet1").getRow(1).createCell(3).setCellValue("%2,5");
        workbook.getSheet("Sheet1").getRow(2).createCell(3).setCellValue("%2,5");
        workbook.getSheet("Sheet1").getRow(3).createCell(3).setCellValue("%2,5");
        workbook.getSheet("Sheet1").getRow(4).createCell(3).setCellValue("%2,5");

        FileOutputStream fos = new FileOutputStream(filePath);

        workbook.write(fos);








    }
}
