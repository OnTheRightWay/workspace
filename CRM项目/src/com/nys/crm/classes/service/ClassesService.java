package com.nys.crm.classes.service;

import com.nys.crm.classes.domain.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> findByPage(int begin,int size);
    int findCount();

    Classes findById(String classId);

    void updateUpload(String classId,String uploadTime, String uploadPath, String uploadFilename);

    void addClasses(Classes classes);

    void updateClasses(Classes classes);
}
