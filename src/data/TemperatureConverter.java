package data;

public class TemperatureConverter {

    public Double kelvinToCelsius(String temp) {
        double d = Double.parseDouble(temp);
        return d-273.15;
    }
}
