package com.example.weather_progect;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class HelloApplication extends Application {

    HelloController helloController = new HelloController();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 230);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);

        /*
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(final WindowEvent event) {
                helloController.Test();
            }
        });
*/
        stage.getIcons().add(new Image("file:./target/classes/img/ter.png"));
        stage.setTitle("Погода");
        stage.setScene(scene);
        stage.show();

/*
        helloController = new HelloController();
        helloController.TEST("alex");
        */

    }
    @Override
    public void stop()
    {
        helloController.print();
        helloController.Test();

    }


    public static void main(String[] args) {
        launch();

    }
}