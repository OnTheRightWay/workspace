package employee.dao;

import employee.domain.Employee;
import org.junit.Test;

import java.util.List;

public class EmployeeDaoTest {
    @Test
    public void test(){
        Employee employee = new Employee(4,"王五",66,"旺旺","2056-08-08","费尔法","154544545");

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.update(employee);
        Employee employee1 = employeeDao.queryById(4);
        System.out.println(employee1);
    }

}