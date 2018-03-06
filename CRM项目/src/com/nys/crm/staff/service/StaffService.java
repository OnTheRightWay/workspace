package com.nys.crm.staff.service;

import com.nys.crm.department.domain.Department;
import com.nys.crm.post.domain.Post;
import com.nys.crm.staff.domain.Staff;
import com.nys.crm.staff.domain.StaffItem;
import com.nys.crm.staff.service.exception.DifferentPasswordException;
import com.nys.crm.staff.service.exception.LoginException;
import com.nys.crm.staff.service.exception.PasswordErrorException;

import java.util.List;

public interface StaffService {
    Staff login(String username,String password) throws LoginException;

    void updatePsw(String loginName, String password, String newPassword, String newPasswordAgain) throws DifferentPasswordException, PasswordErrorException;

    List<StaffItem> findAllStaffItem();

    Staff showByStaffId(String staffId);

    List<Post> findAllPost();

    List<Department> findAllDep();

    Department findDepByStaffId(String staffId);

    void update(Staff staff);

    List<Staff> findByParams(String postId, String depId, String staffName);

    void add(Staff staff);
}
