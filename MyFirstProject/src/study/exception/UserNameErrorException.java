package study.exception;

public class UserNameErrorException extends RegisterException{
    @Override
    public String getMessage() {
        return "用户名只能是电话号码或邮箱";
    }
}
