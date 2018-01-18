import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    /**
     * 因为对于User的操作
     * 肯定存在增删改查，或者其他的操作方式
     * 那么我们可以给UserAction写出对应的方法
     * 返回值可以我们自己定义
     * 在struts.xml中的result标签中
     * 可以找到对应的结果就可以了
     *
     *
     * @return
     */

    public String add(){
        return "success";
    }

    public String delete(){
        return "success";
    }

    public String modify(){
        return "success";
    }
}
