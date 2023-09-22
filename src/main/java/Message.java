import java.util.Random;
import org.json.JSONObject;

public class Message {

    private final Random random = new Random();

    public Message() {

    }

    private String randomizeBatteryStatus() {
        int randomNumber = random.nextInt(100);
        if (randomNumber <= 30) {
            return "low";
        } else if (randomNumber <= 70) {
            return "medium";
        } else {
            return "high";
        }
    }

    public JSONObject generateMessage(Long stationId, Long messageId, Long timestamp, Weather weather) {
        String batteryStatus = randomizeBatteryStatus();
        return new JSONObject()
                .put("stationId", stationId)
                .put("s_no", messageId)
                .put("timestamp", timestamp)
                .put("batteryStatus", batteryStatus)
                .put("weather", weather.generateWeatherJson());
    }


    public static void main(String[] args) {
        Message message = new Message();
        Long stationId = 1L;
        Long messageId = 1L;
        Long timestamp = 1L;
        System.out.println(message.generateMessage(stationId,
                messageId,
                timestamp,
                new Weather()));

    }
}
