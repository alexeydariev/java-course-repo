package student.examples;

import java.util.List;

/**
 * Hello world!
 *
 */
public class CalculateService
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public Integer calculateAverage(List<Integer> integers) throws EmptyListException {
        Integer result = 0;
        if (integers == null || integers.isEmpty()) throw new EmptyListException("E");
        for (Integer integer: integers) {
            result += integer;
        }
        return (int) Math.round(((double) result / integers.size()));
    }
}
