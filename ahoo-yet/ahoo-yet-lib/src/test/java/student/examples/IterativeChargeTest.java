package student.examples;

import junit.framework.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import student.examples.devices.HasBattery;
import student.examples.devices.VacuumCleaner;

import java.io.IOException;
import java.sql.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

@Listeners(Listener.class)
public class IterativeChargeTest {
    private Connection conn;
    private HasBattery chargeable;

    @BeforeTest (alwaysRun = true)
    public void setUp () throws SQLException {
        chargeable = new VacuumCleaner(1, "sosyara");
        //conn = DriverManager.getConnection("jdbc:postgresql://192.168.215.129/test_data_db?user=postgres&password=qazwsx&ssl=false");
    }


    /*
    @DataProvider(name = "dataFromDB")
    public Object[][] resultSet () throws SQLException {
        Statement statement = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = statement.executeQuery("select * from charge_test_data order by id asc;");
        int colCount = result.getMetaData().getColumnCount();
        result.last();
        int rowCount = result.getRow();
        result.beforeFirst();
        Object[][] data = new Object[rowCount][colCount];
        int row = 0;
        while (result.next()) {
            for (int i = 0; i < colCount; i++) {
                data[row][i] = result.getObject(i+1);
            }
            row++;
        }
        return data;
    }
        */
    @DataProvider(name = "dataFromXML")
    public Object[] body() throws IOException, ParserConfigurationException, SAXException {
        File xmlFile = new File("C:\\Users\\AlexeiD\\IdeaProjects\\ahoo-yet\\ahoo-yet-lib\\src\\test\\resources\\charge-range-test.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        dbf.setIgnoringElementContentWhitespace(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(xmlFile);
        int numberOfInputs = document.getElementsByTagName("input").getLength();
        int numberOfEntries = document.getChildNodes().getLength();
        Object[][] data = new Object[numberOfInputs][numberOfEntries];
        for (int i = 0; i < numberOfInputs; i++) {
            data[i][0] = document.getElementsByTagName("input").item(i).getTextContent();
            data[i][1] = document.getElementsByTagName("expected").item(i).getTextContent();
            }
        return data;
    }

    @Test(dataProvider = "dataFromXML")
    public void testChargeXML(Object[] data) {
        chargeable.setCharge(Integer.parseInt((String) data[0]));
        chargeable.charge();
        Assert.assertEquals(chargeable.getCharge(), Integer.parseInt((String)data[1]));
    }
    /*
    @Test(dataProvider = "dataFromDB")
    public void testChargeDB(Object[] data) {
        chargeable.setCharge((int)data[1]);
        chargeable.charge();
        Assert.assertEquals(chargeable.getCharge(), (int)data[2]);
    }

     */
}
