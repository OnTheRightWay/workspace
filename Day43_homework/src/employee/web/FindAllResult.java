package employee.web;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import employee.domain.Employee;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindAllResult implements Result {
    @Override
    public void execute(ActionInvocation actionInvocation) throws Exception {
        List<Employee> employs = (List<Employee>) ServletActionContext.getRequest().getAttribute("employs");
        JSONArray jsonArray = JSONArray.fromObject(employs);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(jsonArray.toString());
    }
}
