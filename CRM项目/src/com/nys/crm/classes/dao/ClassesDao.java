package com.nys.crm.classes.dao;

import com.nys.crm.classes.domain.Classes;

import java.util.List;

public interface ClassesDao {
    List<Classes> findAllByPages(int begin, int size);
    int findCount();

    Classes findById(String classId);

    void updateUpload(String classId,String uploadTime, String uploadPath, String uploadFilename);

    void addClasses(Classes classes);

    void updateClasses(Classes classes);
}
