package ru.organization.documents.model.docs;

import ru.organization.documents.model.staff.Person;

import java.util.Date;

/**
 * incoming document.
 */
public class Incoming extends Document {
    /**
     * sender of document.
     */
    private Person sender;

    /**
     * destination of document.
     */
    private Person destination;
    /**
     * outgoing number.
     */
    private String outgoingNumber;

    /**
     * outgoing registration date.
     */
    private Date outRegDate;


    @Override
    public String toString() {
        return super.toString() + "\n         - Отправитель: " + this.sender.getFullName()
                + ".\n         - Адресат: " + this.destination.getFullName()
                + ".\n         - Исходящий номер: " + this.outgoingNumber
                + ".\n         - Исходящая дата регистрации: " + this.outRegDate;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getDestination() {
        return destination;
    }

    public void setDestination(Person destination) {
        this.destination = destination;
    }

    public String getOutgoingNumber() {
        return outgoingNumber;
    }

    public void setOutgoingNumber(String outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public Date getOutRegDate() {
        return outRegDate;
    }

    public void setOutRegDate(Date outRegDate) {
        this.outRegDate = outRegDate;
    }
}
