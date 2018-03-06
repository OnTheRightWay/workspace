package com.nys.crm.courseType.service.impl;

import com.nys.crm.courseType.dao.CourseTypeDao;
import com.nys.crm.courseType.domain.CourseType;
import com.nys.crm.courseType.service.CourseTypeService;

import java.util.List;

public class CourseTypeServiceImpl implements CourseTypeService {
    private CourseTypeDao courseTypeDao;

    @Override
    public  List<CourseType> findAllByPage(int begin, int pageSize, String courseName, String remark, String mintotal, String maxtotal, String minCourseCost, String maxCourseCost) {
        return courseTypeDao.findAllByPage(begin,pageSize,creatSQLWhere(courseName,remark,mintotal,maxtotal,minCourseCost,maxCourseCost));

    }

    @Override
    public int findCount(String courseName, String remark, String mintotal, String maxtotal, String minCourseCost, String maxCourseCost) {
        return courseTypeDao.findCount(creatSQLWhere(courseName,remark,mintotal,maxtotal,minCourseCost,maxCourseCost));
    }

    @Override
    public void addCourseType(CourseType courseType) {
        if (courseType==null){
            return;
        }
        courseTypeDao.addCourseType(courseType);
    }

    @Override
    public CourseType findByCourseId(String courseTypeId) {
        return courseTypeDao.findByCourseId(courseTypeId);
    }

    @Override
    public void updateCourseType(CourseType courseType) {
        courseTypeDao.updateCourseType(courseType);
    }

    @Override
    public List<CourseType> findAll() {
        return courseTypeDao.findAll();
    }

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    public String creatSQLWhere(String courseName, String remark, String mintotal, String maxtotal, String minCourseCost, String maxCourseCost){
        StringBuilder sb = new StringBuilder();

        boolean isFirst = true;
        if (courseName!=null&&!courseName.equals("")){
            if (isFirst){
                sb.append(" where ");
                isFirst = false;
            }else {
                sb.append(" and ");
            }
            sb.append(" c.courseName=").append("'"+courseName+"'");
        }
        if (remark!=null&&!remark.equals("")){
            if (isFirst){
                sb.append(" where ");
                isFirst = false;
            }else {
                sb.append(" and ");
            }
            sb.append(" c.remark=").append("'"+remark+"'");
        }
        if ((mintotal!=null&&!mintotal.equals(""))||(maxtotal!=null&&!maxtotal.equals(""))){
            if (isFirst){
                sb.append(" where ");
                isFirst = false;
            }else {
                sb.append(" and ");
            }
            if (mintotal!=null&&!mintotal.equals("")&&maxtotal!=null&&!maxtotal.equals("")){
                sb.append(" c.total between ").append("'"+mintotal+"'").append(" and ").append("'"+maxtotal+"'");
            }else if (maxtotal==null||maxtotal.equals("")){
                sb.append(" c.total>").append("'"+mintotal+"'");
            }else {
                sb.append(" c.total<").append("'"+maxtotal+"'");
            }
        }
        if ((minCourseCost!=null&&!minCourseCost.equals(""))||(maxCourseCost!=null&&!maxCourseCost.equals(""))){
            if (isFirst){
                sb.append(" where ");
                isFirst = false;
            }else {
                sb.append(" and ");
            }
            if (minCourseCost!=null&&!minCourseCost.equals("")&&maxCourseCost!=null&&!maxCourseCost.equals("")){
                sb.append(" c.courseCost between ").append("'"+minCourseCost+"'").append(" and ").append("'"+maxCourseCost+"'");
            }else if (maxCourseCost==null||maxCourseCost.equals("")){
                sb.append(" c.courseCost>").append("'"+minCourseCost+"'");
            }else {
                sb.append(" c.courseCost<").append("'"+maxCourseCost+"'");
            }
        }
        return sb.toString();
    }

}
