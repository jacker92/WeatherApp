package UI;

import data.FontColorChanger;
import data.TemperatureConverter;
import data.URLReader;
import data.Weather;
import data.WeatherURLParser;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Jaakko Lahtinen
 */
public class FXMLDocumentController {

    @FXML
    private Label label;
    @FXML
    private TextField enterCityTextField;
    @FXML
    private Button getWeatherInfoButton;
    @FXML
    private TextField temperatureInfoTextField;
    @FXML
    private TextField weatherInfoTextField;
    @FXML
    private TextField windSpeedInfoTextField;

    @FXML
    private void handleButtonAction(ActionEvent event) throws SAXException, ParserConfigurationException {
        try {
            getWeatherInfo();
        } catch (Exception e) {
           weatherInfoTextField.setText("Weather info not found");
        }
    }

    private void getWeatherInfo() throws IOException, SAXException, ParserConfigurationException {
        URL url = new URL(new WeatherURLParser(enterCityTextField.getText()).getFullUrl());
        Weather w = new Weather(new URLReader(url).getContent());
        TemperatureConverter converter = new TemperatureConverter();
        double temperature = converter.kelvinToCelsius(w.getMap().get("temperature"));
        double windSpeed = Double.parseDouble(w.getMap().get("windSpeed"));
        FontColorChanger fcc = new FontColorChanger(temperature, windSpeed);
        
        weatherInfoTextField.setText(w.getMap().get("weather"));
        temperatureInfoTextField.setText(temperature + " C");
        windSpeedInfoTextField.setText(windSpeed+"");
        temperatureInfoTextField = fcc.getNewColorForTemperature(temperatureInfoTextField);
        
    }

}
