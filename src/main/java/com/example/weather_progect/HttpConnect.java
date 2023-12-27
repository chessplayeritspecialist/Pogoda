package com.example.weather_progect;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.scene.control.Alert;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class HttpConnect {

    private static String URL;

    private static String name;
    private static String[] strArray = null;
    private String Temterature;

    private String Feeling;

    private String Humidity;

    private String Pressure;

    public HttpConnect(String longitude, String width) throws IOException
    {

        URL = "https://api.openweathermap.org/data/2.5/weather?lat="+longitude+"&lon="+width+"&appid={токен}&lang=ru";

        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try{
            java.net.URL url = new URL(URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            System.out.println("Запрос есть");
            System.out.println(httpURLConnection.getResponseCode());

            if(responseCode == HttpURLConnection.HTTP_OK)
            {


                inputStream = httpURLConnection.getInputStream();

                File file = new File("test.json");
                outputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[1024];




                while ((byteRead = inputStream.read(buffer)) != -1)
                {
                    outputStream.write(buffer, 0, byteRead);
                }
            }

        } catch (IOException e) {
            String TEXT = "Подключите интернет";

            Alert alert = new Alert(Alert.AlertType.INFORMATION, TEXT);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Нет соединения с интернетом");
            alert.show();
            return;
        }
        catch (RuntimeException e) {
            String TEXT = "Подключите интернет";

            Alert alert = new Alert(Alert.AlertType.INFORMATION, TEXT);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Нет соединения с интернетом");
            alert.show();
            return;
        }

        finally {

            try {
                inputStream.close();
                outputStream.close();
            }
            catch (IOException e) {

            }

        }


        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("test.json")) {


            JSONObject jsonObject = (JSONObject) parser.parse(reader);


            name = jsonObject.get("main").toString();
            System.out.println(name);




        }
        catch (ClassCastException e) {
            String TEXT = "Подключите интернет";

            Alert alert = new Alert(Alert.AlertType.INFORMATION, TEXT);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Нет соединения с интернетом");
            alert.show();
        }

        catch (ParseException e) {
            e.printStackTrace();
        }


        SearchElement searchElement = new SearchElement(name);
        Temterature = String.format("%.0f", (searchElement.get_element(0)) - 273.15);
        Feeling = String.format("%.0f", (searchElement.get_element(6)) - 273.15);
        Pressure = String.format("%.0f", (searchElement.get_element(5)) / 1.333);
        Humidity = String.format("%.0f", (searchElement.get_element(3)));


        searchElement.Clear();
    }

    public String get_Temterature()
    {
        return Temterature;
    }

    public String get_Feeling()
    {
        return Feeling;
    }

    public String get_Pressure()
    {
        return Pressure;
    }

    public String get_Humidity()
    {
        return Humidity;
    }

    public void Clear()
    {
        Temterature = "";
        Feeling = "";
        Pressure = "";
        Humidity = "";

    }
}
