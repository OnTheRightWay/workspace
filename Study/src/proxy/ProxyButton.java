package proxy;

public class ProxyButton implements IFunction{
    //代理对象中必须有被代理对象的引用
    private IFunction function;

    public ProxyButton(IFunction function, String roleName) {
        this.function = function;
        this.roleName = roleName;
    }

    //角色名称
    private String roleName;
    @Override
    public void click() {
        if ("管理员".equals(roleName)){
            function.click();
            System.out.println("校验合格");
        }else {
            System.out.println("您没有权限点击");
        }
    }

    @Override
    public String getBtnName() {
        return null;
    }
}
