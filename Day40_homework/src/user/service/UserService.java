package user.service;

import user.dao.UserDao;
import user.domain.User;
import user.service.exception.*;


public class UserService {
    UserDao userDao = new UserDao();
    public void register(User user) throws UserIsExistException {
        String username = user.getUsername();
        String password = user.getPassword();
        User queryUser = userDao.queryByUsername(username);
        if (queryUser!=null){
            throw new UserIsExistException();
        }
        userDao.insert(user);
    }
    public User login(String username,String password) throws UserIsNotExistException, PasswordErrorException {
        User queryUser = userDao.queryByUsername(username);
        if (queryUser==null){
            throw new UserIsNotExistException();
        }
        if (!queryUser.getPassword().equals(password)){
            throw new PasswordErrorException();
        }
        return queryUser;
    }
}
