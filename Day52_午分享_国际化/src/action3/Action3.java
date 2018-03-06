package action3;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class Action3 extends ActionSupport {
    public String getValue(){
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("name",this.getText("name"));
        request.getSession().setAttribute("gender",this.getText("gender"));
        request.getSession().setAttribute("hobby",this.getText("hobby"));
        request.getSession().setAttribute("param",this.getText("param"));
        return SUCCESS;
    }
}
