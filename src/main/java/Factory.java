import java.time.LocalDate;
import java.util.Random;
import java.util.Arrays;

public class Factory {

    private static int[] taskArray = new int [100];
    static int taskIndex = 0;

    private static String[] respExecutiveArr = {"Иванов Иван", "Петр Петров", "Смирнов Олег", "Лебедев Иван"};
    private static String[] authorArr = {"Иванов Иван", "Петр Петров", "Смирнов Олег", "Лебедев Иван"};
    private static String[] controllerInstArr = {"Белкин Аркадий", "Сидоров Александр", "Ахметов Артур", "Сулейманов Айдар"};
    private static String[] senderArr = {"Букатина Мария", "Гребнев Александр", "Боронилова Нина", "Ковалев Андрей"};
    private static String[] recipientArr = {"Евстигнеева Анжелика", "Петрова Елена", "Белов Михаил", "Козлов Иван"};
    private static String[] deliveryMethodArr = {"Почта России", "СДЭК", "Пони-экспресс"};

    public Factory(){

    }

    public static void bubbleSort(int[] arr){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            if( arr[j] > arr[j+1] ){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }
}
    public void setTaskArray() {
        for (int i = 0; i < taskArray.length; i++)
            taskArray[i] = -1;
    }

    public void getTaskArray() {
        for (int i = 0; i < taskArray.length; i++)
        System.out.print(" "+taskArray[i]);
    }

    public static Document createDocument(ClassTypes type) throws DocumentExistsException{
        Document doc = null;
        Random random = new Random();

        switch (type) {
            case TASK:
                doc = new Task();
                int rnd;
                boolean flag = false;

               while (flag == false) {
                   bubbleSort(taskArray);
                    rnd = random.nextInt(100);

                   if (Arrays.binarySearch(taskArray, rnd) >= 0){
                       System.out.println(rnd);
                       throw new DocumentExistsException("Document with this number already exists");
                   }
                    else {
                        doc.setID(rnd);
                        taskArray[taskIndex] = rnd;
                        taskIndex++;
                        //System.out.println(doc.getID());
                        flag = true;
                    }
               }

                int re = random.nextInt(4);
                ((Task)doc).setRespExecutive(respExecutiveArr[re]);

                int ra = random.nextInt(4);
                doc.setAuthor(authorArr[ra]);
                //System.out.println(doc.getAuthor());

                RandomDate rd = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
                ((Task)doc).setDataExtradition(rd.nextDate());

                int rsc = random.nextInt(2);
                ((Task)doc).setSignControl(rsc);

                int rс = random.nextInt(4);
                ((Task)doc).setСontroller(controllerInstArr[rс]);

                break;

            case INCOMING:
                doc = new Incoming();

                int rs = random.nextInt(4);
                ((Incoming)doc).setSender(senderArr[rs]);

                int rr = random.nextInt(4);
                ((Incoming)doc).setRecipient(recipientArr[rr]);

                int rn = random.nextInt(100);
                ((Incoming)doc).setOutgoingNumber(rn);

                RandomDate rdr = new RandomDate(LocalDate.of(2010, 1, 1), LocalDate.of(2019, 1, 1));
                ((Incoming)doc).setOutgoingDataReg(rdr.nextDate());

                break;

            case OUTGOING:
                doc = new Outgoing();

                int rr2 = random.nextInt(4);
                ((Outgoing)doc).setRecipient(recipientArr[rr2]);

                int rdm = random.nextInt(4);
                ((Outgoing)doc).setDeliveryMethod(deliveryMethodArr[rdm]);
                break;
        }
        return doc;
    }

}
