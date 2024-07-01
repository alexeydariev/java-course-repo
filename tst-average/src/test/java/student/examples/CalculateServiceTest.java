package student.examples;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Listeners(student.examples.Listener.class)
public class CalculateServiceTest {
    private List<String> results = new ArrayList<>();

    //TODO: verify pass strength
    @BeforeTest
    public void setUp() {
    }

    @DataProvider(name = "inputsFromExcel")
    public InputsParser[] providePwds() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\AlexeiD\\IdeaProjects\\tst-average\\src\\test\\resources\\inputs.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        InputsParser[] ip = new InputsParser[sheet.getLastRowNum()+1];
        int i = 0;
        for (Row row : sheet) {
            ip[i] = new InputsParser(row);
            i++;
        }
        return ip;
    }

    @Test(dataProvider = "inputsFromExcel")
    public void testCalculateAverage(InputsParser ip) {
        try {
            Assert.assertEquals(new CalculateService().calculateAverage(ip.getInputs()), ip.getExpected());
        } catch (EmptyListException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void aggregateResults(ITestResult result){
        System.out.println(result.isSuccess());
        results.add(Arrays.toString(result.getParameters()));
    }

    @AfterClass(alwaysRun = true)
    public void createReports() {
        System.out.println("AAAA" + results);
    }

}
//TODO:test which checks avg from ints
//function should now accept more than one value
//expected