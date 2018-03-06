package com.nys.dao;

import com.nys.domain.Classes;
import com.nys.domain.ClassesQueryParam;

import java.util.List;

public interface ClassesMapper {
    void insertClasses(Classes classes);
    List<Classes> findByCondition(Classes classes);
    List<Classes> findByIds(ClassesQueryParam classesQueryParam);
}
