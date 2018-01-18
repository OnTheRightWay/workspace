package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginStatusInterceptor extends MethodFilterInterceptor{
    //1111111111111111111111
//    @Override
//    public String intercept(ActionInvocation actionInvocation) throws Exception {
//        System.out.println("放行了---");
//        return actionInvocation.invoke();
//    }

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        return actionInvocation.invoke();
    }
}
