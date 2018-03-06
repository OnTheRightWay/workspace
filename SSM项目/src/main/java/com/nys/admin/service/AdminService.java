package com.nys.admin.service;

import com.nys.admin.domain.Admin;
import com.nys.admin.service.exception.LoginException;

import java.util.List;

public interface AdminService {
    Admin login(String adminCode, String password, String vCode) throws LoginException;

    List<Admin> findAdminByPage(int begin, int size, String[] values);

    int findCountByPage(String[] values);

     void updatePasswordReset(List<Integer> adminIds);

    void addAdmin(Admin admin);

    void deleteAdmin(int adminId);

    Admin findAdminByAdminId(int adminId);

    void updateAdmin(Admin admin);
}
