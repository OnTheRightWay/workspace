package com.nys.crm.staff.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;


public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Object staff = request.getSession().getAttribute("staff");
        if (staff==null){
            request.setAttribute("login","请登录");
            return "login";
        }
        actionInvocation.invoke();
        return "success";
    }
}
