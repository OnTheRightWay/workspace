package study;

import study.exception.WeatherFindException;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {

        try {
            GetPhone.getPhone();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
