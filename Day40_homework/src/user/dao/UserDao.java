package user.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import untils.C3P0Util;
import user.domain.User;

import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr = C3P0Util.getQuery();
    public User queryByUsername(String username){
        User user = null;
        try {
            user = qr.query(
                    "select * from user where username=?",
                    new BeanHandler<User>(User.class),
                    username
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void insert(User user){
        try {
            qr.update(
                    "insert into user values(?,?,?,?)",
                    user.getUsername(),user.getPassword(),
                    user.getTele(),user.getEmail()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
