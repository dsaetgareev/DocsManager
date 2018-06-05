package ru.dinis.documents.model;

import java.util.Date;

public class Incoming extends Document {

    private Person sender;

    private Person destination;

    private String outgoingNumber;

    private Date outRegDate;


    @Override
    public String toString() {
        return super.toString() + " Отправитель: " + this.sender.getName()
                + ". Адресат: " + this.destination.getName()
                + ". Исходящий номер: " + this.outgoingNumber
                + ". Исходящая дата регистрации: " + this.outRegDate;
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
