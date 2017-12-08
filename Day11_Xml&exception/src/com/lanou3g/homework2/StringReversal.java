package com.lanou3g.homework2;

public class StringReversal {
    public static void main(String[] args) {
        String s = "jjaskufhlahfl";
//        System.out.println(reversal(s, 0, s.length() - 1));
        System.out.println(reverse(s));
    }
    public static String reverse(String s){
        return reversal(s,0,s.length()-1);
    }

    public static String reversal(String s,int startIndex,int endIndex){
        char c[]=s.toCharArray();
        if(startIndex < endIndex){
            char temp = c[startIndex];
            c[startIndex] = c[endIndex];
            c[endIndex] = temp;
            s = reversal(new String(c), startIndex + 1, endIndex - 1);
        }
        return s;
    }
}
