package study.game;

import study.bean.TenUser;
import study.constant.Constant;
import study.util.URLTool;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MyGame {
    private static final int HARD = 30;
    private static final int MIDDLE = 20;
    private static final int SIMPLE = 10;
    private static List<String> hardString = new ArrayList<>();
    private static List<String> middleString = new ArrayList<>();
    private static List<String> simpleString = new ArrayList<>();
    private static void setHardString(){
        for (char c = 32;c<=126;c++){
            hardString.add(Character.toString(c));
        }
    }
    private static void setSimpleString(){
        for (char c = 'a';c<='z';c++){
            simpleString.add(Character.toString(c));
        }
        for (char b = '0';b<='9';b++){
            simpleString.add(Character.toString(b));
        }
    }
    private static void setMiddleString(){
        middleString.addAll(simpleString);
        for (char c = 'A';c<='Z';c++){
            middleString.add(Character.toString(c));
        }
    }

    public static void game(String userName) throws InterruptedException, IOException {
        setSimpleString();
        setMiddleString();
        setHardString();
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
        List<String> GradeString = null;
        switch (Grade){
            case HARD:
                GradeString = hardString;
                break;
            case MIDDLE:
                GradeString = middleString;
                break;
            case SIMPLE:
                GradeString = simpleString;
                break;
                default:
                    GradeString = simpleString;
                    break;
        }
        for (int i = 0; i < Grade; i++) {
            int index = random.nextInt(GradeString.size());
            sb.append(GradeString.get(index));
        }
        System.out.println(sb);

        boolean isTrue = false;
        while (!isTrue) {
            String ss = input.nextLine();
            if (ss.equals(new String(sb))||ss.equals("quit")){
                isTrue = true;
            }else {
                System.out.println("输错了，再输一遍吧(我受不鸟了（输入quit退出）)\n"+sb);
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
        URL url = new URL("http://"+ Constant.URLBASE+"/day16/insert?username="+userName+"&score="+score);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        byte[] b =new byte[1024];
        int len = is.read(b);
        String s = new String(b,0,len);
        System.out.println(s);

    }

    public static void pullScore(int i) throws IOException {
        TenUser[] tenUsers = (TenUser[]) URLTool.getInstence("http://"+Constant.URLBASE+"/day16/ten",TenUser.class);
        System.out.println("第"+i+"名："+tenUsers[i-1].getNickname()+"\t分数:"+tenUsers[i-1].getScore());
    }

}
