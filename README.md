# REST-API-CLIENT

# Project Details

**Name**: Nimisha Karankal  
**Company Name**: CODTECH IT SOLUTIONS  
**Intern ID**: CT08GJI  
**Domain**: Java Programming  
**Mentor**: Neela Santhosh  
**Batch Duration**: 25th December 2024 to 25th January 2025  



#### **Overview**
The **WeatherApp** is a console-based Java application that fetches real-time weather data for any location specified by latitude and longitude. This program interacts with the **Open-Meteo API** to retrieve live weather details such as temperature, wind speed, and weather condition codes. Using the `org.json` library, it parses the API's JSON response to extract and display the relevant data.

The app serves as a hands-on example of integrating APIs in Java, demonstrating concepts like HTTP requests, JSON handling, and user interaction via a command-line interface. This project is an excellent tool for understanding how to fetch and process external data in Java applications.

---

#### **Features**
1. **Real-Time Weather Data Retrieval:**
   - Fetches live weather information for any geographical location specified by latitude and longitude.

2. **User-Friendly Command-Line Interaction:**
   - Prompts the user to input the required coordinates.
   - Displays the results in a clear and readable format.

3. **Dynamic API Integration:**
   - Constructs the API URL dynamically based on user-provided coordinates.
   - Leverages the Open-Meteo API for accurate and up-to-date weather data.

4. **JSON Parsing with `org.json`:**
   - Parses the JSON response from the API to extract key data such as:
     - Temperature.
     - Wind speed.
     - Weather condition code.

5. **Error Handling and Validation:**
   - Includes error handling for invalid HTTP responses or API issues.
   - Handles incorrect inputs gracefully, ensuring the application remains robust.

6. **Scalable and Extensible:**
   - Designed to be modular, allowing for easy extension of features, such as:
     - Support for additional weather metrics like humidity or precipitation.
     - Adding location-based queries (e.g., by city name).
     - Supporting different units (Celsius/Fahrenheit, km/h/mph).

7. **Formatted Output:**
   - Displays the weather data in a structured format using `System.out.printf` for clean presentation.

---

#### **About the Code**
The **WeatherApp** showcases best practices in Java programming for real-world applications. Below are details about its implementation:

1. **Code Structure:**
   - **Main Method:** Serves as the entry point for the application. It collects user inputs, calls methods to fetch and display weather data, and handles exceptions.
   - **fetchWeatherData:** Handles API communication. It establishes an HTTP connection, sends a GET request, and retrieves the JSON response.
   - **displayWeatherInfo:** Parses the JSON response to extract and display relevant weather information.

2. **Technologies and Libraries:**
   - **Java Standard Library:** Utilizes Java's built-in classes for HTTP connections (`HttpURLConnection`), input handling (`Scanner`), and I/O (`BufferedReader`).
   - **org.json Library:** Used to parse JSON data efficiently and extract specific fields.

3. **Modular Design:**
   - The code is designed with reusable methods for key functionalities:
     - API communication.
     - JSON parsing.
     - Displaying results.
   - This modular approach ensures better readability and maintainability.

4. **Error Handling:**
   - Validates the API's response code to ensure the request was successful.
   - Handles exceptions such as:
     - Connectivity issues.
     - Malformed or invalid JSON responses.
     - Invalid user inputs (e.g., non-numeric latitude/longitude).

5. **Educational Value:**
   - Demonstrates practical Java programming skills.
   - Serves as a foundation for more complex applications involving API integration and data processing.

---



#### **Conclusion**
The **WeatherApp** is a simple yet powerful application that bridges the gap between Java programming fundamentals and real-world API integration. By combining user input, dynamic API calls, JSON parsing, and error handling, it provides a complete solution for fetching and displaying live weather data. The code is modular, scalable, and serves as an excellent example of practical Java development.


# Output:
![image](https://github.com/user-attachments/assets/4faa417a-4b8a-4628-a4fa-b88929d82e61)
