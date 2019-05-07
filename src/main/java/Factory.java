import document.Document;
import document.Incoming;
import document.Outgoing;
import document.Task;

import java.time.LocalDate;
import java.util.Random;
//import java.util.Arrays;
import java.util.ArrayList;

public class Factory {

    static ArrayList<Integer> taskList = new ArrayList();
    static ArrayList<Integer> incomingList = new ArrayList();
    static ArrayList<Integer> outgoingList = new ArrayList();


    private static String[] respExecutiveArr = {"Иванов Иван", "Петр Петров", "Смирнов Олег", "Лебедев Иван"};
    private static String[] authorArr = {"Иванов Иван", "Петр Петров", "Смирнов Олег", "Лебедев Иван"};
    private static String[] controllerInstArr = {"Белкин Аркадий", "Сидоров Александр", "Ахметов Артур", "Сулейманов Айдар"};
    private static String[] senderArr = {"Букатина Мария", "Гребнев Александр", "Боронилова Нина", "Ковалев Андрей"};
    private static String[] recipientArr = {"Евстигнеева Анжелика", "Петрова Елена", "Белов Михаил", "Козлов Иван"};
    private static String[] deliveryMethodArr = {"Почта России", "СДЭК", "Пони-экспресс"};



    public static void setRandID(Document doc, ArrayList list) throws DocumentExistsException{
        Random random = new Random();
        int rnd;
        boolean flag = false;

        while (flag == false) {
            rnd = random.nextInt(100);
            if (list.contains(rnd)){
                throw new DocumentExistsException("Document with number"+ rnd + "already exists");
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

        switch (type) {
            case TASK:
                doc = new Task();
                setRandID(doc, taskList);

                int re = random.nextInt(4);
                ((Task)doc).setRespExecutive(respExecutiveArr[re]);

                int ra = random.nextInt(4);
                doc.setAuthor(authorArr[ra]);

                RandomDate rd = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
                ((Task)doc).setDataExtradition(rd.nextDate());

                int rsc = random.nextInt(2);
                ((Task)doc).setSignControl(rsc);

                int rс = random.nextInt(4);
                ((Task)doc).setСontroller(controllerInstArr[rс]);

                break;

            case INCOMING:
                doc = new Incoming();
                setRandID(doc, incomingList);

                int rs = random.nextInt(4);
                ((Incoming)doc).setSender(senderArr[rs]);

                int rai = random.nextInt(4);
                doc.setAuthor(authorArr[rai]);

                int rr = random.nextInt(4);
                ((Incoming)doc).setRecipient(recipientArr[rr]);

                int rn = random.nextInt(100);
                ((Incoming)doc).setOutgoingNumber(rn);

                RandomDate rdr = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
                ((Incoming)doc).setOutgoingDataReg(rdr.nextDate());

                break;

            case OUTGOING:
                doc = new Outgoing();
                setRandID(doc, outgoingList);

                int rao = random.nextInt(4);
                doc.setAuthor(authorArr[rao]);

                int rr2 = random.nextInt(4);
                ((Outgoing)doc).setRecipient(recipientArr[rr2]);

                int rdm = random.nextInt(4);
                ((Outgoing)doc).setDeliveryMethod(deliveryMethodArr[rdm]);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return doc;
    }

}
