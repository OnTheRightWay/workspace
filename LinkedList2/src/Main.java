import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Link link = new Link();
        link.add("A");
        link.add("B");
        link.add("C");
        link.set(0,"D");
        link.set(2,"E");
        link.remove("B");
        System.out.println(link.get(0));
        System.out.println(link.get(1));
        System.out.println(link.get(2));
        System.out.println(link.contains("E"));
        System.out.println(Arrays.toString(link.toArray()));
    }
}
