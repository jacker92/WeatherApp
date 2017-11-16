package data;

import javafx.scene.control.TextField;

public class FontColorChanger {
    
    private double temperature;
    
    public FontColorChanger(double temperature) {
        this.temperature = temperature;
    }
    
public TextField getNewColorForTemperature(TextField text) {
  
    if(temperature < 0) {
         text.setStyle("-fx-text-fill: #00ffff; -fx-font-size:12;"); 
    } else if (temperature > 23) {
        text.setStyle("-fx-text-fill: red; -fx-font-size:12;");  
    }
    
    return text;
}
}
