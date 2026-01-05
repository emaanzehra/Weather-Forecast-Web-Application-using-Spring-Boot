# Weather-Forecast-Web-Application-using-Spring-Boot
In this project, We implemented the complete backend flow—from handling user requests to fetching live weather data through a REST API and processing JSON responses for clean display of key weather details (like temperature and conditions).
````md
# Weather Forecast Web Application (Spring Boot)

A simple, learning-focused **Weather Forecast Web Application** built with **Spring Boot** that fetches and displays **real-time weather information** (e.g., temperature and weather conditions) by integrating an external weather API.

> Academic OOP Project (Java / Spring Boot). :contentReference[oaicite:0]{index=0}

---

## Table of Contents
- [Overview](#overview)
- [Key Features](#key-features)
- [Tech Stack](#tech-stack)
- [Architecture (High-Level)](#architecture-high-level)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Configuration](#configuration)
  - [Run Locally](#run-locally)
- [Usage](#usage)
- [Notes](#notes)
- [References](#references)
- [Contributors](#contributors)

---

## Overview

Weather apps are used daily to plan activities based on current conditions. This project focuses on building a **clean, lightweight, and user-friendly** weather viewer using Spring Boot, emphasizing:
- REST API integration
- Modular Spring Boot structure
- Maven-based project organization :contentReference[oaicite:1]{index=1}

---

## Key Features
- Fetches **live weather data** from an external weather service API :contentReference[oaicite:2]{index=2}
- Displays key details like:
  - Temperature
  - Weather conditions (e.g., Clear, Clouds, Rain) :contentReference[oaicite:3]{index=3}
- Efficient request handling through Spring Boot controllers :contentReference[oaicite:4]{index=4}
- Simple, minimal interface (learning-first design goal) :contentReference[oaicite:5]{index=5}

---

## Tech Stack
- **Java**
- **Spring Boot**
- **Maven**
- **REST API Integration**
- External Weather API (commonly: **OpenWeather API**) :contentReference[oaicite:6]{index=6}

---

## Architecture (High-Level)

Typical flow:
1. User requests weather for a location (city).
2. Spring Boot **Controller** receives the request.
3. App calls an **external weather API** using REST.
4. Response is processed/parsed.
5. Clean weather data is returned to the UI/view. :contentReference[oaicite:7]{index=7}

---

## Getting Started

### Prerequisites
- Java 8+ (or Java 11+ recommended)
- Maven 3+
- A weather API key (e.g., OpenWeather)

### Configuration

Create a configuration entry for your API key.

**Option A: `application.properties`**
```properties
weather.api.key=YOUR_API_KEY
weather.api.baseUrl=https://api.openweathermap.org/data/2.5/weather
````

**Option B: Environment Variable**

```bash
export WEATHER_API_KEY="YOUR_API_KEY"
```

Then read it in Spring Boot (implementation-dependent).

> If your project already contains specific property names, use those instead.

### Run Locally

```bash
# 1) Clone
git clone <your-repo-url>
cd <your-repo-folder>

# 2) Build
mvn clean install

# 3) Run
mvn spring-boot:run
```

Open in your browser (commonly):

* `http://localhost:8080`

---

## Usage

* Enter a city name (or location input as supported by your UI).
* Submit the request.
* View real-time weather details returned from the external API. 

---

## Notes

* This project is designed to be **simple and readable**, avoiding clutter and unnecessary complexity. 
* If you hit API errors:

  * Confirm your API key is valid
  * Confirm request limits on your API plan
  * Check city spelling and says supported by the provider

---

## References

* Spring Boot Official Documentation 
* OpenWeather API Documentation 
* Java Documentation 
* Maven Documentation 

---

## Contributors

* **Ahmed Ali** — 25SP-041-AI
* **Emaan Zehra Butt** — 25SP-024-AI
* **Mariam Syeda** — 25SP-025-AI 

```
```