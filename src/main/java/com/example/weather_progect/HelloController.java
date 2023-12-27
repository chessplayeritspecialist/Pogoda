package com.example.weather_progect;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HelloController {

    Path path = Path.of("readme.txt");
    public static Boolean proverka = false;

    public Boolean M = true;
    public Boolean S = true;
    public Boolean E = true;
    public Boolean H = true;

    @FXML
    public AnchorPane anchorPane;

    @FXML
    public Button closeButton;

    @FXML
    private ComboBox Elements;

    @FXML
    public Label temperature;

    @FXML
    private Label feeling;

    @FXML
    private Label humidity;

    @FXML
    private Label pressure;

    @FXML
    private Label datatime;

    @FXML
    private Label welcomeText;

    //Тест:---------------------------------------------------------------------------------------------------------


///////////////////////////////////////////////////////////

    Runnable task = new Runnable() {
        @Override
        public void run() {
            M = true;
            while (M) {
                HttpConnect httpConnect_2 = null;
                try {
                    httpConnect_2 = new HttpConnect("55.24", "37.36");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Москва");
                print();
                HttpConnect finalHttpConnect_ = httpConnect_2;
                Platform.runLater(() -> {
                    temperature.setText(finalHttpConnect_.get_Temterature());
                    feeling.setText(finalHttpConnect_.get_Feeling());
                    humidity.setText(finalHttpConnect_.get_Humidity() + "%");
                    pressure.setText(finalHttpConnect_.get_Pressure() + " мм");
                    finalHttpConnect_.Clear();
                });

                try {
                    Thread.sleep(2900);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };


    Runnable task_2 = new Runnable() {
        @Override
        public void run() {
            S = true;
            while (S) {
                HttpConnect httpConnect_1 = null;
                try {
                    httpConnect_1 = new HttpConnect("59.317", "30.8478");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Спб");
                print();
                HttpConnect finalHttpConnect_ = httpConnect_1;
                Platform.runLater(() -> {
                    temperature.setText(finalHttpConnect_.get_Temterature());
                    feeling.setText(finalHttpConnect_.get_Feeling());
                    humidity.setText(finalHttpConnect_.get_Humidity() + "%");
                    pressure.setText(finalHttpConnect_.get_Pressure() + " мм");
                    finalHttpConnect_.Clear();
                });

                try {
                    Thread.sleep(2900);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };


    Runnable task_3 = new Runnable() {
        @Override
        public void run() {
            E = true;
            while (E) {
                HttpConnect httpConnect_3 = null;
                try {
                    httpConnect_3 = new HttpConnect("60.61", "56.85");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Екатеринбург");
                print();
                HttpConnect finalHttpConnect_ = httpConnect_3;
                Platform.runLater(() -> {
                    temperature.setText(finalHttpConnect_.get_Temterature());
                    feeling.setText(finalHttpConnect_.get_Feeling());
                    humidity.setText(finalHttpConnect_.get_Humidity() + "%");
                    pressure.setText(finalHttpConnect_.get_Pressure() + " мм");
                    finalHttpConnect_.Clear();
                });

                try {
                    Thread.sleep(2900);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };


    Runnable task_4 = new Runnable() {
        @Override
        public void run() {
            H = true;
            while (H) {
                HttpConnect httpConnect_4 = null;
                try {
                    httpConnect_4 = new HttpConnect("60.61", "56.85");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Челябинск");
                print();
                HttpConnect finalHttpConnect_ = httpConnect_4;
                Platform.runLater(() -> {
                    temperature.setText(finalHttpConnect_.get_Temterature());
                    feeling.setText(finalHttpConnect_.get_Feeling());
                    humidity.setText(finalHttpConnect_.get_Humidity() + "%");
                    pressure.setText(finalHttpConnect_.get_Pressure() + " мм");
                    finalHttpConnect_.Clear();
                });

                try {
                    Thread.sleep(2900);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };

//-----------------------------------------------------------------------------------------------------------------------


    Thread thread = new Thread(task);
    Thread thread_2 = new Thread(task_2);
    Thread thread_3 = new Thread(task_3);
    Thread thread_4 = new Thread(task_4);


    Thread[] threads = new Thread[]{thread, thread_2, thread_3, thread_4};

    @FXML
    protected void onHelloButtonClick() throws IOException {

    }
    public void initialize() throws IOException, InterruptedException {
        /*
        closeButton.setOnAction(event -> {
            Test();
        });
*/
        if(Files.readString(path) == "")
        {
            Elements.setValue("");
        }
        else
        {
            Elements.setValue(Files.readString(path));
            TEST();
        }


    }

    public void Test()
    {
            M = false;
            System.out.println("Поток-москва завершен");
            S = false;
            System.out.println("Поток-спб завершен");
            E = false;
            System.out.println("Поток-екатеринбург завершен");
            H = false;
            System.out.println("Поток-Челябинск завершен");

    }

    public void print()
    {
        System.out.println(M);
        System.out.println(S);
        System.out.println(E);
        System.out.println(H);

    }

    public void TEST() throws InterruptedException {
        switch (Elements.getValue().toString()) {

            case ("Москва"):

                /*
                HttpConnect httpConnect = new HttpConnect("55.24", "37.36");
                temperature.setText(httpConnect.get_Temterature());
                feeling.setText(httpConnect.get_Feeling());
                humidity.setText(httpConnect.get_Humidity() + "%");
                pressure.setText(httpConnect.get_Pressure() + " мм");
                httpConnect.Clear();
                break;
                */

                /*
                 new Thread(() -> {
                    try {
                        while (true)
                        {

                            Thread.sleep(2000);
                            HttpConnect httpConnect = new HttpConnect("55.24", "37.36");
                            temperature.setText(httpConnect.get_Temterature());
                            feeling.setText(httpConnect.get_Feeling());
                            humidity.setText(httpConnect.get_Humidity() + "%");
                            pressure.setText(httpConnect.get_Pressure() + " мм");
                            httpConnect.Clear();
                            System.out.println("Код идет");

                        }



                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {

                    }
                }).start();
*/

               /*
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            HttpConnect httpConnect_2 = null;
                            try {
                                httpConnect_2 = new HttpConnect("55.24", "37.36");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Код идет");
                            temperature.setText(httpConnect_2.get_Temterature());
                            feeling.setText(httpConnect_2.get_Feeling());
                            humidity.setText(httpConnect_2.get_Humidity() + "%");
                            pressure.setText(httpConnect_2.get_Pressure() + " мм");
                            httpConnect_2.Clear();
                            try {
                                Thread.sleep(2400);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                };

                Thread thread = new Thread(task);
                thread.start();
                break;

*/

                Test();
                Thread.sleep(800);
                thread.start();

                break;


            case ("Санкт-Петербург"):

                Thread.sleep(800);
                Test();
                thread_2.start();


                break;

                /*
                HttpConnect httpConnect_2 = new HttpConnect("59.317", "30.8478");
                temperature.setText(httpConnect_2.get_Temterature());
                feeling.setText(httpConnect_2.get_Feeling());
                humidity.setText(httpConnect_2.get_Humidity() + "%");
                pressure.setText(httpConnect_2.get_Pressure() + " мм");
                httpConnect_2.Clear();
                break;
                */
            case ("Екатеринбург"):
                 /*
                HttpConnect httpConnect_3 = new HttpConnect("60.61", "56.85");
                temperature.setText(httpConnect_3.get_Temterature());
                feeling.setText(httpConnect_3.get_Feeling());
                humidity.setText(httpConnect_3.get_Humidity() + "%");
                pressure.setText(httpConnect_3.get_Pressure() + " мм");
                httpConnect_3.Clear();
                */

                Thread.sleep(800);
                Test();
                thread_3.start();

                break;

            case ("Челябинск"):
                /*
                HttpConnect httpConnect_4 = new HttpConnect("55.00", "61.00");
                temperature.setText(httpConnect_4.get_Temterature());
                feeling.setText(httpConnect_4.get_Feeling());
                humidity.setText(httpConnect_4.get_Humidity() + "%");
                pressure.setText(httpConnect_4.get_Pressure() + " мм");
                httpConnect_4.Clear();
                break;
                */

                Thread.sleep(800);
                Test();
                thread_4.start();

                break;

        }

        LocalDate currentDate = LocalDate.now();
        datatime.setText(currentDate.toString());



    }

    public void vubor(MouseEvent mouseEvent) {

        if(proverka == false)
        {
            Elements.getItems().add("Санкт-Петербург");
            Elements.getItems().add("Москва");
            Elements.getItems().add("Екатеринбург");
            Elements.getItems().add("Челябинск");
            proverka = true;
        }

    }

    public void Citi(ActionEvent actionEvent) throws IOException, InterruptedException {

        TEST();
        Files.writeString(path, Elements.getValue().toString());
    }

    public void oprogrammer(MouseEvent mouseEvent) throws IOException {

        String TEXT = "Разработчик: Ганцевич А.А";
        Alert alert = new Alert(Alert.AlertType.INFORMATION, TEXT);
        alert.setTitle("О программе");
        alert.setHeaderText("Программа распространяется по лицензию GPL.");
        alert.show();

    }
}