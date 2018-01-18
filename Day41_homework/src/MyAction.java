import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

public class MyAction extends ActionSupport {
    private List<String> list;
    private Map<String,String> map;
    private Book book;

    public String addList(){
        System.out.println(list);
        return SUCCESS;
    }

    public String addMap(){
        System.out.println(map);
        return SUCCESS;
    }

    public String addBook(){
        System.out.println(book);
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
