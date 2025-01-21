import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject; // Import the org.json library
import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Input coordinates
            System.out.print("Enter latitude: ");
            double latitude = scanner.nextDouble();
            System.out.print("Enter longitude: ");
            double longitude = scanner.nextDouble();

            // Build API URL
            String apiUrl = String.format(
                "https://api.open-meteo.com/v1/forecast?latitude=%.4f&longitude=%.4f&current_weather=true",
                latitude, longitude
            );

            // Fetch and display weather data
            String weatherData = fetchWeatherData(apiUrl);
            displayWeatherInfo(weatherData);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String fetchWeatherData(String apiUrl) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("HTTP request failed with code: " + responseCode);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }

    private static void displayWeatherInfo(String jsonResponse) {
        // Parse the JSON response using org.json library
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONObject currentWeather = jsonObject.getJSONObject("current_weather");

        // Extract relevant data
        double temperature = currentWeather.getDouble("temperature");
        double windspeed = currentWeather.getDouble("windspeed");
        int weatherCode = currentWeather.getInt("weathercode");

        // Display the weather data
        System.out.printf("Temperature: %.1f C\n", temperature);
        System.out.printf("Windspeed: %.1f km/h\n", windspeed);
        System.out.println("Weather Code: " + weatherCode);
    }
}
