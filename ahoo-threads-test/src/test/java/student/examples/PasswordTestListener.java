package student.examples;

import org.apache.poi.ss.usermodel.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PasswordTestListener implements ITestListener {

    private List<Boolean> results;

    @Override
    public void onStart(ITestContext context) {
        results = new ArrayList<>();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        results.add(true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        results.add(false);
    }

    @Override
    public void onFinish(ITestContext context) {
        File file = new File("C:\\Users\\AlexeiD\\IdeaProjects\\ahoo-threads-test\\src\\test\\resources\\sample1.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet("Sheet1");
            int rowIdx = 0;
            for (Boolean result: results) {
                System.out.println("INDEXES " + rowIdx );
                Row row = sheet.getRow(rowIdx);

                if (row != null) {
                    Cell cell = row.createCell(1);
                    cell.setCellValue(result);
                }
                ++rowIdx;
            }
            fis.close();
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
