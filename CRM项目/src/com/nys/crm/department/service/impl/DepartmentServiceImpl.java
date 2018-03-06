package com.nys.crm.department.service.impl;

import com.nys.crm.department.dao.DepDao;
import com.nys.crm.department.domain.Department;
import com.nys.crm.department.service.DepartmentService;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepDao depDao;

    public List<Department> findAll(){
        return depDao.findAllDep();
    }

    @Override
    public int findCount() {
        return depDao.findCount();
    }

    public void setDepDao(DepDao depDao) {
        this.depDao = depDao;
    }

    @Override
    public List<Department> findAllByPage(int begin, int size) {
        return depDao.findAllByPage(begin,size);
    }

    @Override
    public Department findById(String depId) {
        return depDao.findDepByDepId(depId);
    }

    @Override
    public void addDep(Department department) {
        depDao.addDep(department);
    }

    @Override
    public void updateDep(Department department) {
        depDao.update(department);
    }
}
