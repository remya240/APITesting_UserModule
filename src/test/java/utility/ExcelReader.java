package utility;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader implements Closeable {

    private String filePath;
    private FileInputStream fileInputStream;
    private Workbook workbook;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        }
    }

    @Override
    public void close() throws IOException {
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        if (workbook != null) {
            workbook.close();
        }
    }
}
