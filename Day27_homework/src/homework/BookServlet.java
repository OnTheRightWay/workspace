package homework;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bkid = req.getParameter("bkid");
        String bkname = req.getParameter("bkname");
        String author = req.getParameter("author");
        String tid = req.getParameter("tid");


        resp.setContentType("text/html;charset=utf-8");
        List<Book> books = null;
        try {
             books = new QueryUtil().query(
                    JDBCUtil.getConnection(),
                    "select * from book",
                    new BeanListHandler<Book>(Book.class)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = JSONArray.fromObject(books);
//        String s = jsonArray.toString();
//        String success = "\"success\"";
//        String result = "\"result\"";
//        String l = "\"1\"";
//        String s1 = "{"+success+":"+l+","+result+":"+s+"}";
        resp.getWriter().write(jsonArray.toString());
    }
}
