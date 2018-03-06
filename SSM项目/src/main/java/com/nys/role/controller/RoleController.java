package com.nys.role.controller;

import com.nys.cost.domain.PageBean;
import com.nys.role.domain.Module;
import com.nys.role.domain.Role;
import com.nys.role.service.RoleService;
import com.nys.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Resource
    private PageBean pageBean;

    @RequestMapping("/findRoleByPage")
    public String findRoleByPage(int pc, Model model){
        int size = 5;
        pageBean.setPageSize(size);
        int begin = (pc-1)*size;
        List<Role> roles = roleService.findRoleByPage(begin,size);
        int count = roleService.findCount();
        PageBean pageBean = PagingUtil.getPageBean(this.pageBean, roles, pc, count);
        model.addAttribute("pageBean",pageBean);
        return "WEB-INF/role/role_list";
    }

    @RequestMapping("/toModi/{roleId}")
    public String toModi(@PathVariable int roleId,Model model){
        Role role = roleService.findRoleByRoleId(roleId);
        model.addAttribute("role",role);
        List<Module> modules = roleService.findAllModule();
        model.addAttribute("modules",modules);
        return "WEB-INF/role/role_modi";
    }

    @RequestMapping("/modify")
    public String modify(Role role){
        roleService.updateRole(role);
        return "redirect:/role/findRoleByPage?pc=1";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<Module> modules = roleService.findAllModule();
        model.addAttribute("modules",modules);
        return "WEB-INF/role/role_add";
    }

    @RequestMapping("/addRole")
    public String addRole(Role role){
        roleService.addRole(role);
        return "redirect:/role/findRoleByPage?pc=1";
    }

    @RequestMapping("/deleteRole/{roleId}")
    public String deleteRole(@PathVariable int roleId){
        roleService.deleteRole(roleId);
        return "redirect:/role/findRoleByPage?pc=1";
    }

}
