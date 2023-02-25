import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class XLSXHelper {

    public static void writeTablesTest(double[] x, double[] y1, double[] y2, double[] u, double[] pogr, String fileName, double maxPogr) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
        setUpStartTest(sheet, maxPogr);

        for (int i = 0; i < x.length; i++) {
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(x[i]);
            row.createCell(1).setCellValue(y1[i]);
            row.createCell(2).setCellValue(y2[i]);
            row.createCell(3).setCellValue(u[i]);
            row.createCell(4).setCellValue(pogr[i]);
        }

        FileOutputStream out = new FileOutputStream(
                fileName + ".xlsx");

        workbook.write(out);
        out.close();
    }

    private static void setUpStartTest(XSSFSheet sheet, double maxPogr) {
        XSSFRow startRow = sheet.createRow(0);
        startRow.createCell(0).setCellValue("x");
        startRow.createCell(1).setCellValue("y1");
        startRow.createCell(2).setCellValue("y2");
        startRow.createCell(3).setCellValue("u");
        startRow.createCell(4).setCellValue("pogr");
        startRow.createCell(7).setCellValue("maxPogr:");
        startRow.createCell(8).setCellValue(maxPogr);
    }

    public static void writeTablesMain(double[] x, double[] y1, double[] y2, String fileName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
        setUpStartMain(sheet);

        for (int i = 0; i < x.length; i++) {
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(x[i]);
            row.createCell(1).setCellValue(y1[i]);
            row.createCell(2).setCellValue(y2[i]);
        }

        FileOutputStream out = new FileOutputStream(
                fileName + ".xlsx");

        workbook.write(out);
        out.close();
    }

    private static void setUpStartMain(XSSFSheet sheet) {
        XSSFRow startRow = sheet.createRow(0);
        startRow.createCell(0).setCellValue("t");
        startRow.createCell(1).setCellValue("x");
        startRow.createCell(2).setCellValue("θ");
    }
}
