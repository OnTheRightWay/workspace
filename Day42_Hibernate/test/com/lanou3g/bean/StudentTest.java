package com.lanou3g.bean;

import com.lanou3g.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class StudentTest {
    //快速删除类中无用的import语句
    //art+ctrl+o

    @Test
    public void hello(){
        new Configuration().configure().buildSessionFactory();
    }
    @Test
    public void save(){
        SessionFactory sf =
                new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Student student = new Student();
        student.setSid(1);
        student.setName("猴子");
        student.setAge(200);
        student.setGender("男");

        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void get(){
        Session session = new Configuration().configure().buildSessionFactory()
                .openSession();
        session.beginTransaction();
        //通过id找到对应的数据
        Student student = session.get(Student.class,1L);
        Student s = session.get(Student.class,1L);
        //脱管
        //将s指向的对象，从持久化转为游离态
        //此时hibernate也就不再维护对象的状态
        //什么叫维护？
        //只要一个对象处于持久化状态
        //hibernate就会保证它的属性值与数据库中的一致
        session.evict(s);
        s.setName("王五");
        System.out.println(student);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void update(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, 1L);

        //下面这条语句作用是把student变为游离状态
        //改变对象的属性之后，不会改变数据库中的内容
//        session.evict(student);

        student.setName("紫霞");
        //是不需要再执行session.update()方法的
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void delete(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, 1L);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void flush(){
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student1 = session.get(Student.class, 1L);
        Student student2 = session.get(Student.class, 2L);
        student2.setName("王五");
        Student student3 = new Student();
        student3.setName("赵六");
        student3.setAge(666);
        student3.setGender("男");
        session.save(student3);
        session.flush();
        transaction.commit();
        session.close();
    }
    @Test
    public void get2(){
        Student student = HibernateUtil.handle(new HibernateUtil.Execute<Student>() {
            @Override
            public Student execute(Session session) {
                return session.get(Student.class, 1L);
            }
        });
        System.out.println(student);
    }
}