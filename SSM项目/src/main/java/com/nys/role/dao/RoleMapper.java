package com.nys.role.dao;

import com.nys.cost.domain.PageBean;
import com.nys.role.domain.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findAllRole();

    int findCount();

    Role findRoleByRoleId(int serviceId);

    void updateNameByRoleId(Role role);

    void deleteModules(Integer roleId);

    void insertModules(Role role);


}