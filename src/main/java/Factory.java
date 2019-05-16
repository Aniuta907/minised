import document.Document;
import document.Incoming;
import document.Outgoing;
import document.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Factory {

    static ArrayList<Integer> taskList = new ArrayList();
    static ArrayList<Integer> incomingList = new ArrayList();
    static ArrayList<Integer> outgoingList = new ArrayList();

    private static String[] RESPEXECUTIVEARR = {"Иванов Иван", "Петр Петров", "Смирнов Олег", "Лебедев Иван"};
    private static String[] CONTROLLERINSTARR = {"Белкин Аркадий", "Сидоров Александр", "Ахметов Артур", "Сулейманов Айдар"};
    private static String[] SENDERARR = {"Букатина Мария", "Гребнев Александр", "Боронилова Нина", "Ковалев Андрей"};
    private static String[] RECIPIENTARR = {"Евстигнеева Анжелика", "Петрова Елена", "Белов Михаил", "Козлов Иван"};
    private static String[] DELIVERYMETHODARR = {"Почта России", "СДЭК", "Пони-экспресс", "ePacket"};


    public static void setRandID(Document doc, ArrayList list) throws DocumentExistsException{
        Random random = new Random();
        int rnd;
        boolean flag = false;

        while (flag == false) {
            rnd = random.nextInt(100);
            if (list.contains(rnd)){
                throw new DocumentExistsException("Document with number "+ rnd + " already exists");
            }
            else {
                doc.setID(rnd);
                list.add(rnd);
                flag = true;
            }
        }
    }


    public static Document createDocument(ClassTypes type) throws DocumentExistsException{
        Document doc;
        Random random = new Random();
        JAXBclass jc = new JAXBclass();
        List<Person> person;
        person = jc.read();


        switch (type) {
            case TASK:
                doc = new Task();
                setRandID(doc, taskList);

                int re = random.nextInt(4);
                ((Task)doc).setRespExecutive(RESPEXECUTIVEARR[re]);

                int ra = random.nextInt(4);
                doc.setAuthor(person.get(ra).getPersonLastName());

                RandomDate rd = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
                ((Task)doc).setDataExtradition(rd.nextDate());

                RandomDate rdr = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
                doc.setDataReg(rdr.nextDate());

                int rsc = random.nextInt(2);
                ((Task)doc).setSignControl(rsc);

                int rс = random.nextInt(4);
                ((Task)doc).setСontroller(CONTROLLERINSTARR[rс]);

                break;

            case INCOMING:
                doc = new Incoming();
                setRandID(doc, incomingList);

                RandomDate rdr2 = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
                doc.setDataReg(rdr2.nextDate());

                int rs = random.nextInt(4);
                ((Incoming)doc).setSender(SENDERARR[rs]);

                int rai = random.nextInt(4);
                doc.setAuthor(person.get(rai).getPersonLastName());

                int rr = random.nextInt(4);
                ((Incoming)doc).setRecipient(RECIPIENTARR[rr]);

                int rn = random.nextInt(100);
                ((Incoming)doc).setIncNumber(rn);

                RandomDate randdr = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
                ((Incoming)doc).setIncDataReg(randdr.nextDate());

                break;

            case OUTGOING:
                doc = new Outgoing();
                setRandID(doc, outgoingList);

                RandomDate rdr3 = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
                doc.setDataReg(rdr3.nextDate());

                int rao = random.nextInt(4);
                doc.setAuthor(person.get(rao).getPersonLastName());

                int rr2 = random.nextInt(4);
                ((Outgoing)doc).setRecipient(RECIPIENTARR[rr2]);

                int rdm = random.nextInt(4);
                ((Outgoing)doc).setDeliveryMethod(DELIVERYMETHODARR[rdm]);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return doc;
    }

}
