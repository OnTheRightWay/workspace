package com.nys.crm.classes.dao.impl;

import com.nys.crm.classes.dao.ClassesDao;
import com.nys.crm.classes.domain.Classes;
import com.nys.crm.courseType.domain.CourseType;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class ClassesDaoImpl extends HibernateDaoSupport implements ClassesDao {
    @Override
    public List<Classes> findAllByPages(int begin, int size) {
        return getHibernateTemplate().execute(new HibernateCallback<List<Classes>>() {
            @Override
            public List<Classes> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(
                        "select c from Classes c"
                );
                query.setFirstResult(begin);
                query.setMaxResults(size);
                return query.list();
            }
        });
    }

    @Override
    public int findCount() {
        List<?> list = getHibernateTemplate().find(
                "select count (*) from Classes c"
        );
        long count = (Long) list.get(0);
        return (int) count;
    }

    @Override
    public Classes findById(String classId) {
        return getHibernateTemplate().get(Classes.class, classId);
    }

    @Override
    public void updateUpload(String classId, String uploadTime, String uploadPath, String uploadFilename) {
        Classes classes = findById(classId);
        classes.setUploadTime(uploadTime);
        classes.setUploadPath(uploadPath);
        classes.setUploadFilename(uploadFilename);
    }

    @Override
    public void addClasses(Classes classes) {
        CourseType courseType = getHibernateTemplate().get(CourseType.class, classes.getCourseType().getCourseTypeId());
        classes.setCourseType(courseType);
        getHibernateTemplate().save(classes);
    }

    @Override
    public void updateClasses(Classes classes) {
        Classes classes1 = getHibernateTemplate().get(Classes.class,classes.getClassId());
        if (classes1==null){
            System.out.println("______________");
            return;
        }
        classes1.setName(classes.getName());
        CourseType courseType = getHibernateTemplate().get(CourseType.class, classes.getCourseType().getCourseTypeId());
        classes1.setCourseType(courseType);
        classes1.setBeginTime(classes.getBeginTime());
        classes1.setEndTime(classes.getEndTime());
        classes1.setRemark(classes.getRemark());
    }
}

