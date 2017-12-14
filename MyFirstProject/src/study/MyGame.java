package study;

import study.util.Tool;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MyGame {
    private static final int HARD = 30;
    private static final int MIDDLE = 20;
    private static final int SIMPLE = 10;
    private static final String HARDSTRING = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*(){}[]\\/.,<>?_-+=";
    private static final String MIDDLESTRING = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SIMPLESTRING = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static void game(String userName) throws InterruptedException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("请选择难度 1，普通  2，中等  3，困难");
        int Grade = SIMPLE;
        String s = input.nextLine();
        if(s.equals("1")){
            Grade = SIMPLE;
        }else if(s.equals("2")){
            Grade = MIDDLE;
        }else if(s.equals("3")){
            Grade = HARD;
        }
        System.out.println("倒计时3秒钟后开始");
        Thread.sleep(1000);
        System.out.println("倒计时2秒钟后开始");
        Thread.sleep(1000);
        System.out.println("倒计时1秒钟后开始");
        Thread.sleep(1000);
        System.out.println("开始");
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        String GradeString = null;
        switch (Grade){
            case HARD:
                GradeString = HARDSTRING;
                break;
            case MIDDLE:
                GradeString = MIDDLESTRING;
                break;
            case SIMPLE:
                GradeString = SIMPLESTRING;
                break;
                default:
                    GradeString = SIMPLESTRING;
                    break;
        }
        for (int i = 0; i < Grade; i++) {
            int index = random.nextInt(GradeString.length());
            sb.append(GradeString.substring(index,index+1));
        }
        System.out.println(sb);

        boolean isTrue = false;
        while (!isTrue) {
            if (input.nextLine().equals(new String(sb))){
                isTrue = true;
            }else {
                System.out.println("输错了，再输一遍吧\n"+sb);
            }
        }
        Long endTime = System.currentTimeMillis();
        Long time = endTime-startTime;
        System.out.println("耗时："+time);
        System.out.println("是否要上传你的成绩 1:是   2:否");
        String ss = input.nextLine();
        if (ss.equals("1")){
            pushScore(userName,time);
        }

    }
    public static void pushScore(String userName,long score) throws IOException {
        URL url = new URL("http://192.168.20.221:8080/day16/insert?username="+userName+"&score="+score);
        url.openConnection();
    }

    public static void pullScore(int i) throws IOException {
        TenUser[] tenUsers = (TenUser[]) Tool.getInstence("http://192.168.20.221:8080/day16/ten",TenUser.class);
        System.out.println("第"+i+"名："+tenUsers[i-1].getNickname()+"分数:"+tenUsers[i-1].getScore());
    }


}
