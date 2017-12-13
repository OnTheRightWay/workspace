package homework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLDemo {
    private static File file=new File("src\\homework\\xmldata.xml");
    private static SAXReader saxReader = new SAXReader();
    public static void XMLWrite(Person person) throws DocumentException, IOException {
//        Document document = DocumentHelper.createDocument();

        Document document = DocumentHelper.createDocument();
        if (file.exists()){
             document=saxReader.read(file);
        }else {

            document.addElement("Persons");
        }
        Element element = document.getRootElement();
        List<Element> list = element.elements("Person");
        for (Element e :
                list) {
            if (e.attribute("name").getValue().equals(person.getName())) {
                System.out.println("数据已存在");
                return;
            }
        }
        Element p = element.addElement("Person");
        p.addAttribute("name",person.getName());
        Element name = p.addElement("name");
        name.addText(person.getName());
        Element age = p.addElement("age");
        age.addText(String.valueOf(person.getAge()));
        Element gender = p.addElement("gender");
        gender.addText(person.getGender());
        Element job = p.addElement("job");
        job.addText(person.getJob());

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");

        XMLWriter xmlWriter = new XMLWriter(new FileWriter(file),outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();

    }
        public static Person readXML(String name) throws DocumentException {
            String gender = null;
            int age = 0;
            String job = null;
            Document document = saxReader.read(file);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element e : elements) {
                if (e.attribute("name").getValue().equals(name)){
                    gender = e.element("gender").getText();
                    age = Integer.parseInt(e.element("age").getText());
                    job = e.element("job").getText();
                }
            }
            if (job==null){
                System.out.println("不存在");
                return null;
            }
            Person person = new Person(name,age,gender,job);
            return person;
        }
}
