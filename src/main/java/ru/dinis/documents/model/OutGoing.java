package ru.dinis.documents.model;

public class OutGoing extends Document {

    private Person destination;

    private String deliveryMethod;


    @Override
    public String toString() {
        return super.toString() + " Адресат: " + this.destination.getName()
                + ". Способ доставки: " + this.deliveryMethod;
    }

    public Person getDestination() {
        return destination;
    }

    public void setDestination(Person destination) {
        this.destination = destination;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
