package user.dao;

import com.nys.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import user.domain.User;

import java.util.List;

public class UserDao {
    public User queryByUsername(String username){
        return HibernateUtil.handle(session -> {
//            SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM user WHERE username = ?");
//            sqlQuery.setParameter(0, username);
            Query query = session.createQuery("select u from User u where u.username=?");
            query.setParameter(0,username);
            List<User> list = query.list();
            if (list.size()==0){
                return null;
            }
            return list.get(0);
        });
    }
}
