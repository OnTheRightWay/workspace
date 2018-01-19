package com.lanou3g.bean;

import com.lanou3g.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class ClazzTest {
    /**
     * 通过debug
     * 我们发现，在执行save方法后
     * 缓存map中，出现了两条数据
     *
     * 所以我们可以知道
     * save方法可以将数据保存到缓存中
     */
    @Test
    public void save(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Clazz clazz = new Clazz();
        clazz.setCid(2);
        clazz.setCname("一年二班");
        Clazz clazz2 = new Clazz();
        clazz2.setCid(3);
        clazz2.setCname("一年三班");
        Transaction transaction = session.beginTransaction();
        session.save(clazz);
        transaction.commit();

        session.beginTransaction();
        Clazz clazz1 = session.get(Clazz.class, 1);
        System.out.println(clazz1);
        session.getTransaction().commit();

        session.close();
    }
    @Test
    public void get(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        Clazz clazz = session.get(Clazz.class, 2);
        session.getTransaction().commit();
        session.close();

        Session session1 = new Configuration().configure().buildSessionFactory().openSession();
        session1.beginTransaction();
        Clazz clazz1 = session1.get(Clazz.class, 2);
        System.out.println(clazz);
        session1.getTransaction().commit();
        session1.close();
    }
    @Test
    public void evict(){
        HibernateUtil.handle(new HibernateUtil.Execute<Clazz>() {
            @Override
            public Clazz execute(Session session) {
                //这里这个get会将找到的班级对象，存入缓存中
                Clazz clazz = session.get(Clazz.class, 2);
                //evict方法，会将这个班级对象从缓存中移除
                session.evict(clazz);

                //缓存中没有这个对象了，
                //再次get，会去数据库中再查一遍
                Clazz clazz1 = session.get(Clazz.class, 2);
                return null;
            }
        });
    }

    @Test
    public void oneToMany1(){
        HibernateUtil.handle(session -> {
            Student zhangSan = new Student();
            zhangSan.setSname("张三");

            Student liSi = new Student();
            liSi.setSname("李四");

            session.save(zhangSan);
            session.save(liSi);

            Clazz clazz = new Clazz();
            clazz.getStudents().add(zhangSan);
            clazz.getStudents().add(liSi);
            clazz.setCname("四年四班");
            session.save(clazz);
            return clazz;
        });
    }
    @Test
    public void onToMany2(){
        HibernateUtil.handle(session -> {
            Student wangWu = new Student();
            wangWu.setSname("王五");
            Student zhaoLiu = new Student();
            zhaoLiu.setSname("赵六");

            Clazz clazz = new Clazz();
            clazz.setCname("Java班级");
            clazz.getStudents().add(wangWu);
            clazz.getStudents().add(zhaoLiu);

            //以为设置了级联属性为save-update
            //所以保存班级时，也会级联保存学生
            session.save(clazz);
            return clazz;
        });
    }
    @Test
    public void oneToMany3(){
        HibernateUtil.handle(session -> {
            Clazz clazz = session.get(Clazz.class,5);
            clazz.getStudents().add(new Student("小红"));
            clazz.getStudents().add(new Student("小明"));
            return clazz;
        });
    }
    @Test
    public void onToMany4(){
        HibernateUtil.handle(session -> {

            Clazz clazz = session.get(Clazz.class, 2);

            //给两个学生一个班级对象
            Student s1 = new Student("张三丰");
            s1.setClazz(clazz);

            Student s2 = new Student("李隆基");
            s2.setClazz(clazz);

            session.save(s1);
            session.save(s2);

            return null;
        });
    }
}