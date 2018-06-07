package ru.organization.documents.model.docs;

import ru.organization.documents.model.staff.Person;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * abstract class Document.
 */
@XmlRootElement
public abstract class Document implements Comparable<Document> {
    /**
     * id of document.
     */
    private int id;

    /**
     * name of document.
     */
    private String name;

    /**
     * describe of document.
     */
    private String describe;

    /**
     * registration number of document.
     */
    private String regNumber;

    /**
     * registration date of document.
     */
    private Date regDate;

    /**
     * author of document.
     */
    private Person author;

    /**
     * method for comparable.
     * @param o - object
     * @return - number
     */
    public int compareTo(Document o) {
        return this.regNumber.compareTo(o.getRegNumber());
    }

    /**
     * override toString().
     * @return string
     */
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
