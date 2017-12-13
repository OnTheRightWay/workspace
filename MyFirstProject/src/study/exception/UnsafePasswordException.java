package study.exception;

public class UnsafePasswordException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码不安全！！请设置有大小写字母和数字组成的密码。";
    }
}
