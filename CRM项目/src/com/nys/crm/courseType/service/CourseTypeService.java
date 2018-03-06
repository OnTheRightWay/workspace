package com.nys.crm.courseType.service;

import com.nys.crm.courseType.domain.CourseType;

import java.util.List;

public interface CourseTypeService {
    List<CourseType> findAllByPage(int begin, int pageSize, String courseName, String remark, String mintotal, String maxtotal, String minCourseCost, String maxCourseCost);
    int findCount(String courseName, String remark, String mintotal, String maxtotal, String minCourseCost, String maxCourseCost);

    void addCourseType(CourseType courseType);

    CourseType findByCourseId(String courseTypeId);

    void updateCourseType(CourseType courseType);

    List<CourseType> findAll();
}
