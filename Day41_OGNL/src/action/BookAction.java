package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class BookAction extends ActionSupport {
    private String username;
    private String sex;
    public String books(){
        System.out.println(username);
        System.out.println(sex);
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName("侠客行"+i);
            book.setAuthor("金庸"+i);
            book.setCategory("武侠"+i);
            books.add(book);
        }
        ActionContext.getContext().put("books",books);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
