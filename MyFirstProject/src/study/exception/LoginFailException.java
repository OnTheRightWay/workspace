package study.exception;

public class LoginFailException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名或密码错误";
    }
}
