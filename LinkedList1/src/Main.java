import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Link link = new LinkImpl();
        System.out.println(link.get(1));
        link.add("A");
        link.add("B");
        link.add("C");
        link.set(0,"L");
        link.set(2,"M");
        link.remove("M");
        System.out.println(link.get(0));
        System.out.println(link.get(2));
        System.out.println(Arrays.toString(link.toArray()));
    }
}
