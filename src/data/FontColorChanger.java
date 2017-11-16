package data;

import javafx.scene.control.TextField;

public class FontColorChanger {

    private double temperature;
    private double windSpeed;

    public FontColorChanger(double temperature, double windSpeed) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    public TextField getNewColorForTemperature(TextField text) {
        if (getWindChillTemperature() < 0) {
            text.setStyle("-fx-text-fill: #00ffff; -fx-font-size:12;");
        } else if (getWindChillTemperature() > 23) {
            text.setStyle("-fx-text-fill: red; -fx-font-size:12;");
        }
        return text;
    }

    // Calculates windchill temperature
    private double getWindChillTemperature() {
        double result = 13.12 + 0.6215 * temperature - 13.956 * Math.pow(windSpeed, 0.16)
        + 0.4867 * temperature * Math.pow(windSpeed, 0.16);
        return result;
    }
}
