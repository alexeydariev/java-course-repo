package student.examples;

import java.util.List;
import java.util.stream.Stream;

public class CalculationService {
    public int sum(int value1, int value2) {
        return value1 + value2;
    }

    public int sum(int[] values) {
        int result = 0;
        for (int i : values) {
            result += i;
        }
        return result;
    }

    public int sum(List<Integer> values) {
        return values
                .parallelStream()
                .reduce(0, Integer::sum);
    }
}
