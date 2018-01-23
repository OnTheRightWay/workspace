package user.dao;

import org.junit.Test;
import user.domain.User;

public class UserDaoTest {
    @Test
    public void test1(){
        UserDao userDao = new UserDao();
        User user = userDao.queryByUsername("root");
        System.out.println(user);
    }
}