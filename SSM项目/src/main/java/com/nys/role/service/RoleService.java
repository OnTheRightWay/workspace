package com.nys.role.service;

import com.nys.role.domain.Module;
import com.nys.role.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findRoleByPage(int begin, int size);

    int findCount();

    Role findRoleByRoleId(int serviceId);

    List<Module> findAllModule();

    void updateRole(Role role);

    void addRole(Role role);

    void deleteRole(int roleId);


    List<Role> findAllRole();
}
