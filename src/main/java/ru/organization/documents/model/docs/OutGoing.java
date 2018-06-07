package ru.organization.documents.model.docs;

import ru.organization.documents.model.staff.Person;

/**
 * исходящий документ.
 */
public class OutGoing extends Document {

    /**
     * адресат.
     */
    private Person destination;
    /**
     * метод отправки.
     */
    private String deliveryMethod;


    @Override
    public String toString() {
        return super.toString() + "\n         - Адресат: " + this.destination.getFullName()
                + ".\n         - Способ доставки: " + this.deliveryMethod;
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
