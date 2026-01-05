package com.example.demo.controller;

import com.example.demo.model.Weather; 
import com.example.demo.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index"; // input page
    }

    @PostMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        Weather weather = service.getWeather(city);
        model.addAttribute("weather", weather);
        model.addAttribute("city", city);
        return "weather";
    }
}
