package user.service;

import user.dao.UserDao;
import user.domain.User;
import user.service.exception.PasswordErrorException;
import user.service.exception.UserNotExistException;

public class UserService {

    private UserDao userDao = new UserDao();
    public User login(String username,String password) throws UserNotExistException, PasswordErrorException {
        User user = userDao.queryByUsername(username);
        if (user==null){
            throw new UserNotExistException();
        }
        if (!user.getPassword().equals(password)){
            throw new PasswordErrorException();
        }
        return user;
    }
}
