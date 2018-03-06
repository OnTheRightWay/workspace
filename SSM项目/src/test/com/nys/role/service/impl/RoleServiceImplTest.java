package com.nys.role.service.impl;

import com.nys.role.domain.Role;
import com.nys.role.service.RoleService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoleServiceImplTest {
    private RoleService roleService = new RoleServiceImpl();
    @Test
    public void findOneRole() throws Exception {
        List<Role> roles = roleService.findRoleByPage(0, 2);
        System.out.println(roles);
    }

    @Test
    public void updateRole() throws Exception {
        Role role = new Role();
        role.setRoleId(100);
        List<Integer> list = new ArrayList<>();
        role.setModuleIds(list);
        role.getModuleIds().add(1);
        role.getModuleIds().add(3);
        role.getModuleIds().add(2);
        roleService.updateRole(role);
    }

    @Test
    public void dd() throws Exception {
        String[] split = "/service/findServiceByPage".split("/");
        System.out.println(split[1]);
    }
}