package com.example.demo.model;

/**
 * Weather model to hold all weather-related data.
 */
public class Weather {

    private String description;
    private double temperature;
    private double feelsLike;
    private int humidity;
    private Integer pressure;             // hPa
    private Double uvIndex;               // UV Index
    private Integer visibility;           // in km
    private Integer aqi;                  // Air Quality Index
    private String medicalPrecautions;    // Medical precautions info

    /**
     * Full constructor for all fields.
     */
    public Weather(String description, double temperature, double feelsLike, int humidity,
                   Integer pressure, Double uvIndex, Integer visibility, Integer aqi,
                   String medicalPrecautions) {
        this.description = description;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.humidity = humidity;
        this.pressure = pressure;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
        this.aqi = aqi;
        this.medicalPrecautions = medicalPrecautions != null ? medicalPrecautions : "No precautions";
    }

    /**
     * Basic constructor (only essential fields).
     * Other fields are set to default values.
     */
    public Weather(String description, double temperature, double feelsLike, int humidity) {
        this(description, temperature, feelsLike, humidity, null, null, null, null, "No precautions");
    }

    // ----------------- Getters -----------------
    public String getDescription() { return description; }
    public double getTemperature() { return temperature; }
    public double getFeelsLike() { return feelsLike; }
    public int getHumidity() { return humidity; }
    public Integer getPressure() { return pressure; }
    public Double getUvIndex() { return uvIndex; }
    public Integer getVisibility() { return visibility; }
    public Integer getAqi() { return aqi; }
    public String getMedicalPrecautions() { return medicalPrecautions; }

    // ----------------- Setters -----------------
    public void setDescription(String description) { this.description = description; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public void setFeelsLike(double feelsLike) { this.feelsLike = feelsLike; }
    public void setHumidity(int humidity) { this.humidity = humidity; }
    public void setPressure(Integer pressure) { this.pressure = pressure; }
    public void setUvIndex(Double uvIndex) { this.uvIndex = uvIndex; }
    public void setVisibility(Integer visibility) { this.visibility = visibility; }
    public void setAqi(Integer aqi) { this.aqi = aqi; }
    public void setMedicalPrecautions(String medicalPrecautions) {
        this.medicalPrecautions = medicalPrecautions != null ? medicalPrecautions : "No precautions";
    }

    @Override
    public String toString() {
        return "Weather{" +
                "description='" + description + '\'' +
                ", temperature=" + temperature +
                ", feelsLike=" + feelsLike +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", uvIndex=" + uvIndex +
                ", visibility=" + visibility +
                ", aqi=" + aqi +
                ", medicalPrecautions='" + medicalPrecautions + '\'' +
                '}';
    }
}
