package com.nys.crm.staff.dao;

import com.nys.crm.department.domain.Department;
import com.nys.crm.post.domain.Post;
import com.nys.crm.staff.domain.Staff;
import com.nys.crm.staff.domain.StaffItem;

import java.util.List;

public interface StaffDao {
    Staff findByLoginName(String loginName);

    void updatePsw(String loginName, String newPassword);

    List<Staff> findAll();

    List<StaffItem> findAllStaffItem();

    Staff findByStaffId(String staffId);





    void updateStaff(Staff staff);

    List<Staff> findByParams(String postId, String depId, String staffName);

    void add(Staff staff);
}
