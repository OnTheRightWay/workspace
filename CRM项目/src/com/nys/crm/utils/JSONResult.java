package com.nys.crm.utils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

public class JSONResult implements Result {
    @Override
    public void execute(ActionInvocation actionInvocation) throws Exception {
        JSONArray json = (JSONArray) ActionContext.getContext().get("json");
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(json.toString());
    }
}
