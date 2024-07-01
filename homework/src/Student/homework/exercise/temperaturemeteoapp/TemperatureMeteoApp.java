package Student.homework.exercise.temperaturemeteoapp;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class TemperatureMeteoApp {
    // Moldova 498
    // Montenegro 499
    // Japan 392
    // Iceland 	352
    // Maldives 462
    public static void main(String[] args) {
        System.out.println("Temperature in Moldova:"
                +OpenMeteoProvider.getCurrentTemperature(498)+"C");
        System.out.println("Humidity in Moldova:"
                +PrivateMeteoProvider.getCurrentHumidity(498)+"%");
        System.out.println("Temperature in Montenegro:"
                +OpenMeteoProvider.getCurrentTemperature(499)+"C");
        System.out.println("Humidity in Montenegro:"
                +PrivateMeteoProvider.getCurrentHumidity(499)+"%");
        System.out.println("Temperature in Japan:"
                +OpenMeteoProvider.getCurrentTemperature(392)+"C");
        System.out.println("Humidity in Japan:"
                +PrivateMeteoProvider.getCurrentHumidity(392)+"%");
        System.out.println("Temperature in Iceland:"
                +OpenMeteoProvider.getCurrentTemperature(352)+"C");
        System.out.println("Humidity in Iceland:"
                +PrivateMeteoProvider.getCurrentHumidity(352)+"%");
        System.out.println("Temperature in Maldives:"
                +OpenMeteoProvider.getCurrentTemperature(462)+"C");
        System.out.println("Humidity in Maldives:"
                +PrivateMeteoProvider.getCurrentHumidity(462)+"%");
        System.out.println("Temperature in Afghanistan:"
                +OpenMeteoProvider.getCurrentTemperature(4)+"C");
        System.out.println("Humidity in Afghanistan:"
                +PrivateMeteoProvider.getCurrentHumidity(4)+"%");
    }
}

class OpenMeteoProvider {
    static double getCurrentTemperature( int countryCode ){
        List<Integer> countryCodes = Arrays.asList(498, 499, 392, 352, 462);
        Random random = new Random();
        if (countryCodes.contains(countryCode)) {
            return (((double)(random.nextInt(1001)-500))/10);
        } else {
            System.err.println("Can't provide data for this country!");
            return 0;
        }
    }
}

class PrivateMeteoProvider extends OpenMeteoProvider {
    static byte getCurrentHumidity( int countryCode ) {
        List<Integer> countryCodes = Arrays.asList(498, 499, 392, 352, 462);
        Random random = new Random();
        if (countryCodes.contains(countryCode)) {
            return (byte)random.nextInt(101);
        } else {
            System.err.println("Can't provide data for this country!");
            return 0;
        }
    }
}
