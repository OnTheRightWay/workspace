package com.nys.crm.department.dao;

import com.nys.crm.department.domain.Department;

import java.util.List;

public interface DepDao {
    Department findDepByStaffId(String staffId);

    List<Department> findAllDep();

    Department findDepByDepId(String depId);

    List<Department> findAllByPage(int begin, int size);

    int findCount();

    void addDep(Department department);

    void update(Department department);
}
