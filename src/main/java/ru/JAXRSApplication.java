package ru;

import ru.staff.Person;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.xml.bind.JAXBException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationPath("/")
public class JAXRSApplication extends Application {

    public JAXRSApplication() {
        try {
            JAXBclass.persons.addAll(JAXBclass.read());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(HelloWorldService.class);
        return classes;
    }
}
