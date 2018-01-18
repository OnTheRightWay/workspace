package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.CompoundRoot;
import com.opensymphony.xwork2.util.ValueStack;

public class ContextAction extends ActionSupport {
    //44444444444
    public String context(){
        //相当于每个action的上下文
        ActionContext context = ActionContext.getContext();
        context.getApplication().put("test","哈哈哈哈哈");
        context.put("test","哈哈哈哈哈哈");
        return SUCCESS;
    }
    public String value(){
        Object test = ActionContext.getContext().get("test");
        Object t = ActionContext.getContext().getApplication().get("test");
        System.out.println(t);
        return SUCCESS;
    }
    public String vs(){
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        System.out.println("获得了值栈");
        return SUCCESS;
    }
    public String vss(){
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        CompoundRoot root = valueStack.getRoot();
        //向栈中存放一个对象
        //也就是压栈
        //从栈顶压一个对象进去
        root.push("哈哈哈哈哈哈回去啊哈哈哈去");
        //获取栈顶的数据
        Object peek = root.peek();
        System.out.println(peek);
        //弹栈
        //想象弹簧被挤压后弹出去
        root.pop();
        System.out.println(root.peek());
        return SUCCESS;
    }
}
