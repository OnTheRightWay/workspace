public class Main {
    public static void main(String[] args) {
        Link link = new LinkImpl();
        link.add("A");
        link.add("B");
        link.add("C");
        link.set(0,"E");
        link.set(2,"L");
        link.remove("L");
        System.out.println(link.get(0));
        System.out.println(link.get(2));
    }
}
