package user.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import user.domain.User;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.UUID;

public class UserDao {
    private QueryRunner qr = C3P0Util.getQuery();
    public void insert(User user){
        try {
            qr.update(
                    "insert into user values(null,?,?)",
                    user.getUsername(),user.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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
}
