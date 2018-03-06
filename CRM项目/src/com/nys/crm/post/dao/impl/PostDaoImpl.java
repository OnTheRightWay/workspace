package com.nys.crm.post.dao.impl;

import com.nys.crm.department.domain.Department;
import com.nys.crm.post.dao.PostDao;
import com.nys.crm.post.domain.Post;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;
import java.util.Set;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public List<Post> findAllPost() {
        return (List<Post>) getHibernateTemplate().find("from Post ");
    }

    @Override
    public  Set<Post> findPostByDepId(String depId) {
        List<?> list = getHibernateTemplate().find("from Department d where d.depId=?", depId);
        Department department = (Department) list.get(0);
        return department.getPosts();
    }

    @Override
    public List<Post> findByPage(int begin, int size) {
        return getHibernateTemplate().execute(new HibernateCallback<List<Post>>() {
            @Override
            public List<Post> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(
                        "from Post p"
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
                "select count(*) from Post p"
        );
        long i = (Long) list.get(0);
        return (int) i;
    }

    @Override
    public void addPost(Post post) {
        Department department = getHibernateTemplate().get(Department.class, post.getDepId());
        post.setDepartment(department);
        getHibernateTemplate().save(post);
    }

    @Override
    public void updatePost(Post post) {
        Department department = getHibernateTemplate().get(Department.class, post.getDepId());
        post.setDepartment(department);
        getHibernateTemplate().update(post);
    }

    @Override
    public Post findById(String postId) {
        return getHibernateTemplate().get(Post.class, postId);
    }
}
