package com.nys.interceptor;

import com.nys.admin.domain.Admin;
import com.nys.role.domain.Module;
import com.nys.role.domain.Role;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModuleInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        String servlet = request.getServletPath();
        boolean isTrue = false;
        for (Role role : admin.getRoles()) {
            for (Module module : role.getModules()) {
                if (module.getName().equals("角色管理")){
                    String[] split = servlet.split("/");
                    if (split[1].equals("role")){
                        isTrue=true;
                    }
                }
                if (module.getName().equals("管理员")){
                    String[] split = servlet.split("/");
                    if (split[1].equals("admin")){
                        isTrue=true;
                    }
                }
                if (module.getName().equals("资费管理")){
                    String[] split = servlet.split("/");
                    if (split[1].equals("cost")){
                        isTrue=true;
                    }
                }
                if (module.getName().equals("账务账号")){
                    String[] split = servlet.split("/");
                    if (split[1].equals("account")){
                        isTrue=true;
                    }
                }
                if (module.getName().equals("业务账号")){
                    String[] split = servlet.split("/");
                    if (split[1].equals("service")){
                        isTrue=true;
                    }
                }
            }
        }
        if (!isTrue){
            response.sendRedirect(request.getContextPath()+"/nopower.jsp");
            return isTrue;
        }
        return isTrue;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
