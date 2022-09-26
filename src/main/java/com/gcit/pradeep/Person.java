package com.gcit.pradeep;
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.String;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@XmlRootElement
public class Person {
    private String Name;
    private int Age;
    private char Sex;
    private int YOB;

    @XmlElement
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    @XmlElement
    public int getAge() {
        return Age;
    }


    public void setAge(int age) {
        Age = age;
    }

    @XmlElement
    public char getSex() {
        return Sex;
    }

    public void setSex(char sex) {
        Sex = sex;
    }

    @XmlElement
    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public Person() {

    }
    private static final Logger logger = LogManager.getLogger(Person.class);
    public Person(String name, int age, char sex, int YOB) {
        this.Name = name;
        this.Age = age;
        this.Sex = sex;
        this.YOB = YOB;
    }

    public String Write(String xmlFileName) {

        String line;
        StringBuilder sb = new StringBuilder();
        try {
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(Person.class);
            //creating the marshaller object
            Marshaller marshallObj = jContext.createMarshaller();
            //setting the property to show xml format output
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallObj.setProperty(Marshaller.JAXB_ENCODING, "US-ASCII");
            //setting the values in POJO class
            Person person = new Person(this.getName(), this.getAge(), this.getSex(), this.getYOB());
            //calling the marshall method
            marshallObj.marshal(person, new FileOutputStream("D:/Java Course/Learnings/"+ xmlFileName +".xml"));
            //Reading the Created xml file and convert it to string
            BufferedReader br = new BufferedReader(new FileReader("D:/Java Course/Learnings/"+ xmlFileName +".xml"));
            while((line=br.readLine())!= null){
                sb.append(line.trim());
                sb.append("\n");
            }

        } catch (Exception e) {

            {
                logger.info(e.getMessage());
            }

        }
       //return sb.toString();
        return sb.toString();
    }

    public static Person Read(String xmlFilePath) {
        Person p = new Person();
        try
        {
            File file = new File("D:/Java Course/Learnings/"+ xmlFilePath +".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            p = (Person) jaxbUnmarshaller.unmarshal(file);
        } catch
        (Exception e)
        {
            logger.info(e.getMessage());
        }

        return p;
    }
    @Override
    public String toString() {
        return "name : "+ this.getName() +" \nAge : " + this.getAge() + "\nSex : " + this.getSex() + "\nYOB  : " + this.getYOB() ;
    }

    }


