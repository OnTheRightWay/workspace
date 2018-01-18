package user.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhuang.util.VerifyCode;
import org.apache.struts2.ServletActionContext;
import user.domain.User;
import user.service.UserService;
import user.service.exception.PasswordErrorException;
import user.service.exception.RegisterException;
import user.service.exception.UserIsNotExistException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserAction extends ActionSupport implements ModelDriven<User>{
    private UserService userService = new UserService();
//    private String username;
//    private String password;
//    private String tele;
//    private String email;
    private String valPassword;
    private String verify;
    private User user = new User();

    public String register() throws IOException {
        HttpServletRequest request = ServletActionContext.getRequest();
//        User user = new User(username,password,tele,email);
        request.setAttribute("user",user);
        request.setAttribute("valPassword",valPassword);
        request.setAttribute("verify",verify);

        System.out.println(request.getSession().getAttribute("verify"));
        if (!valPassword.equals(user.getPassword())){
            addFieldError("valPassword","密码不一致");
            return "input";
        }
        if (!verify.equals(request.getSession().getAttribute("verify"))){
            addFieldError("verify","验证码错误");
            return "input";
        }
        try {
            userService.register(user);
        } catch (RegisterException e) {
            addFieldError("username",e.getMessage());
            return "input";
        }
        return SUCCESS;
    }
    public String login(){
        ServletActionContext.getRequest().setAttribute("username",user.getUsername());
        User u = null;
        System.out.println(user.getUsername()+"----"+user.getPassword());
        try {
            u = userService.login(user.getUsername(),user.getPassword());
        } catch (UserIsNotExistException e) {
            addFieldError("username",e.getMessage());
            return "input";
        } catch (PasswordErrorException e) {
            addFieldError("password",e.getMessage());
            return "input";
        }
        ServletActionContext.getRequest().getSession().setAttribute("user",u);
        return SUCCESS;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getTele() {
//        return tele;
//    }
//
//    public void setTele(String tele) {
//        this.tele = tele;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getValPassword() {
//        return valPassword;
//    }
//
//    public void setValPassword(String valPassword) {
//        this.valPassword = valPassword;
//    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        return user;
    }
}
