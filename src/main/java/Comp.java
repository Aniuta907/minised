import java.time.LocalDate;
import java.util.Calendar;
import java.util.TreeSet;

class Comp implements Comparable {

    int regNumber; //регистрационный номер документа
    LocalDate dataReg; //дата регистрации документа

    Comp(int regNumber, LocalDate dataReg) {
        this.regNumber = regNumber;
        this.dataReg = dataReg;
    }


//    public int compareTo(Document anotherDocument) {
//        if (this.regNumber == anotherDocument.regNumber) {
//            return 0;
//        } else if (this.regNumber < anotherDocument.regNumber) {
//            return -1;
//        } else {
//            return 1;
//        }
//    }

 //   @Override
    public int compareTo(Object obj) { //значения сортируются сначала по полю regNumber, а затем по dataReg
        Comp entry = (Comp) obj;

        int result = regNumber - entry.regNumber;
        if (result != 0) {
            return (int) result / Math.abs(result);
        }

        boolean result2 = dataReg.equals(entry.dataReg);
        if (result2 != false) {
            int myInt = result2 ? 1 : 0;
            return myInt;
        }

        return 0;
    }

//    public class Example {
//
//        public void main(String[] args) {
//            TreeSet<Comp> ex = new TreeSet<Comp>();
//            ex.add(new Comp(17701, "10.11.14"));
//            ex.add(new Comp(18000, "10.12.14"));
//            ex.add(new Comp(17001, "21.11.15"));
//            ex.add(new Comp(17001, "20.11.15"));
//
//            for (Comp e : ex) {
//                System.out.println("regNumber: " + e.regNumber + ", dataReg: " + e.dataReg);
//            }
//        }
//    }
}