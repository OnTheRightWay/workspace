package user.servic.exception;

public class UserIsNotExistException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名错误";
    }
}
