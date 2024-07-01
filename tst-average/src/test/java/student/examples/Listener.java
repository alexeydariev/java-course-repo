package student.examples;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class Listener implements ITestListener {
    Workbook workbook;
    Sheet sheet;

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of test cases and its details are : "+result);
        insertDataInExcel(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of test cases and its details are : "+result.getName());
        insertDataInExcel(result);
    }

    @Override
    public void onStart(ITestContext context) {
        File file = new File("C:\\Users\\AlexeiD\\IdeaProjects\\tst-average\\test-run-2024-06-24.xlsx");
        if (file.exists()) {
            try {
                InputStream is = Files.newInputStream(file.toPath());
                workbook = new XSSFWorkbook(is);
                sheet = workbook.createSheet(context.getName() + "-" + new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss-SSS").format(new Date()));
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(context.getName() + "-" + new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss").format(new Date()));
        }
        setColumnNames();
    }

    private String currentDateFormat () {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }

    @Override
    public void onFinish(ITestContext context) {
        String fileName = "test-run-"+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".xlsx";
        try {
            File f = new File(fileName);
            FileOutputStream out = new FileOutputStream(fileName);
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setColumnNames() {
        Row row = sheet.createRow(sheet.getLastRowNum()+1);
        row.createCell(row.getLastCellNum()+1).setCellValue("Test Method");
        row.createCell(row.getLastCellNum()).setCellValue("Inputs");
        row.createCell(row.getLastCellNum()).setCellValue("Expected");
        row.createCell(row.getLastCellNum()).setCellValue("Passed");
    }

    private void insertDataInExcel(ITestResult result){
        Row row = sheet.createRow(sheet.getLastRowNum()+1);
        row.createCell(row.getLastCellNum()+1).setCellValue(result.getName());
        row.createCell(row.getLastCellNum()).setCellValue(((InputsParser) (result.getParameters()[0])).getInputs().toString());
        row.createCell(row.getLastCellNum()).setCellValue(((InputsParser) (result.getParameters()[0])).getExpected().toString());
        row.createCell(row.getLastCellNum()).setCellValue(result.isSuccess());
    }
}
