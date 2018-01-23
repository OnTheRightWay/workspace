package employee.service;

import employee.dao.EmployeeDao;
import employee.domain.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();
    public List<Employee> findAll(){
        return employeeDao.queryAll();
    }
    public void add(Employee employee){
        employeeDao.insert(employee);
    }
    public Employee findById(int id){
        return employeeDao.queryById(id);
    }
    public void modify(Employee e){
        employeeDao.update(e);
    }
}
