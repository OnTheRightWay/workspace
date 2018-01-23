import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.Element;
import com.opensymphony.xwork2.util.KeyProperty;

import java.util.*;

public class MyAction extends ActionSupport{
    private List<String> list;
    private Map<String,String> map;
//    @KeyProperty("bname")
//    @Element(Book.class)
    private Set<Book> set = new HashSet<>();
    public String addList(){
        System.out.println(list);
        return SUCCESS;
    }

    public String addMap(){
        System.out.println(map);
        return SUCCESS;
    }

    public String addSet(){
        System.out.println(set);
        return SUCCESS;
    }


    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<Book> getSet() {
        return set;
    }

    public void setSet(Set<Book> set) {
        this.set = set;
    }
}
