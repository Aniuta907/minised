import java.time.LocalDate;
public class Main {
    public static void main(String[] args)
    {
        Factory factory = new Factory();
        factory.setTaskArray();
        String str;

        try{
            Document doc1 = factory.createDocument(ClassTypes.TASK);
            System.out.println("Автор "+doc1.getAuthor()+":");
            str = doc1.toString();
            System.out.println(str);

            Document doc2 = factory.createDocument(ClassTypes.TASK);
            System.out.println("Автор "+doc2.getAuthor()+":");
            str = doc2.toString();
            System.out.println(str);

            Document doc3 = factory.createDocument(ClassTypes.INCOMING);
            str = doc3.toString();
            System.out.println("Автор "+doc3.getAuthor()+":");
            System.out.println(str);

            Document doc4 = factory.createDocument(ClassTypes.OUTGOING);
            System.out.println("Автор "+doc4.getAuthor()+":");
            str = doc4.toString();
            System.out.println(str);
        }
        catch(DocumentExistsException ex){
            System.out.println("Перехвачено " + ex) ;
           // System.out.println(ex.getMessage());
        }

    }
}
