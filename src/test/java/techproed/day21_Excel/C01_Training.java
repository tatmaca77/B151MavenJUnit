package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_Training {

    @Test
    public void test01() throws IOException {
        /**
        Excel Tablasunda islem yaparken bu 3 Adim aklima gelmelidir. Bu 3 Adim cok önemlidir.
         */

        String filePath = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);


        String row5Cell1 = workbook.getSheet("Sheet1").getRow(5).getCell(1).toString();
        System.out.println("5.Satir 1.Sutun :" + row5Cell1);


        Assert.assertEquals("Athens", row5Cell1);

    }

    @Test
    public void test02() throws IOException {
        String filePath = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        // Last Cell Number
        int lastRowNum = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Last Row Number :" + (lastRowNum+1));

        // Kullanilan Satir Saysini bulalim
        int useToRowNum = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("Used to Row Number :" + useToRowNum);
    }
}
