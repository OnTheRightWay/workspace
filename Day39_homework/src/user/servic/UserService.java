package user.servic;

import user.dao.UserDao;
import user.domain.User;
import user.servic.exception.*;

public class UserService {
    UserDao userDao = new UserDao();
    public void register(User user) throws RegisterException{
        String username = user.getUsername();
        String password = user.getPassword();
        User queryUser = userDao.queryByUsername(username);
        if (queryUser!=null){
            throw new UserIsExistException();
        }
        userDao.insert(user);
    }
    public User login(User user) throws LoginException{
        String username = user.getUsername();
        String password = user.getPassword();
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
