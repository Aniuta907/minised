package ru.factory;

import ru.RandomDate;
import ru.document.Document;
import ru.document.Task;
import ru.exception.DocumentExistsException;
import ru.staff.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskFactory implements FactoryInterface{
    /** Список уже существующих id поручений*/
    static List<Integer> taskList = new ArrayList();

    public Document setParameters(List<Person> person, String[] RESP_EXECUTIVE_ARR, String[] CONTROLLER_INST_ARR) throws DocumentExistsException {
        Task doc = new Task();
        Random random = new Random();
        FactoryInterface.setRandID(doc, (ArrayList) taskList);

        int re = random.nextInt(RESP_EXECUTIVE_ARR.length);
        ((Task)doc).setRespExecutive(RESP_EXECUTIVE_ARR[re]);

        int ra = random.nextInt(person.size());
        doc.setAuthor(person.get(ra).getPersonLastName());

        RandomDate rd = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
        ((Task)doc).setDataExtradition(rd.nextDate());

        RandomDate rdr = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
        doc.setDataReg(rdr.nextDate());

        int rsc = random.nextInt(2);
        ((Task)doc).setSignControl(rsc);

        int rс = random.nextInt(CONTROLLER_INST_ARR.length);
        ((Task)doc).setСontroller(CONTROLLER_INST_ARR[rс]);

        return doc;
    }

    @Override
    public Document createInstance() {
        return null;
    }
}
