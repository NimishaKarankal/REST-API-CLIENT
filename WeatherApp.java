import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAppGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WeatherAppGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Layout
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel latLabel = new JLabel("Latitude:");
        JTextField latField = new JTextField();
        JLabel lonLabel = new JLabel("Longitude:");
        JTextField lonField = new JTextField();
        JButton fetchButton = new JButton("Get Weather");
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);

        panel.add(latLabel);
        panel.add(latField);
        panel.add(lonLabel);
        panel.add(lonField);
        panel.add(new JLabel()); // empty space
        panel.add(fetchButton);
        panel.add(new JLabel("Result:"));
        panel.add(new JScrollPane(resultArea));

        frame.add(panel);
        frame.setVisible(true);

        fetchButton.addActionListener((ActionEvent e) -> {
            try {
                double latitude = Double.parseDouble(latField.getText().trim());
                double longitude = Double.parseDouble(lonField.getText().trim());
                String apiUrl = String.format(
                        "https://api.open-meteo.com/v1/forecast?latitude=%.4f&longitude=%.4f&current_weather=true",
                        latitude, longitude);
                String weatherData = fetchWeatherData(apiUrl);
                String weatherInfo = parseWeatherData(weatherData);
                resultArea.setText(weatherInfo);
            } catch (Exception ex) {
                resultArea.setText("Error: " + ex.getMessage());
            }
        });
    }

    private static String fetchWeatherData(String apiUrl) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("HTTP request failed with code: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        return response.toString();
    }

    private static String parseWeatherData(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONObject currentWeather = jsonObject.getJSONObject("current_weather");

        double temperature = currentWeather.getDouble("temperature");
        double windspeed = currentWeather.getDouble("windspeed");
        int weatherCode = currentWeather.getInt("weathercode");

        return String.format("Temperature: %.1f °C\nWindspeed: %.1f km/h\nWeather Code: %d",
                temperature, windspeed, weatherCode);
    }
}
