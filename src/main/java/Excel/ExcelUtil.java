package Excel;

import java.io.File;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

import static Page.PageBase.random12Digits;


public class ExcelUtil {

    public static File createExcelFile(String amount) throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("addfile");

        // Header
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("code");
        header.createCell(1).setCellValue("Amount");

        // Data
        for (int i = 1; i <= 500; i++) {
        Row row1 = sheet.createRow(i);
        row1.createCell(0).setCellValue(random12Digits());
        row1.createCell(1).setCellValue(amount);

}
        File file = new File("uploadfile.xlsx");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        }

        workbook.close();
        return file;
    }
}

