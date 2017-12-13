package study;

import study.exception.WeatherFindException;
import study.util.Tool;

import java.io.IOException;

public class GetWeather {
    public static String getWeather(String address) throws IOException, WeatherFindException {
       Weather weather=new Tool<Weather>().getInstence("http://api.k780.com/?app=weather.future&weaid="+address+"&&appkey=10003" +
                "&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json",Weather.class);
        Weather.ResultBean result = weather.getResult();
        return result.getWeather();
    }

}
