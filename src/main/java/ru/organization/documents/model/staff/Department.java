package ru.organization.documents.model.staff;

import java.util.List;

/**
 * департамент.
 */
public class Department extends Staff {
    /**
     * полное имя.
     */
    private String fullName;
    /**
     * короткое наименование.
     */
    private String shortName;
    /**
     * руководитель.
     */
    private Person director;
    /**
     * телефоны.
     */
    private String phones;

    /**
     * сотрудники
     */
    private List<Person> persons;

    public Department() {
    }

    @Override
    public String toString() {
        return "   " + this.fullName
                + "\n   " + this.shortName
                + "\n   Директор: " + this.director.getFullName()
                + "\n   тел.: " + this.phones;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
