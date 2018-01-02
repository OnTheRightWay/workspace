import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Context2Servlet",urlPatterns = "/context2")
public class Context2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object count = getServletContext().getAttribute("count");
        int i = (Integer) count;
        getServletContext().setAttribute("count",++i);
        System.out.println("访问了"+count+"次");
    }
}
