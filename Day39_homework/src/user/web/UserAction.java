package user.web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import user.domain.User;
import user.servic.UserService;
import user.servic.exception.LoginException;
import user.servic.exception.RegisterException;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class UserAction extends ActionSupport implements ServletRequestAware{
    private HttpServletRequest request;
    private UserService userService =new UserService();

    public String register(){
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            userService.register(user);
        } catch (RegisterException e) {
            request.setAttribute("register",e.getMessage());
            request.setAttribute("user",user);
            return "register";
        }
        return "login";
    }
    public String login(){
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            userService.login(user);
        } catch (LoginException e) {
            request.setAttribute("login",e.getMessage());
            request.setAttribute("user",user);
            return "login";
        }
        return "index";
    }


    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
}
