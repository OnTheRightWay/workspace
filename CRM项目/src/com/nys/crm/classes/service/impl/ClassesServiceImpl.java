package com.nys.crm.classes.service.impl;

import com.nys.crm.classes.dao.ClassesDao;
import com.nys.crm.classes.domain.Classes;
import com.nys.crm.classes.service.ClassesService;
import com.nys.crm.courseType.dao.CourseTypeDao;
import com.nys.crm.courseType.domain.CourseType;

import java.util.List;

public class ClassesServiceImpl implements ClassesService {
    private ClassesDao classesDao;

    @Override
    public List<Classes> findByPage(int begin, int size) {
        return classesDao.findAllByPages(begin, size);
    }

    @Override
    public int findCount() {
        return classesDao.findCount();
    }

    @Override
    public Classes findById(String classId) {
        return classesDao.findById(classId);
    }

    @Override
    public void updateUpload(String classId, String uploadTime, String uploadPath, String uploadFilename) {
        classesDao.updateUpload(classId,uploadTime,uploadPath,uploadFilename);
    }

    @Override
    public void addClasses(Classes classes) {
        classesDao.addClasses(classes);
    }

    @Override
    public void updateClasses(Classes classes) {
        classesDao.updateClasses(classes);
    }

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }
}
