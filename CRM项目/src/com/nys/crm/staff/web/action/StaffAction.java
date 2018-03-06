package com.nys.crm.staff.web.action;

import com.nys.crm.department.domain.Department;
import com.nys.crm.department.service.DepartmentService;
import com.nys.crm.post.domain.Post;
import com.nys.crm.post.service.PostService;
import com.nys.crm.staff.domain.Staff;
import com.nys.crm.staff.domain.StaffItem;
import com.nys.crm.staff.service.StaffService;
import com.nys.crm.staff.service.exception.DifferentPasswordException;
import com.nys.crm.staff.service.exception.LoginException;
import com.nys.crm.staff.service.exception.PasswordErrorException;
import com.nys.crm.utils.Md5Util;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class StaffAction extends ActionSupport implements ModelDriven<Staff>,ServletRequestAware{
    private StaffService staffService;
    private PostService postService;
    private DepartmentService departmentService;
    private Staff staff = new Staff();
    private HttpServletRequest request;
    private String password;
    private String newPassword;
    private String newPasswordAgain;
    private Department department;



    public String login(){
        Staff staff = null;
        try {
            staff = staffService.login(this.staff.getLoginName(),this.staff.getLoginPwd());
        } catch (LoginException e) {
            request.setAttribute("staff",this.staff);
            System.out.println(e.getMessage());
            addFieldError("login",e.getMessage());
            return "login";
        }
        request.getSession().setAttribute("staff",staff);
        return "frame";
    }

    public String logout(){
        request.getSession().removeAttribute("staff");
        return "login";
    }

    public String updatePsw(){
        Staff login = null;
        Staff staff = (Staff) request.getSession().getAttribute("staff");
        try {
            staffService.updatePsw(staff.getLoginName(),password,newPassword,newPasswordAgain);
        } catch (DifferentPasswordException e) {
            System.out.println(e.getMessage());
            addFieldError("newPasswordAgain",e.getMessage());
            return "updPwd";
        } catch (PasswordErrorException e) {
            System.out.println(e.getMessage());
            addFieldError("password",e.getMessage());
            return "updPwd";
        }
        return "right";
    }

    public String findAllStaffItem(){
//        List<StaffItem> staffItems = staffService.findAllStaffItem();
//        request.setAttribute("staffItems",staffItems);
        List<Staff> staffs = staffService.findByParams(null, null, null);
        ActionContext.getContext().put("staffs",staffs);
//        List<Post> posts = postService.findAll();
        List<Department> departments = departmentService.findAll();
//        ActionContext.getContext().put("posts",posts);
        ActionContext.getContext().put("departments",departments);
        return "listStaff";
    }

    public String showByStaffId(){
        String staffId = request.getParameter("staffId");
        Staff staff = staffService.showByStaffId(staffId);
        List<Post> posts = staffService.findAllPost();
        List<Department> departments = staffService.findAllDep();
        staff.setLoginPwd(Md5Util.md5(staff.getLoginPwd()));
        request.setAttribute("staff",staff);
        request.setAttribute("posts",posts);
        request.setAttribute("departments",departments);
        Department department = staffService.findDepByStaffId(staffId);
        request.setAttribute("department",department);
        return "editStaff";
    }
    public String edit(){
        if (staff.getLoginName()==null||staff.getLoginPwd()==null||staff.getStaffName()==null
                ||staff.getPost().getPostId()==null){
            return "findAllStaffItem";
        }
        staff.setPostId(staff.getPost().getPostId());
        staffService.update(staff);
        return "findAllStaffItem";
    }

    public String findByParams(){
        String postId = staff.getPost().getPostId();
        String depId = staff.getPost().getDepartment().getDepId();
        String staffName = staff.getStaffName();

        List<Department> departments = departmentService.findAll();
        ActionContext.getContext().put("departments",departments);

        List<Staff> staff = staffService.findByParams(postId,depId,staffName);
        ActionContext.getContext().put("staffs",staff);
        return "listStaff";
    }
    public String toAdd(){
        List<Department> departments = departmentService.findAll();
        ActionContext.getContext().put("deps",departments);
        return "addStaff";
    }
    public String add(){
        if (staff.getLoginName()==null||staff.getLoginPwd()==null||staff.getStaffName()==null
                ||staff.getPost().getPostId()==null){
            System.out.println("dsadas");
            return "findAllStaffItem";
        }
        staffService.add(staff);
        return "findAllStaffItem";
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    @Override
    public Staff getModel() {
        return staff;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordAgain() {
        return newPasswordAgain;
    }

    public void setNewPasswordAgain(String newPasswordAgain) {
        this.newPasswordAgain = newPasswordAgain;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
