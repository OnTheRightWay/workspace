package study.weather;

import study.bean.Weather;
import study.exception.WeatherFindException;
import study.util.URLTool;

import java.io.IOException;
import java.util.List;

public class GetWeather {
    public static String getWeather(String address) throws IOException, WeatherFindException {
//        Map map = new HashMap();
//        map.put("result",Weather.ResultBean.class);
       Weather weather=(Weather) URLTool.getInstence("http://api.k780.com/?app=weather.future&weaid="+address+"&&appkey=10003" +
                "&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json",Weather.class,Weather.ResultBean.class);
        List<Weather.ResultBean> result = weather.getResult();
        return result.get(0).getWeather();
    }

}
