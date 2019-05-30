package ru.factory;

import ru.RandomDate;
import ru.document.Document;
import ru.document.Incoming;
import ru.exception.DocumentExistsException;
import ru.staff.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IncomingFactory implements FactoryInterface {
    /**
     * Список уже существующих id входящих документов
     */
    static List<Integer> incomingList = new ArrayList();

    public Document setParameters(List<Person> person, String[] SENDER_ARR, String[] RECIPIENT_ARR) throws DocumentExistsException {

        Incoming doc = new Incoming();
        Random irandom = new Random();
        FactoryInterface.setRandID(doc, (ArrayList) incomingList);

        RandomDate rdr2 = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
        doc.setDataReg(rdr2.nextDate());

        int rs = irandom.nextInt(SENDER_ARR.length);
        ((Incoming) doc).setSender(SENDER_ARR[rs]);

        int rai = irandom.nextInt(person.size());
        doc.setAuthor(person.get(rai).getPersonLastName());

        int rr = irandom.nextInt(RECIPIENT_ARR.length);
        ((Incoming) doc).setRecipient(RECIPIENT_ARR[rr]);

        int rn = irandom.nextInt(100);
        ((Incoming) doc).setIncNumber(rn);

        RandomDate randdr = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
        ((Incoming) doc).setIncDataReg(randdr.nextDate());

        return doc;
    }

    @Override
    public Document createInstance() {
        return null;
    }
}
