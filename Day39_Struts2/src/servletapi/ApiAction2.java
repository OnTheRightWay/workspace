package servletapi;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiAction2 extends ActionSupport implements ServletRequestAware,ServletResponseAware{
    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
    //实现xxxAware接口的方式，获得ServletAPI
    public String api2(){
        //要在这里使用request




        return SUCCESS;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {

    }
}
