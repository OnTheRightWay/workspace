package observe2;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observe> observers = new ArrayList<>();
    public void add(Observe observe){
        observers.add(observe);
    }
    public void del(Observe observe){
        observers.remove(observe);
    }
    public void notifyObservers(){
        for (Observe observer : observers) {
            observer.update();
        }
    }
    public void action(){
        notifyObservers();
    }
}
