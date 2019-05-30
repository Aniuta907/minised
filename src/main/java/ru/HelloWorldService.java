package ru;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.document.Document;
import ru.document.Task;
import ru.enumeration.ClassTypes;
import ru.factory.Factory;
import ru.staff.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

@Path("/ecm")
public class HelloWorldService {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);
    private static Collection<Comp> documents = new TreeSet<>();
    public static final List<String> inf = new ArrayList<>();

    static {
        try {
            for (int i = 0; i < 100; i++) {
                Document doc = Factory.createDocument(ClassTypes.TASK);
                Comp comp = new Comp(doc.getID(), doc.getDataReg(), doc.getAuthor());
                comp.setType(ClassTypes.TASK);
                documents.add(comp);
            }
            for (int i = 0; i < 100; i++) {
                Document doc = Factory.createDocument(ClassTypes.INCOMING);
                Comp comp = new Comp(doc.getID(), doc.getDataReg(), doc.getAuthor());
                comp.setType(ClassTypes.INCOMING);
                documents.add(comp);
            }
            for (int i = 0; i < 100; i++) {
                Document doc = Factory.createDocument(ClassTypes.OUTGOING);
                Comp comp = new Comp(doc.getID(), doc.getDataReg(), doc.getAuthor());
                comp.setType(ClassTypes.OUTGOING);
                documents.add(comp);
            }
        } catch (Exception e) {
            logger.error("Произошла критическая ошибка при создании документов");
        }
    }

    @GET
    @Path("/employees")
    @Produces("text/html; charset=UTF-8")
    public Response getExecutors(){
        Gson gson = new Gson();
        String json = gson.toJson(JAXBclass.persons);
        return Response.status(200).entity(json).build();
    }

    @GET
    @Path("/employees/{id}")
    @Produces("text/html; charset=UTF-8")
    public Response getEmpl(@PathParam("id") int id) {
        try {
            String typeDoc = "";
            String result = "";
            List<Person> persons = JAXBclass.persons;
            logger.info("Были найдены следующие employees {}", persons);
            String name = JAXBclass.persons.get(id).getPersonLastName();
            Gson gson = new Gson();
            inf.clear();
            for (Comp t : documents) {
                if (t.author.equals(name)) {
                    if (t.type.toString().equals("TASK"))
                        typeDoc = "Поручение";
                    else if (t.type.toString().equals("OUTGOING"))
                        typeDoc = "Исходящий";
                    else
                        typeDoc = "Входящий";
                    inf.add(typeDoc+ ", regNumber: " + t.regNumber + ", dataReg: " + t.dataReg);
                }
            }
            String json = gson.toJson(inf);
            result = json;
            return Response.status(200).entity("Автор " + name + ":  "+result).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getStackTrace()).build();
        }
    }

}

