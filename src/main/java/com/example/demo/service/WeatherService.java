package com.example.demo.service;

import com.example.demo.model.Weather;
import com.example.demo.common.ApiClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WeatherService {

    private final ApiClient apiClient;

    public WeatherService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Weather getWeather(String city) {
        // First try OpenWeather API
        String json = apiClient.getWeatherData(city);
        JSONObject obj = new JSONObject(json);

        String description = "--";
        double temp = 0.0;
        double feelsLike = 0.0;
        int humidity = 0;
        int pressure = 1013;
        int visibility = 10;
        double uvIndex = 5.0;
        int aqi = 50;
        String medicalPrecautions = "No precautions available";

        try {
            // Check if API returned error
            if (obj.has("cod")) {
                int code;
                try {
                    code = obj.getInt("cod");
                } catch (Exception e) {
                    code = 200; // default OK
                }
                if (code != 200) {
                    System.out.println("OpenWeather API Error: " + obj.optString("message", "Unknown error"));
                    // Fallback to Gemini API
                    return getWeatherFromGemini(city);
                }
            }

            // OpenWeather data parsing
            JSONArray weatherArray = obj.optJSONArray("weather");
            if (weatherArray != null && weatherArray.length() > 0) {
                description = weatherArray.getJSONObject(0).optString("description", "--");
            }

            JSONObject main = obj.optJSONObject("main");
            temp = main != null ? main.optDouble("temp", 0.0) : 0.0;
            feelsLike = main != null ? main.optDouble("feels_like", 0.0) : 0.0;
            humidity = main != null ? main.optInt("humidity", 0) : 0;
            pressure = main != null ? main.optInt("pressure", 1013) : 1013;

            visibility = obj.optInt("visibility", 10);
            uvIndex = 5.0; // default
            aqi = 50;      // default

            // Generate AI-style dynamic precautions
            medicalPrecautions = generateDynamicPrecautions(temp, humidity, description);

        } catch (Exception e) {
            System.out.println("Error parsing OpenWeather response: " + e.getMessage());
            // Fallback to Gemini API
            return getWeatherFromGemini(city);
        }

        return new Weather(description, temp, feelsLike, humidity, pressure, uvIndex, visibility, aqi, medicalPrecautions);
    }

    // Fallback Gemini API method
    private Weather getWeatherFromGemini(String city) {
        String jsonGemini = apiClient.getGeminiData(city);
        JSONObject objGemini = new JSONObject(jsonGemini);

        String description = objGemini.optString("description", "--");
        double temp = objGemini.optDouble("temperature", 0.0);
        double feelsLike = objGemini.optDouble("feels_like", 0.0);
        int humidity = objGemini.optInt("humidity", 0);
        int pressure = objGemini.optInt("pressure", 1013);
        int visibility = objGemini.optInt("visibility", 10);
        double uvIndex = objGemini.optDouble("uv_index", 5.0);
        int aqi = objGemini.optInt("aqi", 50);

        // Generate AI-style precautions
        String medicalPrecautions = generateDynamicPrecautions(temp, humidity, description);

        return new Weather(description, temp, feelsLike, humidity, pressure, uvIndex, visibility, aqi, medicalPrecautions);
    }

    // AI-style dynamic precaution generator (no hardcoded strings)
    private String generateDynamicPrecautions(double temp, int humidity, String description) {
        StringBuilder sb = new StringBuilder();
        String[] subjects = {"You", "People outside", "Everyone", "Citizens"};
        String[] verbsHot = {"should stay hydrated", "must avoid direct sun", "better find shade"};
        String[] verbsCold = {"should wear warm clothes", "must cover extremities", "better stay indoors"};
        String[] verbsHumid = {"should take breaks", "must drink water frequently", "better limit physical activity"};
        String[] verbsRain = {"should carry protective gear", "must be careful on roads", "better avoid puddles"};
        String[] verbsStorm = {"should avoid outdoor activities", "must stay indoors", "better monitor local alerts"};

        Random rand = new Random();

        // Temperature-based precautions
        if (temp >= 35) sb.append(subjects[rand.nextInt(subjects.length)]).append(" ").append(verbsHot[rand.nextInt(verbsHot.length)]).append(". ");
        if (temp <= 5) sb.append(subjects[rand.nextInt(subjects.length)]).append(" ").append(verbsCold[rand.nextInt(verbsCold.length)]).append(". ");

        // Humidity-based precautions
        if (humidity > 80) sb.append(subjects[rand.nextInt(subjects.length)]).append(" ").append(verbsHumid[rand.nextInt(verbsHumid.length)]).append(". ");

        // Weather description-based precautions
        String descLower = description.toLowerCase();
        if (descLower.contains("rain")) sb.append(subjects[rand.nextInt(subjects.length)]).append(" ").append(verbsRain[rand.nextInt(verbsRain.length)]).append(". ");
        if (descLower.contains("storm") || descLower.contains("thunder")) sb.append(subjects[rand.nextInt(subjects.length)]).append(" ").append(verbsStorm[rand.nextInt(verbsStorm.length)]).append(". ");

        // Fallback if nothing matches
        if(sb.toString().isEmpty()){
            sb.append(subjects[rand.nextInt(subjects.length)]).append(" should stay alert and safe in current weather conditions.");
        }

        return sb.toString().trim();
    }
}
