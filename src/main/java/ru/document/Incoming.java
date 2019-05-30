package ru.document;

import java.time.LocalDate;

public class Incoming extends Document {
    private String sender; //отправитель
    private String recipient; //адресат
    private int incomingNumber; //исходящий номер
    private LocalDate incomingDataReg; //исходящая дата регистрации

    public Incoming(){

    }

    public Incoming(String sender, String recipient, int outgoingNumber,  LocalDate outgoingDataReg) {
        this.sender = sender;
        this.recipient = recipient;
        this.incomingNumber = outgoingNumber;
        this.incomingDataReg = outgoingDataReg;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setIncNumber(int outgoingNumber) {
        this.incomingNumber = outgoingNumber;
    }

    public void setIncDataReg(LocalDate outgoingDataReg) {
        this.incomingDataReg = outgoingDataReg;
    }

    @Override
    public String toString() {
        return "Входящий №" + getID()/*+ ", sender "+sender+", recipient "+recipient+", от "+incomingDataReg*/;
    }
}
