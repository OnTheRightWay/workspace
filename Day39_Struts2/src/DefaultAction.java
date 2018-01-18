import com.opensymphony.xwork2.ActionSupport;

public class DefaultAction  extends ActionSupport{


    @Override
    public String execute() throws Exception {
        System.out.println("执行了默认类-----");
        return super.execute();
    }
}
