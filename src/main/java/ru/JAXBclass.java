package ru;

import ru.staff.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBclass  {
    public static final List<Person> persons = new ArrayList<>();
    static File FILE = new File("D:\\projects\\minised\\Persons.xml");
    public static List<Person> read() throws JAXBException{
        List<Person> list = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Data data = (Data) jaxbUnmarshaller.unmarshal(FILE);

            list=data.getPersons();
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        return list;
    }
}



