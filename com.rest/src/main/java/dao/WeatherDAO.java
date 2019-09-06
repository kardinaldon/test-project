package dao;

import model.Weather;

import java.io.IOException;

import static jerseyrestclient.GetJsonAsMap.parseWeatherParams;

public class WeatherDAO {

    private static void initWeatherParams() throws IOException {
        Weather weather = new Weather();
//        weather.setCoord(parseWeatherParams().get("coord"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        weather.setBase(parseWeatherParams().get("base"));
//        weather.setMain(parseWeatherParams().get("main"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        weather.setWeather(parseWeatherParams().get("weather"));
//        System.out.println(weather.getBase());
        weather.setSymbol(parseWeatherParams().get("symbol"));
        weather.setPrice(parseWeatherParams().get("price"));
        System.out.println(weather.getPrice());

    }

    public static void main(String[] args) throws IOException {
        initWeatherParams();
    }
}
