package study.userdata;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import study.exception.LoginFailException;
import study.exception.RegisterException;
import study.exception.UserExistsException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserData {
    private static SAXReader saxReader = new SAXReader();
    private static File file = new File("src/UserData.xml");
    public static void addUser(String name,String userName,String password) throws DocumentException, RegisterException, IOException {
        Document document = null;
        if(file.exists()){
            document = saxReader.read(file);
            if (document.getRootElement()==null){
                document.addElement("users");
            }
        }else {
            document = DocumentHelper.createDocument();
            document.addElement("users");
        }
        Element root = document.getRootElement();
        List<Element> users = root.elements();
        for (Element user:users) {
            if(user.attribute("userName").getValue().equals(userName)){
                throw new UserExistsException();
            }
        }
        Element user = root.addElement("user");
        user.addAttribute("name",name);
        user.addAttribute("userName",userName);
        user.addAttribute("password",password);
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter(file),outputFormat);
        writer.write(document);
        writer.close();
    }
    public static String getPassword(String userName) throws DocumentException, LoginFailException {
        if(!file.exists()){
            System.out.println("用户不存在");
            return null;
        }
        Document document = saxReader.read(file);
        Element root = document.getRootElement();
        List<Element> users = root.elements();
        for (Element user:users) {
            if(user.attribute("userName").getValue().equals(userName)){
                return user.attribute("password").getValue();
            }
        }
        throw new LoginFailException();
    }
    public static String getName(String userName) throws DocumentException {
        if(!file.exists()){
            System.out.println("用户不存在");
            return null;
        }
        Document document = saxReader.read(file);
        Element root = document.getRootElement();
        List<Element> users = root.elements();
        for (Element user:users) {
            if(user.attribute("userName").getValue().equals(userName)){
                return user.attribute("name").getValue();
            }
        }
        return null;
    }




}
