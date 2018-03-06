package com.nys.crm.courseType.dao.impl;

import com.nys.crm.courseType.dao.CourseTypeDao;
import com.nys.crm.courseType.domain.CourseType;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {
    @Override
    public List<CourseType> findAllByPage(int begin, int pageSize, String sqlWhere) {
        String sql = "from CourseType c"+ sqlWhere;
        System.out.println(sql);
        return getHibernateTemplate().execute(new HibernateCallback<List<CourseType>>() {
            @Override
            public List<CourseType> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(sql);
                query.setFirstResult(begin);
                query.setMaxResults(pageSize);
                return query.list();
            }
        });
    }
    @Override
    public int findCount(String sqlWhere){
        String sql = "select count(*) from CourseType c"+ sqlWhere;
        List<?> list = getHibernateTemplate().find(
                sql
        );
        long i = (Long) list.get(0);
        return (int) i;
    }

    @Override
    public void addCourseType(CourseType courseType) {
        getHibernateTemplate().save(courseType);
    }

    @Override
    public CourseType findByCourseId(String courseTypeId) {
        return getHibernateTemplate().get(CourseType.class, courseTypeId);
    }

    @Override
    public void updateCourseType(CourseType courseType) {
        getHibernateTemplate().update(courseType);
    }

    @Override
    public List<CourseType> findAll() {
        return (List<CourseType>) getHibernateTemplate().find(
                "from CourseType c"
        );
    }
}
