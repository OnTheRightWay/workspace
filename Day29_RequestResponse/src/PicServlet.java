import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "PicServlet",urlPatterns = "/pic")
public class PicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = new File("C:\\Users\\lanou3g\\Desktop/34029301.png");
        FileInputStream fis=new FileInputStream(file);
        byte[] pics = new byte[1024*1024*10];
        int length = fis.read(pics);
        fis.close();
        response.getOutputStream().write(pics,0,length);
    }
}
