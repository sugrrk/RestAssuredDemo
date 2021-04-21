package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelUtils {
    public static void main(String[] args) {
        getRowCount();
        getCellData();

    }

    public static void getCellData() {

        try {
            String excelPath = "C:\\Users\\suganya\\RestAssuredDemo\\RestAssuredDemo\\ExcelData\\NewDataFile.xlsx";

            XSSFWorkbook wb = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = wb.getSheet("Sheet1");
            DataFormatter formatter = new DataFormatter();
            Object value = formatter.formatCellValue(sheet.getRow(1).getCell(1));
          //double value =  sheet.getRow(1).getCell(2).getNumericCellValue();
            System.out.println(value);

        } catch (Exception exp) {
            System.out.println(exp.getMessage());

            exp.printStackTrace();

        }
    }

        public static void getRowCount(){
            try {
                String excelPath = "C:\\Users\\suganya\\RestAssuredDemo\\RestAssuredDemo\\ExcelData\\NewDataFile.xlsx";

                XSSFWorkbook wb = new XSSFWorkbook(excelPath);
                XSSFSheet sheet = wb.getSheet("Sheet1");
                int rowCount = sheet.getLastRowNum();
                System.out.println("No of rows :" + rowCount);

            } catch (Exception exp) {
                System.out.println(exp.getMessage());

                exp.printStackTrace();

            }
        }

    }

