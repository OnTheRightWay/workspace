package study;

import org.dom4j.DocumentException;
import study.exception.LoginException;
import study.exception.RegisterException;
import study.exception.WeatherFindException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isCon = true;
        while (isCon) {
            System.out.println("欢迎来到超级系统（测试版）");
            System.out.println("您是否拥有一个账号   1、登录    2、注册");
            String i = input.nextLine();
            switch (i) {
                case "1":
                    try {
                        String userName = RegisterAndLogin.Login();
                        if (userName != null){
                            isCon = false;
                            System.out.println("欢迎你---"+UserData.getName(userName));
                        }
                    } catch (LoginException e) {
                        System.out.println(e.getMessage());
                        break;
                    } catch (DocumentException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                case "2":
                    try {
                        RegisterAndLogin.register();
                    } catch (RegisterException e) {
                        System.out.println(e.getMessage());
                        break;
                    } catch (DocumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                default:
                    System.out.println("请选择1或2");
                    break;
            }
        }

        System.out.println("请选择你想使用的功能:");
        System.out.println("1、查询天气（即将上线）  2、查询手机号归属地（即将上线）  3、手速游戏  4、查询手速游戏前十用户（即将上线）");
        String s = input.nextLine();
        switch (s){
            case "1":
                try {
                    System.out.println(GetWeather.getWeather("beijing"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WeatherFindException e) {
                    e.printStackTrace();
                }
                break;
            case "2":
                try {
                    System.out.println(GetPhone.getPhone("15171444165"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "3":
                try {
                    MyGame.game();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "4":
                break;
        }




    }






}
