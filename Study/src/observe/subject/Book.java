package observe.subject;

import observe.Observe;

import java.util.ArrayList;
import java.util.List;

public class Book extends Subject{
    private String name;
    private List<Observe> observes = new ArrayList<>();

    public Book(String name) {
        this.name = name;
    }

    @Override
    public void add(Observe observe) {
        observes.add(observe);
    }

    @Override
    public void delete(Observe observe) {
        observes.remove(observe);
    }

    @Override
    public void notify(String message) {
        for (Observe observe : observes) {
            observe.update(name+message);
        }
    }
}
