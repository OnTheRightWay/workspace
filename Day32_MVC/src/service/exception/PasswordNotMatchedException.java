package service.exception;

public class PasswordNotMatchedException extends LoginException {
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
