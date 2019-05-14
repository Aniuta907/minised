import java.io.File;
import java.io.StringWriter;
import java.util.List;
//import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBclass {

    public static void write(Person pers) {
        try {
            StringWriter writer = new StringWriter();

            //создание объекта Marshaller, который выполняет сериализацию
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // сама сериализация
            marshaller.marshal(pers, writer);

            //преобразовываем в строку все записанное в StringWriter
            String result = writer.toString();
            System.out.println(result);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> read() {
        List<Person> list = null;
        String str;
        try {
//            Person person = new Person();
//            String xmldata = "    <person>\n" +
//                    "        <id>0001</id>\n" +
//                    "        <lastname>Петров</lastname>\n" +
//                    "        <firstname>Кирилл</firstname>\n" +
//                    "        <patronymic>Александрович</patronymic>\n" +
//                    "        <post>маркетолог</post>\n" +
//                    "    </person>";
            //StringReader reader = new StringReader(xmldata);

            File file = new File("D:\\projects\\minised\\Persons.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Data data = (Data) jaxbUnmarshaller.unmarshal(file);
//            System.out.println(data);

            list=data.getPersons();
//            for(Person per:list) {
//                str = per.toString();
//                System.out.println(str);
//            }
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        return list;
    }
}



