package student.examples;

import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

@Listeners(CalculationServiceTestListener.class)
public class CalculationServiceDBTest {
    private CalculationService calculationService;
    private Connection conn;

    @BeforeClass
    public void setupData() throws SQLException {
        //1. Open connection
        String url = "jdbc:postgresql://192.168.215.129/calculation_service_test_data_db?user=postgres&password=qazwsx&ssl=false";
        conn = DriverManager.getConnection(url);
        Statement statement = conn.createStatement();
        //2. Insert test info into database
        //3. Insert test data
        statement.executeUpdate("DELETE FROM test_data;");
        statement.executeUpdate("DELETE FROM tests;");
        for (int j = 1; j <= 10 ; j++) {
            ResultSet resultSet = statement.executeQuery("SELECT id FROM test_authors ORDER BY random() LIMIT 1");
            resultSet.next();
            statement.executeUpdate("INSERT INTO tests VALUES (" + j + ", 'sum of negatives', false,  NOW(), " + resultSet.getInt("id") + " ) ");
            StringBuilder values = new StringBuilder();
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                int value = (int) (Math.random() * (-999) - 1);
                sum += value;
                values.append(value).append(',');
            }
            values.replace(values.length()-1, values.length() + 1, "");

            String expected = String.format("%d", sum);

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO test_data VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, j);
            preparedStatement.setString(2, values.toString());
            preparedStatement.setString(3, expected);
            preparedStatement.setInt(4, j);
            preparedStatement.executeUpdate();
        }
        //fetching data
    }

    @DataProvider(name = "dp")
    public Iterator<Map<String, Object>> provideData() throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT input, expected, email FROM test_data JOIN tests ON test_data.test_id = tests.id " +
                "JOIN test_authors ON tests.author_id = test_authors.id ORDER BY test_data.id ");
        List<Map<String,Object>> testData = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> sample = new HashMap<>();
            sample.put("input", Arrays.stream(resultSet.getString("input").split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            sample.put("expected", resultSet.getInt("expected"));
            sample.put("email", resultSet.getString("email"));
            testData.add(sample);
        }

        return testData.iterator();
    }

    @BeforeClass
    public void setupService() {
        calculationService = new CalculationService();
    }
/*
    @Test
    public void testSumOfTwo() {
        Assert.assertEquals(calculationService.sum(1, 2), 3);
    }

    @Test
    public void testSumOfArray() {
        Assert.assertEquals(calculationService.sum(new int[]{1, 2, 3}), 6);
    }*/
    @Test(dataProvider = "dp")
    public void testSumOfIntegers(Map<String, Object> sample) {
        Assert.assertEquals(calculationService.sum((List<Integer>) sample.get("input")), sample.get("expected"));
    }

    @AfterClass
    public void tearDown() { //TODO: HW clear db
        calculationService = null;
    }

}
