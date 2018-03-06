package com.nys.crm.classes.web.action;

import com.nys.crm.classes.domain.Classes;
import com.nys.crm.classes.service.ClassesService;
import com.nys.crm.courseType.domain.CourseType;
import com.nys.crm.courseType.service.CourseTypeService;
import com.nys.paging.PagingUtil;
import com.nys.paging.bean.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClassesAction extends ActionSupport implements ModelDriven<Classes>,ServletRequestAware{
    private ClassesService classesService;
    private CourseTypeService courseTypeService;
    private HttpServletRequest request;
    private Classes classes;
    private PageBean<Classes> pageBean = new PageBean<>();
    private int pc;
    private File schedule;
    private String scheduleFileName;
    private InputStream download;
    private String filename;
    private String scheduleContentType;

    public String findAllByPage(){
        int size = 5;
        pageBean.setPageSize(size);
        int begin = (pc-1)*size;
        int count = classesService.findCount();
        List<Classes> list = classesService.findByPage(begin, size);
        PageBean pageBean = PagingUtil.getPageBean(this.pageBean, list, pc, count, null, null);
        request.setAttribute("pageBean",pageBean);
        return "listClass";
    }

    public String upload() throws Exception{

        String uploadPath = "/upload/"+scheduleFileName;
        System.out.println(scheduleFileName);
        OutputStream os = new FileOutputStream(new File("C:"+uploadPath));
        InputStream is = new FileInputStream(schedule);

        byte[] buf = new byte[1024];
        int length = 0;

        while ((length = is.read(buf))!=-1){
            os.write(buf,0,length);
        }
        String uploadTime= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        classesService.updateUpload(classes.getClassId(),uploadTime,uploadPath, scheduleFileName);
        is.close();
        os.close();

        return "findAllByPage";
    }
    public String download() throws FileNotFoundException {
        Classes classes = classesService.findById(this.classes.getClassId());
        filename = classes.getUploadFilename();
        if (filename==null){
            return "findAllByPage";
        }
        download = new FileInputStream(new File(classes.getUploadPath()));
        return "download";
    }

    public String toUpload(){
        String classId = classes.getClassId();
        Classes classes = classesService.findById(classId);
        ActionContext.getContext().put("classes",classes);
        return "uploadClass";
    }

    public String addOrEditClasses(){
        if (classes.getCourseType().getCourseTypeId()==null||classes.getCourseType().getCourseTypeId().equals("")){
            return "findAllByPage";
        }
        if (classes.getClassId()==null||this.classes.getClassId().equals("")){
            classesService.addClasses(classes);
            return "findAllByPage";
        }
        classesService.updateClasses(classes);
        return "findAllByPage";
    }
    public String toEdit(){
        Classes classes=null;
        if (this.classes.getClassId()!=null||!this.classes.getClassId().equals("")){

             classes= classesService.findById(this.classes.getClassId());
        }
        List<CourseType> courseTypes = courseTypeService.findAll();
        ActionContext.getContext().put("courseTypes",courseTypes);
        if (classes==null){
            return "addOrEditClasses";
        }
        request.setAttribute("classes",classes);
        return "addOrEditClasses";
    }

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }

    @Override
    public Classes getModel() {
        return classes;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    public InputStream getDownload() {
        return download;
    }

    public void setDownload(InputStream download) {
        this.download = download;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public File getSchedule() {
        return schedule;
    }

    public void setSchedule(File schedule) {
        this.schedule = schedule;
    }

    public String getScheduleFileName() {
        return scheduleFileName;
    }

    public void setScheduleFileName(String scheduleFileName) {
        this.scheduleFileName = scheduleFileName;
    }

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    public String getScheduleCountentType() {
        return scheduleContentType;
    }

    public void setScheduleCountentType(String scheduleCountentType) {
        this.scheduleContentType = scheduleCountentType;
    }
}
