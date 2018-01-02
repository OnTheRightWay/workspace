package study;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet{
    /**
     * Tomcat就像相当于一个简易版服务器
     * 我们可以吧自己写的后端应用程序
     * 部署到Tomcat上
     * 然后就可以通过访问Tomcat的方式去访问我们
     * 自己的应用
     *
     * 原来做过一个练习，拉去用户昵称和成绩的那个
     * 给的是：ip地址：8080
     * 这里这个8080端口，就是在访问对应ip地址上的
     * Tomcat
     *
     * 那么我们创建好一个JavaWeb程序
     * 并且部署到了Tomcat之后
     * Tomcat是如何根据用户输入的地址
     * 来找到我们程序中的执行单元呢？
     *
     * 比如：192.168.20.133:8080/day16/ten
     *
     * 这里这个day16就是要访问部署到Tomcat上
     * 名为day16的应用程序
     *
     * ten表示，要访问day16这个应用程序的那个文件？
     * 这里这个文件，实际上就是我们自己写的类
     * 就是我们自定义的HttpServlet的子类
     *
     * 也就是说，每次网络访问请求，实际上都是在访问
     * Servlet
     *
     * B/S系统 Browser    Server
     * C/S系统 Client     Server
     *
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("已经访问到Servlet");
    }
}
