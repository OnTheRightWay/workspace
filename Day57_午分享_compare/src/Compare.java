public class Compare {
    public static void main(String[] args) {
        Integer a=10;
        Integer b=100;
        System.out.println(Integer.compare(a,a));
        System.out.println(Integer.compare(a,b));
        System.out.println(Integer.compare(b,a));

        Boolean f = false;
        Boolean t = true;
        System.out.println(Boolean.compare(f,f));
        System.out.println(Boolean.compare(f,t));
        System.out.println(Boolean.compare(t,f));
    }
}
