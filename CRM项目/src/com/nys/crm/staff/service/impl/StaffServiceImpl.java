package com.nys.crm.staff.service.impl;

import com.nys.crm.department.dao.DepDao;
import com.nys.crm.department.domain.Department;
import com.nys.crm.post.dao.PostDao;
import com.nys.crm.post.domain.Post;
import com.nys.crm.staff.dao.StaffDao;
import com.nys.crm.staff.domain.Staff;
import com.nys.crm.staff.domain.StaffItem;
import com.nys.crm.staff.service.StaffService;
import com.nys.crm.staff.service.exception.DifferentPasswordException;
import com.nys.crm.staff.service.exception.LoginException;
import com.nys.crm.staff.service.exception.PasswordErrorException;
import com.nys.crm.utils.Md5Util;

import java.util.List;

public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao;
    private DepDao depDao;
    private PostDao postDao;


    @Override
    public Staff login(String username, String password) throws LoginException {
        Staff staff = staffDao.findByLoginName(username);
        String loginPwd = null;
        if (staff==null){
            throw new LoginException();
        }
        loginPwd = Md5Util.md5(password);
        if (!staff.getLoginPwd().equals(loginPwd)){
            throw new LoginException();
        }

        return staff;
    }

    @Override
    public void updatePsw(String loginName, String password, String newPassword, String newPasswordAgain) throws DifferentPasswordException, PasswordErrorException {
        Staff staff = null;
        try {
            staff = login(loginName,password);
        } catch (LoginException e) {
            throw new PasswordErrorException();
        }
        if (!newPassword.equals(newPasswordAgain)){
            throw new DifferentPasswordException();
        }
        String s = Md5Util.md5(newPassword);
        staffDao.updatePsw(loginName,s);
    }

    @Override
    public List<StaffItem> findAllStaffItem() {
        return staffDao.findAllStaffItem();
    }

    @Override
    public Staff showByStaffId(String staffId) {
        return staffDao.findByStaffId(staffId);
    }

    @Override
    public List<Post> findAllPost() {
        return postDao.findAllPost();
    }

    @Override
    public List<Department> findAllDep() {
        return depDao.findAllDep();
    }

    @Override
    public Department findDepByStaffId(String staffId) {
        return depDao.findDepByStaffId(staffId);
    }

    @Override
    public void update(Staff staff) {
        if (
                staff.getLoginName()==null||
                staff.getLoginPwd()==null||
                staff.getOnDutyDate()==null||
                staff.getStaffName()==null||
                staff.getGender()==null||
                staff.getPostId()==null
        ){
            return;
        }
            staff.setLoginPwd(Md5Util.md5(staff.getLoginPwd()));
            staffDao.updateStaff(staff);
    }

    @Override
    public List<Staff> findByParams(String postId, String depId, String staffName) {
        return staffDao.findByParams(postId,depId,staffName);
    }

    @Override
    public void add(Staff staff) {
        staffDao.add(staff);
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public void setDepDao(DepDao depDao) {
        this.depDao = depDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
