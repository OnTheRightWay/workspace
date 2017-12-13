package study.exception;

public class UserExistsException extends RegisterException{
    @Override
    public String getMessage() {
        return "用户已存在";
    }
}
