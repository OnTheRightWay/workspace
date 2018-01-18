package observe;

public class Reader implements Observe{
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "---" + message);
    }
}
