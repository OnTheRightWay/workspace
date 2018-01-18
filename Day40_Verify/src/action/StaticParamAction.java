package action;

import com.opensymphony.xwork2.ActionSupport;

public class StaticParamAction extends ActionSupport {
    private String username;
    private String password;

    @Override
    public String execute() throws Exception {
        System.out.println("username----"+username);
        System.out.println("password----"+password);
        return super.execute();
    }

    @Override
    public String toString() {
        return "StaticParamAction{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public StaticParamAction(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StaticParamAction() {

    }
}
