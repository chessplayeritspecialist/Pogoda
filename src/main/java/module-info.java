module com.example.weather_progect {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.weather_progect to javafx.fxml;
    exports com.example.weather_progect;
}