import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {

    private List<Book> books;

    @Override
    public void init() throws ServletException {
        books = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Book book = new Book(
                    "白眉大侠"+(i+1),
                    "吴承恩",
                    (i+1)+"",
                    "武侠小说"
            );
            books.add(book);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得前端给我的页码参数
        //pc=pageCode
        PageBean pageBean = new PageBean();
        int pageSize = pageBean.getPageSize();
        String pc = request.getParameter("pc");
        if (!pc.matches("[0-9]+")){
            pc="1";
        }
        int p = Integer.parseInt(pc);
        if (p>20){
            p=20;
        }

        int begin = pageSize*(p-1);
        int end = pageSize* p;
//        if(end>books.size()){
//            end=books.size()-begin-1;
//        }
        List<Book> bookList = this.books.subList(begin,end);

        pageBean.setBooks(bookList);
        pageBean.setTotalData(200);
        pageBean.setPageCode(p);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher(
                "index.jsp"
        ).forward(request,response);
    }
}
