package com.nys.admin.service.impl;

import com.nys.admin.dao.AdminMapper;
import com.nys.admin.domain.Admin;
import com.nys.admin.service.AdminService;
import com.nys.admin.service.exception.LoginException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    private ClassPathXmlApplicationContext context;
    private final AdminMapper adminMapper;

    public AdminServiceImpl(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        adminMapper = context.getBean(AdminMapper.class);
    }

    public Admin login(String adminCode, String password, String vCode) throws LoginException {
        Admin byAdminCode = adminMapper.findByAdminCode(adminCode);
        if (byAdminCode==null){
            throw new LoginException();
        }
        if (!byAdminCode.getPassword().equals(password)){
            throw new LoginException();
        }
        return byAdminCode;
    }

    @Override
    public List<Admin> findAdminByPage(int begin, int size,String[] values) {
        Map<String,Object> map = new HashMap<>();
        map.put("begin",begin);
        map.put("size",size);
        map.put("moduleId",values[0]);
        map.put("name",values[1]);
        List<Admin> admins = adminMapper.findAdminByPage(map);

        List<Admin> r = new ArrayList<>();
        for (int i = begin; i < begin + size; i++) {
            if (i>admins.size()-1){
                break;
            }
            r.add(admins.get(i));
        }
        if (r.size() == 0) {
            return null;
        }
        List<Admin> a = adminMapper.findAdminsByAdminId(r);
        return a;
    }

    @Override
    public int findCountByPage(String[] values) {
        Map<String,Object> map = new HashMap<>();
        map.put("moduleId",values[0]);
        map.put("name",values[1]);
        List<Admin> admins = adminMapper.findAdminByPage(map);
        return admins.size();
    }

    @Override
    public void updatePasswordReset(List<Integer> adminIds) {
        adminMapper.updatePasswordReset(adminIds);
    }

    @Override
    public void addAdmin(Admin admin) {
        admin.setEnrolldate(new Date());
        adminMapper.insert(admin);
        adminMapper.insertRole(admin);
    }

    @Override
    public void deleteAdmin(int adminId) {
        adminMapper.deleteRole(adminId);
        adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public Admin findAdminByAdminId(int adminId) {
        return adminMapper.findAdminByAdminId(adminId);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
        adminMapper.deleteRole(admin.getAdminId());
        adminMapper.insertRole(admin);
    }
}
