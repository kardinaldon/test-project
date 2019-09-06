package jerseyrestclient;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class GetJsonAsMap {
//    public static void main(String[] args) throws IOException {
//        parseWeatherParams();
//    }
    public static Map<String,String> parseWeatherParams() throws IOException {
        Map<String,String> result =
                new ObjectMapper().readValue(new URL("https://api.binance.com/api/v3/ticker/price?symbol=ETHBTC"), Map.class);
        //System.out.println(result);
        return result;
    }

//    public static void main(String[] args) throws IOException {
//        System.out.println(parseWeatherParams());
//    }

}
