package study;

import java.util.Random;
import java.util.Scanner;

public class MyGame {
    private static final int HARD = 30;
    private static final int MIDDLE = 20;
    private static final int SIMPLE = 10;
    private static final String HARDSTRING = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*(){}[]\\/.,<>?_-+=";
    private static final String MIDDLESTRING = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SIMPLESTRING = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static void game() throws InterruptedException {
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
        System.out.println("耗时："+time+"微秒");

    }


}
