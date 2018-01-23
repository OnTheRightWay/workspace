package employee.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import employee.domain.Employee;
import employee.service.EmployeeService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.List;

public class EmployeeAction extends ActionSupport implements ModelDriven{
    private EmployeeService employeeService = new EmployeeService();
    private Employee employee = new Employee();

    public String add(){
        employeeService.add(employee);
        return SUCCESS;
    }
    @SkipValidation
    public String findAll(){
        List<Employee> all = employeeService.findAll();
        ServletActionContext.getRequest().setAttribute("employs",all);
        return SUCCESS;
    }
    @SkipValidation
    public String toModify(){
        String id = ServletActionContext.getRequest().getParameter("id");
        Integer i = Integer.parseInt(id);
        Employee employee = employeeService.findById(i);
        ActionContext.getContext().put("employee",employee);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (employee.getName()==null||employee.getName().equals("")){
            addFieldError("name","該項不能為空");
        }
    }

    public String modify(){
        System.out.println(employee.getId());
        if (employee.getId()==0){
            return SUCCESS;
        }
        employeeService.modify(employee);
        return SUCCESS;
    }

    @Override
    public Object getModel() {
        return employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
