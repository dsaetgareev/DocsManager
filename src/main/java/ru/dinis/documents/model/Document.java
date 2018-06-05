package ru.dinis.documents.model;

import java.util.Date;

public abstract class Document implements Comparable<Document> {

    private int id;

    private String name;

    private String describe;

    private String regNumber;

    private Date regDate;

    private Person author;


    public int compareTo(Document o) {
        return this.regNumber.compareTo(o.getRegNumber());
    }

    @Override
    public String toString() {
        return this.name + " " + this.regNumber + " от " + this.regDate + " "
                + this.describe + " ####";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }
}
