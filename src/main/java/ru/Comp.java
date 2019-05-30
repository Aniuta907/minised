package ru;

import ru.document.Document;
import ru.enumeration.ClassTypes;

import java.time.LocalDate;

class Comp implements Comparable {

    int regNumber; //регистрационный номер документа
    LocalDate dataReg; //дата регистрации документа
    String author; //автор документа
    ClassTypes type;

    Comp(Document doc) {
//        switch(doc.getClass().getName()) {
//            case "Incoming":
//                this.type
//        };
        this.regNumber = doc.getID();
    }

    Comp(int regNumber, LocalDate dataReg, String author) {
        this.regNumber = regNumber;
        this.dataReg = dataReg;
        this.author = author;
    }

    public int compareTo(Object obj) { //значения сортируются сначала по полю regNumber, а затем по dataReg
        Comp entry = (Comp) obj;

        int res = author.compareTo(entry.author);
        if (res != 0) {
            return res / Math.abs(res);
        }

        int result = regNumber - entry.regNumber;
        if (result != 0) {
            return result / Math.abs(result);
        }

        int cmp = dataReg.getYear() - entry.dataReg.getYear();
        if (cmp == 0) {
            cmp = dataReg.getMonthValue() - entry.dataReg.getMonthValue();
            if (cmp == 0) {
                cmp = dataReg.getDayOfMonth() - entry.dataReg.getDayOfMonth();
            }
        }
        if (cmp != 0)
            return cmp;

        return 0;
    }

    public void setType(ClassTypes name) {
        this.type = name;
    }

    @Override
    public String toString() {
        return "Comp{" +
                "regNumber=" + regNumber +
                ", dataReg=" + dataReg +
                ", author='" + author + '\'' +
                '}';
    }
}