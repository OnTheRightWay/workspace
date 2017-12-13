package com.lanou3g.homework;

import com.lanou3g.homework.exception.UserNameNotExistsException;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLData {
    private static SAXReader saxReader = new SAXReader();
    private static File file = new File("src/userData.xml");
    public static void writeXMLData(Person person) throws DocumentException, IOException {
        Document document = DocumentHelper.createDocument();
        Element user = null;
        if(file.exists()){
            document=saxReader.read(file);
            user = document.getRootElement();
        }else user =document.addElement("user");

        Element p = user.addElement("person");
        p.addAttribute("userName",person.getUserName());

        Element name = p.addElement("name");
        name.addAttribute("name",person.getName());

        Element userName = p.addElement("userName");
        userName.addAttribute("userName",person.getUserName());

        Element password = p.addElement("password");
        password.addAttribute("password",person.getPassword());

        Element job = p.addElement("job");
        job.addAttribute("job",person.getJob());

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");

        XMLWriter xmlWriter = new XMLWriter(new FileWriter(file),outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
    }
    public static String readXMLData(String userName,String whatYouWant) throws DocumentException {
        if (!file.exists()){
            return null;
        }
        Document document = saxReader.read(file);
        return allXML(document.getRootElement(),userName,whatYouWant);
    }
    public static String allXML(Element e,String userName,String whatYouWant){
        List<Element> list = e.elements();
        for (int i = 0; i < list.size(); i++) {
            List<Attribute> attributes = list.get(i).attributes();
            for (int j = 0; j < attributes.size(); j++) {
                if(attributes.get(j).getValue().equals(userName)){
                    List<Element> list1 = list.get(i).elements();
                    for (int k = 0; k < list1.size(); k++) {
                        List<Attribute> attributes1 = list1.get(k).attributes();
                        for (int l = 0; l < attributes1.size(); l++) {
                            if(whatYouWant.equals(attributes1.get(l).getName())){
                                return attributes1.get(l).getValue();
                            }
                        }
                    }
                }
            }
        }
        if(list.size()!=0)
        for (int i = 0; i < list.size(); i++)
            return allXML(list.get(i),userName,whatYouWant);
        return null;
    }
    public static void removeUser(String userName) throws DocumentException, UserNameNotExistsException, IOException {
        if (!file.exists()){
            throw new UserNameNotExistsException();
        }
        Document document = saxReader.read(file);
        Element element = document.getRootElement();
        List<Element> elements = element.elements();
        for (Element e :elements) {
            if(e.attribute("userName").getValue().equals(userName)){
                element.remove(e);
            }
        }
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter(file),outputFormat);
        writer.write(document);
        writer.close();
    }

}
