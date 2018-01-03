import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "CharsetServlet",urlPatterns = "/Charset")
public class CharsetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        System.out.println(key);
        byte[] isoBytes = key.getBytes("GBK");
        System.out.println(Arrays.toString(isoBytes));
        //把直接按照UTF-8的编码形式得到字符串
        key = new String(isoBytes,"UTF-8");
        System.out.println("UTF-8:"+key);
        System.out.println(Arrays.toString(key.getBytes("UTF-8")));
    }
}
