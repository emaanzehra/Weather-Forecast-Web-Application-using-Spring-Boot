# Weather Forecast Web Application (Spring Boot)

A simple **Weather Forecast Web Application** built with **Spring Boot** that fetches and displays real-time weather information such as temperature and weather conditions using an external weather API.

This project was developed as an **Object-Oriented Programming (OOP) academic project** with a focus on clean architecture, API integration, and practical use of Spring Boot.

---

## Table of Contents

* Overview
* Key Features
* Tech Stack
* Architecture
* Getting Started

  * Prerequisites
  * Configuration
  * Run Locally
* Usage
* Notes
* Contributors

---

## Overview

Weather forecasting applications are widely used to help people plan daily activities. This project demonstrates how a Java-based Spring Boot application can integrate with a third-party weather API to retrieve and present live weather data in a simple and user-friendly manner.

The main objective of the project is to apply OOP concepts while gaining hands-on experience with Spring Boot and RESTful APIs.

---

## Key Features

* Retrieves real-time weather data from an external API
* Displays essential weather details such as:

  * Temperature
  * Current weather conditions (e.g., Clear, Clouds, Rain)
* Uses Spring Boot controllers for efficient request handling
* Lightweight and easy-to-understand project structure

---

## Tech Stack

* Java
* Spring Boot
* Maven
* RESTful API integration
* External Weather API (e.g., OpenWeather API)

---

## Architecture

High-level workflow of the application:

1. User requests weather information for a city.
2. Spring Boot controller handles the request.
3. The application sends a request to the external weather API.
4. API response is processed and parsed.
5. Weather data is displayed to the user.

---

## Getting Started

### Prerequisites

* Java 8 or higher
* Maven 3 or higher
* A valid weather API key (e.g., OpenWeather)

### Configuration

Add your API key and base URL in the configuration file.

Example (`application.properties`):

```properties
weather.api.key=YOUR_API_KEY
weather.api.baseUrl=https://api.openweathermap.org/data/2.5/weather
```

Alternatively, you may use environment variables if preferred.

### Run Locally

```bash
git clone git@github.com:emaanzehra/Weather-Forecast-Web-Application-using-Spring-Boot.git
cd Weather-Forecast-Web-Application-using-Spring-Boot
mvn clean install
mvn spring-boot:run
```

The application will typically run at:

```
http://localhost:8080
```

---

## Usage

* Enter the name of a city in the application interface.
* Submit the request.
* View the current weather information returned by the API.

---

## Notes

* This project is intended for learning purposes and demonstrates basic Spring Boot and OOP concepts.
* Ensure your API key is valid and that you have not exceeded API request limits.
* Internet access is required for fetching live weather data.

---

## Contributors

* **Ahmed Ali** — 25SP-041-AI
* **Emaan Zehra Butt** — 25SP-024-AI
* **Mariam Syeda** — 25SP-025-AI
