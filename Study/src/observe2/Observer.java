package observe2;

public class Observer implements Observe {
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name+"接受到了数据");
    }
}
