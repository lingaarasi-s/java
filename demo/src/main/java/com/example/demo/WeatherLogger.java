package com.example.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherLogger {
    public static void main(String[] args) {
        String apiKey = "d0e585eb6674db80e631b80be085d40e";
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String city = inputScanner.nextLine();

        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey + "&units=metric";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner responseScanner = new Scanner(conn.getInputStream());
                StringBuilder response = new StringBuilder();
                while (responseScanner.hasNextLine()) {
                    response.append(responseScanner.nextLine());
                }
                responseScanner.close();

                String logFileName = "C:\\Users\\LINGA ARASI\\java\\demo\\src\\main\\resources\\weather_log.txt";
                File file = new File(logFileName);
                file.getParentFile().mkdirs();
                file.createNewFile();

                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write("=== Weather Data for " + city + " ===\n");
                    writer.write(response.toString() + "\n");
                    writer.write("====================================\n\n");
                }

                System.out.println("Weather data logged successfully.");
            } else {
                System.out.println("Error: Received HTTP response code " + responseCode);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
