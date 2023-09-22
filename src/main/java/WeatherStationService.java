public class WeatherStationService {

    // send the message to the Kafka topic "weather-station"
    // the message should be in JSON format
    // the message should have the following fields:
    static long messageCount = 0;
    public static void main(String[] args) {
        // get station ID from args[0]

        long stationId = Long.parseLong(args[0]);
        messageCount ++;
        long timestamp = System.currentTimeMillis();
        Weather weather = new Weather();
        Message message = new Message();
        System.out.println(message.generateMessage(stationId, messageCount, timestamp, weather));




    }
}
