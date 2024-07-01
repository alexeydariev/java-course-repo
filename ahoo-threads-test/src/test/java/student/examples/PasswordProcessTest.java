package student.examples;

import com.github.pjfanning.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Listeners(PasswordTestListener.class)
public class PasswordProcessTest {
    //TODO: verify pass strength
    @BeforeTest
    public void setUp() {
    }

    @DataProvider(name = "providePwds")
    public Iterator<String> providePwds() throws FileNotFoundException {
        List<String> passwords = new ArrayList<>();
        try (
                InputStream is = Files.newInputStream(new File("C:\\Users\\AlexeiD\\IdeaProjects\\ahoo-threads-test\\src\\test\\resources\\sample1.xlsx").toPath());
                Workbook workbook = StreamingReader.builder()
                    .rowCacheSize(100)
                    .bufferSize(4096)
                    .open(is)
        ){
            for (Sheet sheet : workbook){
                for (Row r : sheet) {
                        passwords.add(r.getCell(0).getStringCellValue());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return passwords.iterator();
    }


    @Test(dataProvider = "providePwds")
    public void testPasswordStrength(String password){
        Pattern pattern = Pattern
                .compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = pattern.matcher(password);
        Assert.assertTrue(matcher.matches());
    }

    @AfterClass(alwaysRun = true)
    public void createReports(ITestContext context){
        //System.out.println("AAAA "+ context.getSuite().getResults().size());
        context.getSuite().getResults().forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

    }
}
//TODO:test which checks avg from ints
//function should now accept more than one value
//expected