package document;

public class Outgoing extends Document {
    private String recipient; //адресат
    private String deliveryMethod; //способ доставки

    public Outgoing(){

    }

    public Outgoing(String recipient, String deliveryMethod) {
        this.recipient = recipient;
        this.deliveryMethod = deliveryMethod;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @Override
    public String toString() {
        return "Исходящий №" + getID()/*+ ", recipient "+recipient+", deliveryMethod "+deliveryMethod*/;
    }


}
