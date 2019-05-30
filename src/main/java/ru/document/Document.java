package ru.document;

import java.time.LocalDate;

public abstract class Document {
    protected int id; //идентификатор документа
    protected String documentName; //название документа
    protected String documentText; //текст документа
    protected int regNumber; //регистрационный номер документа
    protected LocalDate dataReg; //дата регистрации документа
    protected String author; //автор документа
    protected String docType;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        if (id < 0) throw new IllegalArgumentException();
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getDataReg() {
        return dataReg;
    }

    public void setDataReg(LocalDate dataReg) {
        this.dataReg = dataReg;
    }

    public String toString() {
        return "documentID=" + id + ", documentName=" + documentName +", regNumber="+regNumber+", dataReg="+dataReg+", authorName="+author;
    }

}