package com.nys.crm.courseType.dao;

import com.nys.crm.courseType.domain.CourseType;

import java.util.List;

public interface CourseTypeDao {

    List<CourseType> findAllByPage(int begin, int pageSize, String sqlWhere);

    int findCount(String sqlWhere);

    void addCourseType(CourseType courseType);

    CourseType findByCourseId(String courseTypeId);

    void updateCourseType(CourseType courseType);

    List<CourseType> findAll();
}
