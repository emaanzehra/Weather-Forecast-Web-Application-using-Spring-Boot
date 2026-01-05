# Weather Forecast Web Application

## Project Description

The Weather Forecast Web Application is a Java-based Spring Boot project that retrieves and displays real-time weather information for a given city. The application integrates with an external weather API to fetch current temperature and weather conditions, demonstrating the practical use of Object-Oriented Programming (OOP) concepts, RESTful services, and Spring Boot framework fundamentals.

This project was developed as part of an academic OOP course and focuses on clean code structure, API consumption, and ease of use.

---

## Team Members

- **Ahmed Ali** — 25SP-041-AI  
- **Emaan Zehra Butt** — 25SP-024-AI  
- **Mariam Syeda** — 25SP-025-AI  

---

## Demo & Reproducibility Steps

Follow the steps below to run and reproduce the project locally.

### Prerequisites

- Java 8 or higher  
- Maven 3 or higher  
- Internet connection  
- Weather API key (e.g., OpenWeather API)

### Step 1: Clone the Repository

```bash
git clone git@github.com:emaanzehra/Weather-Forecast-Web-Application-using-Spring-Boot.git
cd Weather-Forecast-Web-Application-using-Spring-Boot
````

### Step 2: Configure the API Key

Open the `application.properties` file and add your weather API credentials:

```properties
weather.api.key=YOUR_API_KEY
weather.api.baseUrl=https://api.openweathermap.org/data/2.5/weather
```

Replace `YOUR_API_KEY` with a valid API key from your chosen weather service.

---

### Step 3: Build the Project

```bash
mvn clean install
```

---

### Step 4: Run the Application

```bash
mvn spring-boot:run
```

---

### Step 5: Access the Application

Open your web browser and navigate to:

```
http://localhost:8080
```

Enter a city name and submit the request to view the current weather details.

---

## Notes

* Ensure that the API key is valid and active.
* The application requires an active internet connection to fetch live weather data.
* If the application fails to start, verify Java and Maven versions are correctly installed.

```
```
