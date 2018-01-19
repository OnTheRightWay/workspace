package observe2;

public class Main {
    public static void main(String[] args) {
        Observe observer1 = new Observer("aa");
        Observe observer2 = new Observer("cc");
        Observe observer3 = new Observer("bb");
        Subject subject = new MySubject();
        subject.add(observer1);
        subject.add(observer2);
        subject.add(observer3);
        subject.action();
    }
}
