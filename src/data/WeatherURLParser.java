package data;

public class WeatherURLParser {
    
    private String city;
    
    public WeatherURLParser(String city) {
        this.city = city.trim();
    }
    
    public String getFullUrl() {
        String s = "http://api.openweathermap.org/data/2.5/weather?q=";
        s += city + "&mode=xml&appid=25537e0ac2056b3b3a7467d53accf87c";
        return s;
    }

}
