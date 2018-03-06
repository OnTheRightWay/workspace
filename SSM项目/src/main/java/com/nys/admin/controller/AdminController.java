package com.nys.admin.controller;

import com.nys.admin.domain.Admin;
import com.nys.admin.service.AdminService;
import com.nys.admin.service.exception.LoginException;
import com.nys.cost.domain.PageBean;
import com.nys.role.domain.Module;
import com.nys.role.domain.Role;
import com.nys.role.service.RoleService;
import com.nys.util.PagingUtil;
import com.nys.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private PageBean pageBean;

    @RequestMapping("/login")
    public String login(Admin admin, String vCode, Model model){
        String regex="^[0-9a-zA-Z_]{1,30}$";
        if (!admin.getAdminCode().matches(regex)){
            request.setAttribute("getAdminCode","30长度内的字母、数字和下划线");
            return "forward:/login.jsp";
        }
        if (!admin.getPassword().matches(regex)){
            request.setAttribute("password","30长度内的字母、数字和下划线");
            return "forward:/login.jsp";
        }

        String code = (String) request.getSession().getAttribute("vCode");
        if (code==null||!code.equalsIgnoreCase(vCode)){
            request.setAttribute("vCode","验证码错误");
            return "forward:/login.jsp";
        }
        Admin login = null;
        try {
            login = adminService.login(admin.getAdminCode(), admin.getPassword(),vCode);
        } catch (LoginException e) {
            System.out.println("登录失败");
            request.setAttribute("login",e.getMessage());
            model.addAttribute("admin", admin);
            return "forward:/login.jsp";
        }
        request.getSession().setAttribute("admin", login);
        System.out.println("登录成功");
        return "redirect:/index.jsp";
    }
    @RequestMapping("/codeImg")
    public String codeImg(HttpServletResponse response){
        String output = null;
        try {
            output = VerifyCode.getInstance().output(
                    response.getOutputStream()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("vCode",output);
        return null;
    }

    @RequestMapping("/findAdminByPage")
    public String findAdminByPage(int pc,String moduleId,String name,Model model){
        String[] params = {"moduleId","name"};
        if (name!=null){
            name=name.trim();
        }
        String[] values = {moduleId,name};
        int size = this.pageBean.getPageSize();
        int begin = (pc-1)*size;
        List<Admin> admins = adminService.findAdminByPage(begin,size,values);
        int count = adminService.findCountByPage(values);
        PageBean pageBean = PagingUtil.getPageBean(this.pageBean, admins, pc, count, params, values);
        model.addAttribute("pageBean",pageBean);
        List<Module> modules = roleService.findAllModule();
        model.addAttribute("modules",modules);
        return "WEB-INF/admin/admin_list";
    }


    @RequestMapping("/resetPassword")
    public String resetPassword(Integer[] adminIds){
        List<Integer> list = new ArrayList<>();
        for (int adminId : adminIds) {
            list.add(adminId);
        }
        adminService.updatePasswordReset(list);
        return "redirect:/admin/findAdminByPage?pc=1";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<Role> roles = roleService.findAllRole();
        model.addAttribute("roles",roles);
        return "WEB-INF/admin/admin_add";
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(Admin admin){
        adminService.addAdmin(admin);
        return "redirect:/admin/findAdminByPage?pc=1";
    }

    @RequestMapping("/deleteAdmin/{adminId}")
    public String deleteAdmin(@PathVariable int adminId){
        adminService.deleteAdmin(adminId);
        return "redirect:/admin/findAdminByPage?pc=1";
    }

    @RequestMapping("/toModi/{adminId}")
    public String toModi(@PathVariable int adminId,Model model){
        Admin admin = adminService.findAdminByAdminId(adminId);
        List<Role> roles = roleService.findAllRole();
        model.addAttribute("admin",admin);
        model.addAttribute("roles",roles);
        return "WEB-INF/admin/admin_modi";
    }

    @RequestMapping("/modify")
    public String modify(Admin admin){
        adminService.updateAdmin(admin);
        return "redirect:/admin/findAdminByPage?pc=1";
    }
}
