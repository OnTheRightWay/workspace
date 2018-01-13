package util;

public class ELUtil {
    /**
     * 1、必须是静态方法
     * 2、方法必须有返回值
     * @param input
     * @return
     */
    public static String reverse(String input){
        int start = 0;
        int end = input.length()-1;
        String s = doReverse(input, start, end);
        System.out.println(s);
        return s;
    }
    public static String doReverse(String input,int start,int end){
        char[] chars = input.toCharArray();
        char temp=chars[start];
        chars[start]=chars[end];
        chars[end]=temp;

        String output = new String(chars);
        String s = output;
        if(start<end){
            s = doReverse(output, start + 1, end - 1);
        }
        return s;
    }
}
