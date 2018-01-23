package user.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import user.domain.User;
import user.service.UserService;
import user.service.exception.PasswordErrorException;
import user.service.exception.UserNotExistException;

public class UserAction extends ActionSupport implements ModelDriven{
    private UserService userService = new UserService();
    private User user = new User();
    public String login(){
        User userQuery = null;
        try {
            userQuery = userService.login(user.getUsername(),user.getPassword());
        } catch (UserNotExistException e) {
            addFieldError("username",e.getMessage());
            return "error";
        } catch (PasswordErrorException e) {
            addFieldError("password",e.getMessage());
            return "error";
        }
        ServletActionContext.getRequest().getSession().setAttribute("user",userQuery);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Object getModel() {
        return user;
    }
}
