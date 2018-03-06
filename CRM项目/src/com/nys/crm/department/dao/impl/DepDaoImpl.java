package com.nys.crm.department.dao.impl;

import com.nys.crm.department.dao.DepDao;
import com.nys.crm.department.domain.Department;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DepDaoImpl extends HibernateDaoSupport implements DepDao {
    @Override
    public Department findDepByStaffId(String staffId) {
        List<?> list = getHibernateTemplate().find(
                "from Department where depId=(" +
                        "select p.depId from Post p where postId=(" +
                        "select s.postId from Staff s where staffId=?" +
                        ")" +
                        ")", staffId
        );
//        List<?> from_staff_ = getHibernateTemplate().find("from Staff ");
//        System.out.println(Arrays.toString(from_staff_.toArray()));
        if (list.size()==0){
            return null;
        }
        return (Department) list.get(0);
    }

    @Override
    public List<Department> findAllDep() {
        return (List<Department>) getHibernateTemplate().find("from Department ");
    }

    @Override
    public Department findDepByDepId(String depId) {
        return getHibernateTemplate().get(Department.class, depId);
    }

    @Override
    public List<Department> findAllByPage(int begin, int size) {
        return getHibernateTemplate().execute(
                new HibernateCallback<List<Department>>() {
                    @Override
                    public List<Department> doInHibernate(Session session) throws HibernateException {
                        Query query = session.createQuery("from Department d");
                        query.setFirstResult(begin);
                        query.setMaxResults(size);
                        return query.list();
                    }
                }
        );
    }

    @Override
    public int findCount() {
        List<?> list = getHibernateTemplate().find(
                "select count(*) from Department d"
        );
        long i = (Long) list.get(0);
        return (int) i;
    }

    @Override
    public void addDep(Department department) {
        getHibernateTemplate().save(department);
    }

    @Override
    public void update(Department department) {
        getHibernateTemplate().update(department);
    }
}
