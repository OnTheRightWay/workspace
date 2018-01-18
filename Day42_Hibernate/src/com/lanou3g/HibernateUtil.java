package com.lanou3g;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    public interface Execute<T>{
        T execute(Session session);
    }
    private static SessionFactory sf;
    static {
        sf = new Configuration().configure().buildSessionFactory();
    }
    public static <T> T handle(Execute<T> execute){
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        T result = execute.execute(session);
        transaction.commit();
        session.close();
        return result;
    }
}
