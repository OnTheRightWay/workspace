package user.service.exception;

public class UserIsExistException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户已存在";
    }
}
