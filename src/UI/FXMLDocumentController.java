package UI;

import data.URLReader;
import data.Weather;
import data.WeatherURLParser;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private TextArea weatherInfoTextArea;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            getWeatherInfo();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Hello world");
    }

    private void getWeatherInfo() throws IOException {
        URL url = new URL(new WeatherURLParser(enterCityTextField.getText()).getFullUrl());
        Weather w = new Weather(new URLReader(url).getContent());
        weatherInfoTextArea.setText("Weather: " + w.getMap().get("weather")
                + "\nTemperature: " + w.getMap().get("temperature"));
    }

}
