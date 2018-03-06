package com.nys.crm.courseType.web.action;

import com.nys.crm.courseType.domain.CourseType;
import com.nys.crm.courseType.service.CourseTypeService;
import com.nys.paging.bean.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseTypeAction extends ActionSupport implements ServletRequestAware,ModelDriven<CourseType>{
    private CourseTypeService courseTypeService;
    private HttpServletRequest request;
    private PageBean<CourseType> pageBean = new PageBean<>();
    private CourseType courseType;
    private int pc;
    private String maxtotal;
    private String mintotal;
    private String maxCourseCost;
    private String minCourseCost;


    public String findAllByPage(){
        pageBean.setPageSize(10);
        String courseName = courseType.getCourseName();
        String remark = courseType.getRemark();
        String[] params = {"courseName","remark","mintotal","maxtotal","minCourseCost","maxCourseCost"};
        String[] values = {courseName,remark,mintotal,maxtotal,minCourseCost,maxCourseCost};
        Map<String,String> postParam = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            postParam.put(params[i],values[i]);
        }
        pageBean.setParams(postParam);


        int count = courseTypeService.findCount(courseName,remark,mintotal,maxtotal,minCourseCost,maxCourseCost);
        int size = pageBean.getPageSize();
        int totalPage = count/size;
        if (count%size>0){
            totalPage = totalPage+1;
        }
        if (pc>totalPage){
            pc=totalPage;
        }
        int begin = (pc-1)*size;
        List<CourseType> types = courseTypeService.findAllByPage(begin, size, courseName, remark, mintotal, maxtotal, minCourseCost, maxCourseCost);
        pageBean.setLists(types);
        pageBean.setTotalPage(totalPage);
        pageBean.setCurrentPage(pc);

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < values.length; i++) {
            if (values[i]!=null&&!values[i].equals("")){
                sb.append("&"+params[i]+"="+values[i]);
            }
        }
        String getParam = sb.toString();
        pageBean.setParam(getParam);
        request.setAttribute("pageBean",pageBean);

        return "listCourse";
    }


    public String addOrEditCourseType(){
        if(courseType.getCourseTypeId()==null){
            courseTypeService.addCourseType(courseType);
            return "findAllByPage";
        }
        courseTypeService.updateCourseType(courseType);
        return "findAllByPage";

    }
    public String toEdit(){
        String courseTypeId = this.courseType.getCourseTypeId();
        CourseType courseType = courseTypeService.findByCourseId(courseTypeId);
        ActionContext.getContext().put("courseType",courseType);
        return "addOrEditCourse";
    }


    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    public void setPageBean(PageBean<CourseType> pageBean) {
        this.pageBean = pageBean;
    }

    public CourseTypeService getCourseTypeService() {
        return courseTypeService;
    }

    public PageBean<CourseType> getPageBean() {
        return pageBean;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }


    public String getMaxtotal() {
        return maxtotal;
    }

    public void setMaxtotal(String maxtotal) {
        this.maxtotal = maxtotal;
    }

    public String getMintotal() {
        return mintotal;
    }

    public void setMintotal(String mintotal) {
        this.mintotal = mintotal;
    }

    public String getMaxCourseCost() {
        return maxCourseCost;
    }

    public void setMaxCourseCost(String maxCourseCost) {
        this.maxCourseCost = maxCourseCost;
    }

    public String getMinCourseCost() {
        return minCourseCost;
    }

    public void setMinCourseCost(String minCourseCost) {
        this.minCourseCost = minCourseCost;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    @Override
    public CourseType getModel() {
        return courseType;
    }
}
