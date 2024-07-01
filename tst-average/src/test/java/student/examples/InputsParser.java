package student.examples;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

public class InputsParser {
    private Integer expected;
    private List<Integer> inputs;

    public InputsParser(Row row) {
        parseRowForExpected(row);
        parseRowForInputs(row);
    };

    public List<Integer> getInputs() {
        return inputs;
    }

    public Integer getExpected() {
        return expected;
    }

    private void parseRowForExpected(Row row) {
        this.expected = (int) row.getCell(0).getNumericCellValue();
    }

    private void parseRowForInputs(Row row) {
        this.inputs = new ArrayList<>();
        for (int j = 1; j < row.getLastCellNum(); j++) {
            //System.out.println(row.getCell(j).getNumericCellValue());
            inputs.add((int)row.getCell(j).getNumericCellValue());
        }
    }

    @Override
    public String toString() {
        return "InputsParser{" +
                "expected=" + expected +
                ", inputs=" + inputs +
                '}';
    }
}
