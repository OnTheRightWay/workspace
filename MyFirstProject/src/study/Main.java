package study;

import org.dom4j.DocumentException;
import study.exception.LoginException;
import study.exception.RegisterException;
import study.exception.WeatherFindException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private String userName;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userName = null;
        boolean isCon = true;
        while (isCon) {
            System.out.println("欢迎来到超级系统（测试版）");
            System.out.println("您是否拥有一个账号   1、登录    2、注册");
            String i = input.nextLine();
            switch (i) {
                case "1":
                    try {
                        userName = RegisterAndLogin.Login();
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
        System.out.println("1、查询天气  2、查询手机号归属地  3、手速游戏  4、查询手速游戏前十用户");
        String s = input.nextLine();
        switch (s){
            case "1":
                try {
                    System.out.println("请输入你要查询的城市 例如：beijing");
                    String c = input.nextLine();
                    System.out.println(GetWeather.getWeather(c));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WeatherFindException e) {
                    e.printStackTrace();
                }
                break;
            case "2":
                try {
                    System.out.println("请输入你要查询的手机号码");
                    String phone = input.nextLine();
                    System.out.println(GetPhone.getPhone(phone));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "3":
                try {
                    MyGame.game(userName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "4":
                try {
                    System.out.println("你要查询第几名的成绩？1：第一名 2：第二名 3：第三名 4：前十名");
                    String num = input.nextLine();
                    if (!(num.equals("1")||num.equals("2")||num.equals("3")||num.equals("4"))){
                        System.out.println("输入错误！！请选择1,2,3,4");
                        break;
                    }
                    if (num.equals("4")) {
                        for (int i = 1; i <= 10; i++) {
                            MyGame.pullScore(i);
                        }
                        break;
                    }
                    if (!num.equals("4")) {
                        MyGame.pullScore(Integer.parseInt(num));
                        break;
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }

    }






}
