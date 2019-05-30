package ru.factory;

import ru.RandomDate;
import ru.document.Document;
import ru.document.Outgoing;
import ru.exception.DocumentExistsException;
import ru.staff.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OutgoingFactory implements FactoryInterface{
    /** Список уже существующих id исходящих документов*/
    static List<Integer> outgoingList = new ArrayList();

    public Document setParameters(List<Person> person, String[] RECIPIENT_ARR, String[] DELIVERY_METHOD_ARR) throws DocumentExistsException {
        Outgoing doc = new Outgoing();
        Random orandom = new Random();
        FactoryInterface.setRandID(doc, (ArrayList) outgoingList);

        RandomDate rdr3 = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
        doc.setDataReg(rdr3.nextDate());

        int rao = orandom.nextInt(person.size());
        doc.setAuthor(person.get(rao).getPersonLastName());

        int rr2 = orandom.nextInt(RECIPIENT_ARR.length);
        ((Outgoing)doc).setRecipient(RECIPIENT_ARR[rr2]);

        int rdm = orandom.nextInt(DELIVERY_METHOD_ARR.length);
        ((Outgoing)doc).setDeliveryMethod(DELIVERY_METHOD_ARR[rdm]);

        return doc;
    }

    @Override
    public Document createInstance() {
        return null;
    }
}
