package ru.factory;

import ru.JAXBclass;
import ru.document.Document;
import ru.enumeration.ClassTypes;
import ru.exception.DocumentExistsException;
import ru.staff.Person;
import javax.xml.bind.JAXBException;
import java.util.List;

public class Factory {


    /** Массив ответственных исполнителей*/
    private static String[] RESP_EXECUTIVE_ARR = {"Иванов Иван", "Петр Петров", "Смирнов Олег", "Лебедев Иван"};
    /** Массив контролеров поручений*/
    private static String[] CONTROLLER_INST_ARR = {"Белкин Аркадий", "Сидоров Александр", "Ахметов Артур", "Сулейманов Айдар"};
    /** Массив отправителей*/
    private static String[] SENDER_ARR = {"Букатина Мария", "Гребнев Александр", "Боронилова Нина", "Ковалев Андрей"};
    /** Массив получателей*/
    private static String[] RECIPIENT_ARR = {"Евстигнеева Анжелика", "Петрова Елена", "Белов Михаил", "Козлов Иван"};
    /** Массив способов доставки*/
    private static String[] DELIVERY_METHOD_ARR = {"Почта России", "СДЭК", "Пони-экспресс", "ePacket"};



    public static Document createDocument(ClassTypes type) throws DocumentExistsException, JAXBException {
        Document doc = null;
        JAXBclass jc = new JAXBclass();
        List<Person> person;
        person = jc.read();


        switch (type) {
            case TASK:
                TaskFactory taskF = new TaskFactory();
                doc = taskF.setParameters(person, RESP_EXECUTIVE_ARR, CONTROLLER_INST_ARR);
                break;

            case INCOMING:
                IncomingFactory incomingF = new IncomingFactory();
                doc = incomingF.setParameters(person, SENDER_ARR, RECIPIENT_ARR);
                break;

            case OUTGOING:
                OutgoingFactory outgoingF = new OutgoingFactory();
                doc = outgoingF.setParameters(person, RECIPIENT_ARR, DELIVERY_METHOD_ARR);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return doc;
    }

}
