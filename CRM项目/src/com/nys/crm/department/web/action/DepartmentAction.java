package com.nys.crm.department.web.action;

import com.nys.crm.department.domain.Department;
import com.nys.crm.department.service.DepartmentService;
import com.nys.paging.PagingUtil;
import com.nys.paging.bean.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>,ServletRequestAware {
    private Department department;
    private DepartmentService departmentService;
    private HttpServletRequest request;
    private int pc;
    private PageBean<Department> pageBean = new PageBean<>();

    public String findAllByPage(){
        int size = 10;
        pageBean.setPageSize(size);
        int begin = (pc-1)/size;
        List<Department> departments = departmentService.findAllByPage(begin,size);
        int count = departmentService.findCount();
        PageBean pageBean = PagingUtil.getPageBean(this.pageBean, departments, pc, count, null, null);
        System.out.println(pageBean.getClass().getName());
        request.setAttribute("pageBean", pageBean);
        return "listDepartment";
    }

    public String toEdit(){
        Department department = departmentService.findById(this.department.getDepId());
        ActionContext.getContext().put("department",department);
        return "addOrEditDepartment";
    }

    public String addOrEdit(){
        if (department.getDepName()==null){
            return "findAllByPage";
        }
        if (department.getDepId()==null||department.getDepId().equals("")){
            departmentService.addDep(department);
            return "findAllByPage";
        }
        departmentService.updateDep(department);
        return "findAllByPage";
    }




    @Override
    public Department getModel() {
        return department;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request=httpServletRequest;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public PageBean<Department> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Department> pageBean) {
        this.pageBean = pageBean;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
