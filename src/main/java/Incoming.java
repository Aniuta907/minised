import java.time.LocalDate;

public class Incoming extends Document {
    String sender; //отправитель
    String recipient; //адресат
    int outgoingNumber; //исходящий номер
    LocalDate outgoingDataReg; //исходящая дата регистрации

    public Incoming(){

    }

    public Incoming(String sender, String recipient, int outgoingNumber,  LocalDate outgoingDataReg) {
        this.sender = sender;
        this.recipient = recipient;
        this.outgoingNumber = outgoingNumber;
        this.outgoingDataReg = outgoingDataReg;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setOutgoingNumber(int outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public void setOutgoingDataReg(LocalDate outgoingDataReg) {
        this.outgoingDataReg = outgoingDataReg;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Incoming{");
        sb.append("sender=").append(sender);
        sb.append(", recipient=").append(recipient);
        sb.append(", outgoingNumber='").append(outgoingNumber).append('\'');
        sb.append(", outgoingDataReg=").append(outgoingDataReg);
        sb.append('}');
        return sb.toString();
    }
}
