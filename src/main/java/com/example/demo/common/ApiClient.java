package com.example.demo.common;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public class ApiClient {

    @Value("${openweather.api.key}") // Add your OpenWeather API key in application.properties
    private String openWeatherApiKey;

    @Value("${gemini.api.key}") // Add your Gemini API key in application.properties
    private String geminiApiKey;

    private final WebClient openWeatherClient = WebClient.create("https://api.openweathermap.org/data/2.5");
    private final WebClient geminiClient = WebClient.create("https://api.geminiweather.com"); // Gemini real base URL

    // OpenWeather API method
    public String getWeatherData(String city) {
        if (openWeatherApiKey == null || openWeatherApiKey.isEmpty()) {
            throw new IllegalStateException("OpenWeather API key is missing. Add it in application.properties");
        }

        try {
            Mono<String> response = openWeatherClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/weather")
                            .queryParam("q", city)
                            .queryParam("appid", openWeatherApiKey)
                            .queryParam("units", "metric")
                            .build())
                    .retrieve()
                    .bodyToMono(String.class);

            return response.block();

        } catch (WebClientResponseException e) {
            System.out.println("OpenWeather API Error: " + e.getRawStatusCode() + " - " + e.getResponseBodyAsString());
            return "{\"error\":\"City not found or API key invalid\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Something went wrong while fetching OpenWeather data\"}";
        }
    }

    // Gemini API method
    public String getGeminiData(String city) {
        if (geminiApiKey == null || geminiApiKey.isEmpty()) {
            throw new IllegalStateException("Gemini API key is missing. Add it in application.properties");
        }

        try {
            Mono<String> response = geminiClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/current")  // Gemini endpoint for current weather
                            .queryParam("city", city)   // Dynamic city name
                            .queryParam("apikey", geminiApiKey) // Your Gemini API key
                            .build())
                    .retrieve()
                    .bodyToMono(String.class);

            return response.block();

        } catch (WebClientResponseException e) {
            System.out.println("Gemini API Error: " + e.getRawStatusCode() + " - " + e.getResponseBodyAsString());
            return "{\"error\":\"City not found or API key invalid\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Something went wrong while fetching Gemini data\"}";
        }
    }
}
