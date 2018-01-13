package web;

import dao.BookDao;
import domain.Book;
import domain.PageBean;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "web.BookServlet",urlPatterns = "/show")
public class BookServlet extends HttpServlet {
    private BookService bookService = new BookService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bname = request.getParameter("bname");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String[] prs = {"bname","author","price","category"};
        String[] pvs = {bname,author,price,category};
        int pc = Integer.parseInt(request.getParameter("pc"));
        if (pc<=0){
            pc=1;
        }
        PageBean pageBean = new PageBean();
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < pvs.length; i++) {
            map.put(prs[i],pvs[i]);
        }
        pageBean.setParams(map);
        int size = pageBean.getPageSize();
        int bookSize = new BookDao().queryCount(bname,author,price,category);
        int totalPage = bookSize/size;
        if (bookSize%size>0){
            totalPage = bookSize/size+1;
        }
        if (pc>totalPage){
            pc=totalPage;
        }


        int begin = (pc-1)*size;
        List<Book> books = bookService.findByParams(begin, size, bname, author,price, category);


        pageBean.setBooks(books);
        pageBean.setCurrentPage(pc);
        pageBean.setTotalPage(totalPage);
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < pvs.length; i++) {
            if (pvs[i]!=null&&!pvs[i].equals("")){
                sb.append("&"+prs[i]+"="+pvs[i]);
            }
        }
        String param = sb.toString();
        pageBean.setParam(param);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
