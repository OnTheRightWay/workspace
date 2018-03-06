package com.nys.role.service.impl;

import com.nys.cost.domain.PageBean;
import com.nys.role.dao.ModuleMapper;
import com.nys.role.dao.RoleMapper;
import com.nys.role.domain.Module;
import com.nys.role.domain.Role;
import com.nys.role.service.RoleService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;
    private ModuleMapper moduleMapper;

    public RoleServiceImpl() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        roleMapper = context.getBean(RoleMapper.class);
        moduleMapper = context.getBean(ModuleMapper.class);
    }

    @Override
    public List<Role> findRoleByPage(int begin, int size) {
//        PageBean pageBean = new PageBean();
//        pageBean.setCurrentPage(begin);
//        pageBean.setPageSize(size);
//        List<Role> roles = roleMapper.findRoleByPage(pageBean);
//        int count = roleMapper.findCount();
//        int f = size;
//        while (roles.size()<size&&f<=count){
//            f++;
//            pageBean.setPageSize(f);
//            roles = roleMapper.findRoleByPage(pageBean);
//        }
//        return roles;
        List<Role> roles = roleMapper.findAllRole();
        List<Role> r = new ArrayList<>();
        for (int i = begin; i < begin + size; i++) {
            if (i>roles.size()-1){
                break;
            }
            r.add(roles.get(i));
        }
        return r;
    }

    @Override
    public int findCount() {
        return roleMapper.findCount();
    }

    @Override
    public Role findRoleByRoleId(int serviceId) {
        return roleMapper.findRoleByRoleId(serviceId);
    }

    @Override
    public List<Module> findAllModule() {
        return moduleMapper.findAllModule();
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateNameByRoleId(role);
        roleMapper.deleteModules(role.getRoleId());
        roleMapper.insertModules(role);
    }

    @Override
    public void addRole(Role role) {
        roleMapper.insert(role);
        System.out.println(role.getRoleId());
        roleMapper.insertModules(role);
    }

    @Override
    public void deleteRole(int roleId) {
        roleMapper.deleteModules(roleId);
        roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }
}
