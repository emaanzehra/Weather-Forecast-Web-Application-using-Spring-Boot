package com.example.demo.model;

class Forecast extends Weather {
    private String date;

    public Forecast(String date, String description, double temperature, double feelsLike, int humidity) {
        super(description, temperature, feelsLike, humidity);
        this.date = date;
    }

    public String getDate() { return date; }
}
