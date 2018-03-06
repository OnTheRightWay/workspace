package com.nys.admin.dao;

import com.nys.admin.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin findByAdminCode(String adminCode);

    List<Admin> findAdminByPage(Map<String, Object> map);

    List findCountByPage(Map<String, Object> map);

    List<Admin> findAdminsByAdminId(List<Admin> admins);

    void updatePasswordReset(List<Integer> adminIds);

    void insertRole(Admin admin);

    void deleteRole(int adminId);

    Admin findAdminByAdminId(int adminId);

    void updateAdmin(Admin admin);
}