package study.exception;

public class WeatherFindException extends FindException{
    @Override
    public String getMessage() {
        return "没找到该地点，该天的天气";
    }
}
