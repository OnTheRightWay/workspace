package com.nys.crm.department.service;

import com.nys.crm.department.domain.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> findAll();

    int findCount();

    List<Department> findAllByPage(int begin, int size);

    Department findById(String depId);

    void addDep(Department department);

    void updateDep(Department department);
}
