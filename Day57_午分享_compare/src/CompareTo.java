public class CompareTo {
    public static void main(String[] args) {
        String s1="abc";
        String s2="abcd";
        String s3="abcde";
        String s4 = "1abc";
        String s5 = "a2bc";
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareTo(s4));
        System.out.println(s1.compareTo(s5));
    }
}
