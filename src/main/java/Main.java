import com.google.gson.Gson;
import document.Document;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args)
    {
        String str;
//        List<Person> person = null;

        try{
            Document doc1 = Factory.createDocument(ClassTypes.TASK);
//            System.out.println("Автор "+doc1.getAuthor()+":");
//            str = doc1.toString();
//            System.out.println(str);
//            System.out.println("\n");

            Document doc2 = Factory.createDocument(ClassTypes.TASK);
//            System.out.println("Автор "+doc2.getAuthor()+":");
//            str = doc2.toString();
//            System.out.println(str);
//            System.out.println("\n");

            Document doc3 = Factory.createDocument(ClassTypes.INCOMING);
//            System.out.println("Автор "+doc3.getAuthor()+":");
//            str = doc3.toString();
//            System.out.println(str);
//            System.out.println("\n");

            Document doc4 = Factory.createDocument(ClassTypes.OUTGOING);
//            System.out.println("Автор "+doc4.getAuthor()+":");
//            str = doc4.toString();
//            System.out.println(str);
//            System.out.println("\n");

            Collection<Comp> ts = new TreeSet<Comp>();
            ts.add(new Comp(doc1.getID(), doc1.getDataReg(), doc1.getAuthor()));
            ts.add(new Comp(doc2.getID(), doc2.getDataReg(), doc2.getAuthor()));
            ts.add(new Comp(doc3.getID(), doc3.getDataReg(), doc3.getAuthor()));
            ts.add(new Comp(doc4.getID(), doc4.getDataReg(), doc4.getAuthor()));

            for (Comp t : ts) {
//                if (t.author == .author)
                System.out.println("Автор " + t.author + ":");
                System.out.println("regNumber: " + t.regNumber + ", dataReg: " + t.dataReg);
            }

            System.out.println("\n");

            Gson gson = new Gson();
            String json;
            json = gson.toJson(ts);
            System.out.println(json);

        }
        //заканчивает на этом месте работу!!!!!
        catch(DocumentExistsException ex){
            System.out.println("Перехвачено " + ex) ;
        }
    }

}
