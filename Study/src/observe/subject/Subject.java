package observe.subject;

import observe.Observe;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observe> observes = new ArrayList<>();
    //添加观察者,注册观察者
    public void add(Observe observe){
        observes.add(observe);
    }
    //删除观察者
    public void delete(Observe observe){
        observes.remove(observe);
    }
    //通知
    public void notify(String message){
        for (Observe observe : observes) {
            observe.update(message);
        }
    }
}
