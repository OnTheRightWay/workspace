package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.InputStream;

public class DownloadAction extends ActionSupport {
    //222222222222

    private InputStream stream;
    private String filename;

    public String down(){
        filename = "8.jpg";
        //获得在web下的图片
        //getServletContext.getResourceAsStream(相对路径)

        ServletContext servletContext = ServletActionContext.getServletContext();
        stream = servletContext.getResourceAsStream("img/1.png");


        return SUCCESS;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
