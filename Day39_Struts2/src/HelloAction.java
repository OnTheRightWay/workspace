import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
    public String hello(){
        System.out.println("哈哈哈哈");
        return "success";
    }

    /**
     * 如果在struts配置文件中，没有设置action要执行action类中的对应的方法，
     * 那么执行时，会默认的执行action类中的execute()方法，该execute方法返回值也是"success"
     * 由于struts配置文件中result设置的name的值是"success"，所以匹配到name时，能匹配成功然后找到对应的jsp文件
     *
     * @return
     * @throws Exception
     */

    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
