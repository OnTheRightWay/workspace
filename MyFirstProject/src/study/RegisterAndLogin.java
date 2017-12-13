package study;

import org.dom4j.DocumentException;
import study.exception.*;

import java.io.IOException;
import java.util.Scanner;

public class RegisterAndLogin {
    private static Scanner input = new Scanner(System.in);
    public static void register() throws RegisterException, DocumentException {
        System.out.println("请选择你的昵称（只包含英文字母）");
        String name = input.nextLine();
        if(!name.matches("[a-zA-Z]+")){
            System.out.println("名字必须为英文");
            return;
        }
        System.out.println("用户名(邮箱或手机号)");
        System.out.print("username:");
        String userName = input.nextLine();
        if(!(userName.matches("\\d{11}")||userName.matches(".+@.+\\.com"))){
            throw new UserNameErrorException();
        }
        System.out.println("密码（包含大小写字母和数字）");
        System.out.print("password:");
        String password = input.nextLine();
        if((!password.matches(".{7,13}"))||password.matches("[a-zA-Z]*|[0-9a-z]|[0-9A-Z]")){
            throw new UnsafePasswordException();
        }
        try {
            UserData.addUser(name,userName,password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("注册成功");
    }


    public static String Login() throws LoginException, DocumentException {
        System.out.println("请输入账号和密码");
        System.out.print("username:");
        String userName = input.nextLine();
        System.out.print("password:");
        String password = input.nextLine();
        if (UserData.getPassword(userName).equals(password)){
            return userName;
        }
        throw new PasswordErrorException();
    }
}
