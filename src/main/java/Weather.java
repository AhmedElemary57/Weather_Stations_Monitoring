import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.util.Random;

public class Weather {
    int humidity;
    int temperature;
    int windSpeed;
    Random random = new Random();

    public Weather() {
        generateWeather();
    }
    public Weather(int humidity, int temperature, int windSpeed) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    private int randomizeHumidity() {
        return random.nextInt(100);
    }

    private int randomizeTemperature() {
        return random.nextInt(100);
    }

    private int randomizeWindSpeed() {
        return random.nextInt(100);
    }

    public void generateWeather() {
        this.humidity = randomizeHumidity();
        this.temperature = randomizeTemperature();
        this.windSpeed = randomizeWindSpeed();
    }

    public String toString() {
        return "Humidity: " + humidity +
                ", Temperature: " + temperature +
                ", Wind Speed: " + windSpeed ;
    }

    public JSONObject generateWeatherJson() {
        return new JSONObject()
                .put("humidity", humidity)
                .put("temperature", temperature)
                .put("windSpeed", windSpeed);
    }

    public static void main(String[] args) {
        Weather weather = new Weather();
        System.out.println(weather.generateWeatherJson());

    }
}
